# Azure Identity client library for Java
The Azure Identity library provides Azure Active Directory token authentication support across the Azure SDK. It provides a set of TokenCredential implementations which can be used to construct Azure SDK clients which support AAD token authentication.  
 
 This library is in preview and currently supports:
  - [Service principal authentication](https://docs.microsoft.com/en-us/azure/active-directory/develop/app-objects-and-service-principals)
  - [Managed identity authentication](https://docs.microsoft.com/en-us/azure/active-directory/managed-identities-azure-resources/overview)

  [Source code][source] | API reference documentation (Coming Soon) | [Azure Active Directory documentation][aad_doc]

## Getting started
### Adding the package to your project

Maven dependency for Azure Secret Client library. Add it to your project's pom file.
```xml
<dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-identity</artifactId>
    <version>1.0.0-preview.1</version>
</dependency>
```

### Prerequisites
* An [Azure subscription][azure_sub].
* An existing Azure Active Directory service principal. If you need to create a service principal, you can use the Azure Portal or [Azure CLI][azure_cli].

#### Creating a Service Principal with the Azure CLI
Use the [Azure CLI][azure_cli] snippet below to create/get client secret credentials.

 * Create a service principal and configure its access to Azure resources:
    ```bash
    az ad sp create-for-rbac -n <your-application-name> --skip-assignment
    ```
    Output:
    ```json
    {
        "appId": "generated-app-ID",
        "displayName": "dummy-app-name",
        "name": "http://dummy-app-name",
        "password": "random-password",
        "tenant": "tenant-ID"
    }
    ```
* Use the returned credentials above to set  **AZURE_CLIENT_ID**(appId), **AZURE_CLIENT_SECRET**(password) and **AZURE_TENANT_ID**(tenant) [environment variables](#environment-variables).


## Key concepts
### Credentials

A credential is a class which contains or can obtain the data needed for a service client to authenticate requests. Service clients across Azure SDK accept credentials when they are constructed and use those credentials to authenticate requests to the service.Azure Identity offers a variety of credential classes in the `azure-identity` package capable of acquiring an AAD token. All of these credential classes are implementations of the `TokenCredential` abstract class in [Azure Core][azure_core_library], and can be used by any service client which can be constructed with a `TokenCredential`. 


The credential types in Azure Identity differ in the types of AAD identities they can authenticate and how they are configured: 

|credential class|identity|configuration
|-|-|-
|`DefaultAzureCredential`|service principal or managed identity|none for managed identity; [environment variables](#environment-variables) for service principal
|`ManagedIdentityCredential`|managed identity|constructor parameters
|`EnvironmentCredential`|service principal|[environment variables](#environment-variables)
|`ClientSecretCredential`|service principal|constructor parameters
|`ClientCertificateCredential`|service principal|constructor parameters

Credentials can be chained together to be tried in turn until one succeeds using the `ChainedTokenCredential`; see [chaining credentials](#chaining-credentials) for details.

## DefaultAzureCredential
`DefaultAzureCredential` is appropriate for most scenarios where the application is intended to run in the Azure Cloud. This is because the `DefaultAzureCredential` determines the appropriate credential type based of the environment it is executing in. It supports authenticating both as a service principal or managed identity, and can be configured so that it will work both in a local development environment or when deployed to the cloud. 

The `DefaultAzureCredential` will first attempt to authenticate using credentials provided in the environment. In a development environment you can authenticate as a service principal with the `DefaultAzureCredential` by providing configuration in environment variables as described in the next section.

If the environment configuration is not present or incomplete, the `DefaultAzureCredential` will then determine if a managed identity is available in the current environment.  Authenticating as a managed identity requires no configuration, but does
require platform support. See the
[managed identity documentation](https://docs.microsoft.com/en-us/azure/active-directory/managed-identities-azure-resources/services-support-managed-identities) for more details on this.

## Environment variables

`DefaultAzureCredential` and `EnvironmentCredential` are configured for service
principal authentication with these environment variables:

|variable name|value
|-|-
|`AZURE_CLIENT_ID`|service principal's app id
|`AZURE_TENANT_ID`|id of the principal's Azure Active Directory tenant
|`AZURE_CLIENT_SECRET`|one of the service principal's client secrets

# Examples

## Authenticating with `DefaultAzureCredential`
This example demonstrates authenticating the `SecretClient` from the [azure-keyvault-secrets][secrets_client_library] client library using the `DefaultAzureCredential`.
```java
// The default credential first checks environment variables for configuration as described above.
// If environment configuration is incomplete, it will try managed identity.
import com.azure.identity.credential.DefaultAzureCredential;
import com.azure.security.keyvault.secrets.SecretClient;

DefaultAzureCredential defaultCredential = new DefaultAzureCredential();

// Azure SDK client builders accept the credential as a parameter

SecretClient client = SecretClient.builder()
    .endpoint("https://{YOUR_VAULT_NAME}.vault.azure.net")
    .credential(credential)
    .build();
```
When executing this in a development machine you need to first [configure the environment](#environment-variables) setting the variables `AZURE_CLIENT_ID`, `AZURE_TENANT_ID` and `AZURE_CLIENT_SECRET` to the appropriate values for your service principal.

## Authenticating a service principal with a client secret
This example demonstrates authenticating the `KeyClient` from the [azure-keyvault-keys][keys_client_library] client library using the `ClientSecretCredential`.
```java
// using a client secret
import com.azure.identity.credential.ClientSecretCredential;
import com.azure.security.keyvault.keys.KeyClient;

// authenticate with client secret,
ClientSecretCredential clientSecretCredential = new ClientSecretCredential()
	    .clientId("<YOUR_CLIENT_ID>")
	    .clientSecret("<YOUR_CLIENT_SECRET>")
	    .tenantId("<YOUR_TENANT_ID>");

KeyClient client = KeyClient.builder()
    .endpoint("https://{YOUR_VAULT_NAME}.vault.azure.net")
    .credential(clientSecretCredential)
    .build();
```

## Chaining credentials:
The `ChainedTokenCredential` class provides the ability to link together multiple credential instances to be tried sequentially when authenticating. The following example demonstrates creating a credential which will attempt to authenticate using managed identity, and fall back to certificate authentication if a managed identity is unavailable in the current environment. This example authenticates an `EventHubClient` from the [azure-eventhubs][eventhubs_client_library] client library using the `ChainedTokenCredential`.

```java
import com.azure.identity.credential.ClientSecretCredential;
import com.azure.security.keyvault.secrets.SecretClient;

ManagedIdentityCredential managedIdentityCredential = new ManagedIdentityCredential()
        .clientId("<YOUR_CLIENT_ID>");

ClientSecretcredential secondServicePrincipal = new ClientSecretCredential()
	    .clientId("<YOUR_CLIENT_ID>")
	    .clientSecret("<YOUR_CLIENT_SECRET>")
	    .tenantId("<YOUR_TENANT_ID>");

// when an access token is requested, the chain will try each
// credential in order, stopping when one provides a token

ChainedTokenCredential credentialChain = new ChainedTokenCredential()
		.addLast(managedIdentityCredential)
		.addLast(secondServicePrincipal);

// the chain can be used anywhere a credential is required

// The fully qualified host name for the Event Hubs namespace. This is likely to be similar to:
// {your-namespace}.servicebus.windows.net
String host = "<< EVENT HUBS HOST >>"
String eventHubPath = "<< NAME OF THE EVENT HUB >>";
EventHubClient client = new EventHubClientBuilder()
    .credential(host, eventHubPath, credentialChain)
    .buildAsyncClient();
```

## Troubleshooting
Credentials raise exceptions when they fail to authenticate. `ClientAuthenticationException` has a `message` attribute which
describes why authentication failed. When raised by `ChainedTokenCredential`, the message collects error messages from each credential in the chain.

## Next steps
Currently the following client libraries support authenticating with `TokenCredential` and the Azure Identity library.  You can learn more about their use, and find additional documentation on use of these client libraries along samples with can be found in the links below.

- [azure-eventhubs][eventhubs_client_library]
- [azure-keyvault-keys][keys_client_library]
- [azure-keyvault-secrets][secrets_client_library]

## Contributing
This project welcomes contributions and suggestions. Most contributions require you to agree to a Contributor License Agreement (CLA) declaring that you have the right to, and actually do, grant us the rights to use your contribution. For details, visit https://cla.microsoft.com.

When you submit a pull request, a CLA-bot will automatically determine whether you need to provide a CLA and decorate the PR appropriately (e.g., label, comment). Simply follow the instructions provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct][code_of_conduct]. For more information see the Code of Conduct FAQ or contact opencode@microsoft.com with any additional questions or comments.

<!-- LINKS -->
[azure_cli]: https://docs.microsoft.com/cli/azure
[azure_sub]: https://azure.microsoft.com/free/
[source]: https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/identity/azure-identity
[aad_doc]: https://docs.microsoft.com/en-us/azure/active-directory/
[code_of_conduct]: https://opensource.microsoft.com/codeofconduct/
[keys_client_library]: https://github.com/Azure/azure-sdk-for-java/tree/master/keyvault/client/keys/
[secrets_client_library]: https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/keyvault/client/secrets/
[eventhubs_client_library]: https://github.com/Azure/azure-sdk-for-java/tree/master/eventhubs/client/
[azure_core_library]: https://github.com/Azure/azure-sdk-for-java/tree/master/core/