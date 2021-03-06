// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.models.CategorizedEntity;
import com.azure.ai.textanalytics.models.DetectLanguageInput;
import com.azure.ai.textanalytics.models.DetectLanguageResult;
import com.azure.ai.textanalytics.models.DetectedLanguage;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.ai.textanalytics.models.ExtractKeyPhraseResult;
import com.azure.ai.textanalytics.models.SentenceSentiment;
import com.azure.ai.textanalytics.models.TextAnalyticsApiKeyCredential;
import com.azure.ai.textanalytics.models.TextAnalyticsRequestOptions;
import com.azure.ai.textanalytics.models.TextDocumentBatchStatistics;
import com.azure.ai.textanalytics.models.TextDocumentInput;
import com.azure.ai.textanalytics.util.TextAnalyticsPagedFlux;

import java.util.Arrays;
import java.util.List;

/**
 * Code snippet for {@link TextAnalyticsAsyncClient}
 */
public class TextAnalyticsAsyncClientJavaDocCodeSnippets {
    TextAnalyticsAsyncClient textAnalyticsAsyncClient = createTextAnalyticsAsyncClient();

    /**
     * Code snippet for creating a {@link TextAnalyticsAsyncClient}
     *
     * @return The TextAnalyticsAsyncClient object
     */
    public TextAnalyticsAsyncClient createTextAnalyticsAsyncClient() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.instantiation
        TextAnalyticsAsyncClient textAnalyticsAsyncClient = new TextAnalyticsClientBuilder()
            .apiKey(new TextAnalyticsApiKeyCredential("{api_key}"))
            .endpoint("{endpoint}")
            .buildAsyncClient();
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.instantiation
        return textAnalyticsAsyncClient;
    }

    /**
     * Code snippet for updating the existing API key.
     */
    public void rotateApiKey() {
        // BEGIN: com.azure.ai.textanalytics.models.TextAnalyticsApiKeyCredential
        TextAnalyticsApiKeyCredential credential =
            new TextAnalyticsApiKeyCredential("{api_key}");

        TextAnalyticsAsyncClient textAnalyticsAsyncClient = new TextAnalyticsClientBuilder()
            .apiKey(credential)
            .endpoint("{endpoint}")
            .buildAsyncClient();

        credential.updateCredential("{new_api_key}");
        // END: com.azure.ai.textanalytics.models.TextAnalyticsApiKeyCredential
    }

    // Languages

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#detectLanguage(String)}
     */
    public void detectLanguage() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguage#string
        String inputText = "Bonjour tout le monde";
        textAnalyticsAsyncClient.detectLanguage(inputText).subscribe(detectedLanguage ->
            System.out.printf("Detected language name: %s, ISO 6391 Name: %s, score: %f.%n",
                detectedLanguage.getName(), detectedLanguage.getIso6391Name(), detectedLanguage.getScore()));
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguage#string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#detectLanguage(String, String)}
     */
    public void detectLanguageWithCountryHint() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguage#string-string
        String input = "This text is in English";
        String countryHint = "US";
        textAnalyticsAsyncClient.detectLanguage(input, countryHint).subscribe(detectedLanguage ->
            System.out.printf("Detected language name: %s, ISO 6391 Name: %s, score: %f.%n",
                detectedLanguage.getName(), detectedLanguage.getIso6391Name(), detectedLanguage.getScore()));
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguage#string-string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#detectLanguageBatch(Iterable)}
     */
    public void detectLanguageStringList() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguageBatch#Iterable
        final List<String> textInputs = Arrays.asList(
            "This is written in English", "Este es un documento  escrito en Español.");
        textAnalyticsAsyncClient.detectLanguageBatch(textInputs).byPage().subscribe(batchResult -> {
            // Batch statistics
            final TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
            System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());
            // Batch result of languages
            for (DetectLanguageResult detectLanguageResult : batchResult.getElements()) {
                DetectedLanguage detectedLanguage = detectLanguageResult.getPrimaryLanguage();
                System.out.printf("Detected language name: %s, ISO 6391 Name: %s, score: %f.%n",
                    detectedLanguage.getName(), detectedLanguage.getIso6391Name(), detectedLanguage.getScore());
            }
        });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguageBatch#Iterable
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#detectLanguageBatch(Iterable, String)}
     */
    public void detectLanguageStringListWithCountryHint() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguageBatch#Iterable-String
        List<String> textInputs1 = Arrays.asList(
            "This is written in English",
            "Este es un documento  escrito en Español."
        );
        textAnalyticsAsyncClient.detectLanguageBatch(textInputs1, "US").byPage().subscribe(
            batchResult -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());
                // Batch result of languages
                for (DetectLanguageResult detectLanguageResult : batchResult.getElements()) {
                    DetectedLanguage detectedLanguage = detectLanguageResult.getPrimaryLanguage();
                    System.out.printf("Detected language name: %s, ISO 6391 Name: %s, score: %f.%n",
                        detectedLanguage.getName(), detectedLanguage.getIso6391Name(), detectedLanguage.getScore());
                }
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguageBatch#Iterable-String
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#detectLanguageBatch(Iterable, String, TextAnalyticsRequestOptions)}
     */
    public void detectLanguageStringListWithOptions() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguageBatch#Iterable-String-TextAnalyticsRequestOptions
        List<String> textInputs1 = Arrays.asList(
            "This is written in English",
            "Este es un documento  escrito en Español."
        );
        textAnalyticsAsyncClient.detectLanguageBatch(textInputs1, "US", null).byPage().subscribe(
            batchResult -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());
                // Batch result of languages
                for (DetectLanguageResult detectLanguageResult : batchResult.getElements()) {
                    DetectedLanguage detectedLanguage = detectLanguageResult.getPrimaryLanguage();
                    System.out.printf("Detected language name: %s, ISO 6391 Name: %s, score: %f.%n",
                        detectedLanguage.getName(), detectedLanguage.getIso6391Name(), detectedLanguage.getScore());
                }
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguageBatch#Iterable-String-TextAnalyticsRequestOptions
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#detectLanguageBatch(Iterable, TextAnalyticsRequestOptions)}
     */
    public void detectBatchLanguagesMaxOverload() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguageBatch#Iterable-TextAnalyticsRequestOptions
        List<DetectLanguageInput> detectLanguageInputs1 = Arrays.asList(
            new DetectLanguageInput("1", "This is written in English.", "US"),
            new DetectLanguageInput("2", "Este es un documento  escrito en Español.", "ES")
        );

        // Request options: show statistics and model version
        TextAnalyticsRequestOptions requestOptions = new TextAnalyticsRequestOptions().setIncludeStatistics(true);

        textAnalyticsAsyncClient.detectLanguageBatch(detectLanguageInputs1, requestOptions).byPage()
            .subscribe(response -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = response.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());
                // Batch result of languages
                for (DetectLanguageResult detectLanguageResult : response.getElements()) {
                    DetectedLanguage detectedLanguage = detectLanguageResult.getPrimaryLanguage();
                    System.out.printf("Detected language name: %s, ISO 6391 Name: %s, score: %f.%n",
                        detectedLanguage.getName(), detectedLanguage.getIso6391Name(), detectedLanguage.getScore());
                }
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.detectLanguageBatch#Iterable-TextAnalyticsRequestOptions
    }

    // Entity

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeEntities(String)}
     */
    public void recognizeEntities() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeEntities#string
        String inputText = "Satya Nadella is the CEO of Microsoft";
        textAnalyticsAsyncClient.recognizeEntities(inputText)
            .subscribe(entity -> System.out.printf("Recognized categorized entity: %s, category: %s, score: %f.%n",
                entity.getText(),
                entity.getCategory(),
                entity.getConfidenceScore()));
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeEntities#string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeEntities(String, String)}
     */
    public void recognizeEntitiesWithLanguage() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeEntities#string-string
        String inputText1 = "Satya Nadella is the CEO of Microsoft";
        textAnalyticsAsyncClient.recognizeEntities(inputText1, "en")
            .subscribe(entity -> System.out.printf("Recognized categorized entity: %s, category: %s, score: %f.%n",
                entity.getText(),
                entity.getCategory(),
                entity.getConfidenceScore()));
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeEntities#string-string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeEntitiesBatch(Iterable)}
     */
    public void recognizeEntitiesStringList() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeCategorizedEntitiesBatch#Iterable
        List<String> textInputs = Arrays.asList(
            "I had a wonderful trip to Seattle last week.",
            "I work at Microsoft."
        );

        textAnalyticsAsyncClient.recognizeEntitiesBatch(textInputs).byPage().subscribe(batchResult -> {
            // Batch statistics
            TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
            System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());
            // Batch result of categorized entities
            batchResult.getElements().forEach(recognizeEntitiesResult ->
                recognizeEntitiesResult.getEntities().forEach(entity -> System.out.printf(
                    "Recognized entity: %s, entity category: %s, entity sub-category: %s, score: %f.%n",
                    entity.getText(), entity.getCategory(), entity.getSubCategory(), entity.getConfidenceScore())));
        });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeCategorizedEntitiesBatch#Iterable
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeEntitiesBatch(Iterable, String)}
     */
    public void recognizeEntitiesStringListWithLanguageCode() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeCategorizedEntitiesBatch#Iterable-String
        List<String> textInputs1 = Arrays.asList(
            "I had a wonderful trip to Seattle last week.", "I work at Microsoft.");

        textAnalyticsAsyncClient.recognizeEntitiesBatch(textInputs1, "en").byPage()
            .subscribe(batchResult -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());
                // Batch Result of entities
                batchResult.getElements().forEach(recognizeEntitiesResult ->
                    recognizeEntitiesResult.getEntities().forEach(entity -> System.out.printf(
                        "Recognized categorized entity: %s, category: %s, score: %f.%n",
                        entity.getText(), entity.getCategory(), entity.getConfidenceScore())));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeCategorizedEntitiesBatch#Iterable-String
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeEntitiesBatch(Iterable, String, TextAnalyticsRequestOptions)}
     */
    public void recognizeEntitiesStringListWithOptions() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeCategorizedEntitiesBatch#Iterable-String-TextAnalyticsRequestOptions
        List<String> textInputs1 = Arrays.asList(
            "I had a wonderful trip to Seattle last week.", "I work at Microsoft.");

        textAnalyticsAsyncClient.recognizeEntitiesBatch(textInputs1, "en", null).byPage()
            .subscribe(batchResult -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());
                // Batch Result of entities
                batchResult.getElements().forEach(recognizeEntitiesResult ->
                    recognizeEntitiesResult.getEntities().forEach(entity -> System.out.printf(
                        "Recognized categorized entity: %s, category: %s, score: %f.%n",
                            entity.getText(), entity.getCategory(), entity.getConfidenceScore())));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeCategorizedEntitiesBatch#Iterable-String-TextAnalyticsRequestOptions
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeEntitiesBatch(Iterable,
     * TextAnalyticsRequestOptions)}
     */
    public void recognizeBatchEntitiesMaxOverload() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeCategorizedEntitiesBatch#Iterable-TextAnalyticsRequestOptions
        List<TextDocumentInput> textDocumentInputs1 = Arrays.asList(
            new TextDocumentInput("0", "I had a wonderful trip to Seattle last week."),
            new TextDocumentInput("1", "I work at Microsoft."));

        // Request options: show statistics and model version
        TextAnalyticsRequestOptions requestOptions = new TextAnalyticsRequestOptions().setIncludeStatistics(true);

        textAnalyticsAsyncClient.recognizeEntitiesBatch(textDocumentInputs1, requestOptions).byPage()
            .subscribe(response -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = response.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                response.getElements().forEach(recognizeEntitiesResult ->
                    recognizeEntitiesResult.getEntities().forEach(entity -> System.out.printf(
                        "Recognized categorized entity: %s, category: %s, score: %f.%n",
                        entity.getText(),
                        entity.getCategory(),
                        entity.getConfidenceScore())));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeCategorizedEntitiesBatch#Iterable-TextAnalyticsRequestOptions
    }

    // Personally Identifiable Information Entity

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizePiiEntities(String)}
     */
    public void recognizePiiEntities() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntities#string
        String inputText = "My SSN is 555-55-5555";
        textAnalyticsAsyncClient.recognizePiiEntities(inputText).subscribe(piiEntity -> System.out.printf(
            "Recognized categorized entity: %s, category: %s, score: %f.%n",
            piiEntity.getText(),
            piiEntity.getCategory(),
            piiEntity.getConfidenceScore()));
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntities#string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizePiiEntities(String, String)}
     */
    public void recognizePiiEntitiesWithLanguage() {

        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntities#string-string
        String inputText1 = "My SSN is 555-55-5555";
        textAnalyticsAsyncClient.recognizePiiEntities(inputText1, "en")
            .subscribe(entity -> System.out.printf(
                "Recognized Personally Identifiable Information entity: %s, category: %s, score: %f.%n",
                entity.getText(), entity.getCategory(), entity.getConfidenceScore()));
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntities#string-string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizePiiEntitiesBatch(Iterable)}
     */
    public void recognizePiiEntitiesStringList() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntitiesBatch#Iterable
        List<String> textInputs = Arrays.asList(
            "My SSN is 555-55-5555.", "Visa card 0111 1111 1111 1111.");

        textAnalyticsAsyncClient.recognizePiiEntitiesBatch(textInputs).byPage().subscribe(recognizeEntitiesResults -> {
            // Batch statistics
            TextDocumentBatchStatistics batchStatistics = recognizeEntitiesResults.getStatistics();
            System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

            recognizeEntitiesResults.getElements().forEach(recognizeEntitiesResult ->
                recognizeEntitiesResult.getEntities().forEach(piiEntity -> System.out.printf(
                    "Recognized Personally Identifiable Information entity: %s, category: %s, score: %f.%n",
                    piiEntity.getText(), piiEntity.getCategory(), piiEntity.getConfidenceScore())));
        });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntitiesBatch#Iterable
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizePiiEntitiesBatch(Iterable, String)}
     */
    public void recognizePiiEntitiesStringListWithLanguageCode() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntitiesBatch#Iterable-String
        List<String> textInputs = Arrays.asList(
            "My SSN is 555-55-5555.",
            "Visa card 0111 1111 1111 1111."
        );

        textAnalyticsAsyncClient.recognizePiiEntitiesBatch(textInputs, "en").byPage()
            .subscribe(batchResult -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                batchResult.getElements().forEach(recognizeEntitiesResult ->
                    recognizeEntitiesResult.getEntities().forEach(piiEntity -> System.out.printf(
                        "Recognized Personally Identifiable Information entity: %s, category: %s, score: %f.%n",
                        piiEntity.getText(), piiEntity.getCategory(), piiEntity.getConfidenceScore())));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntitiesBatch#Iterable-String
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizePiiEntitiesBatch(Iterable, String, TextAnalyticsRequestOptions)}
     */
    public void recognizePiiEntitiesStringListWithOptions() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntitiesBatch#Iterable-String-TextAnalyticsRequestOptions
        List<String> textInputs = Arrays.asList(
            "My SSN is 555-55-5555.",
            "Visa card 0111 1111 1111 1111."
        );

        textAnalyticsAsyncClient.recognizePiiEntitiesBatch(textInputs, "en", null).byPage()
            .subscribe(batchResult -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                batchResult.getElements().forEach(recognizeEntitiesResult ->
                    recognizeEntitiesResult.getEntities().forEach(piiEntity -> System.out.printf(
                        "Recognized Personally Identifiable Information entity: %s, category: %s, score: %f.%n",
                        piiEntity.getText(), piiEntity.getCategory(), piiEntity.getConfidenceScore())));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntitiesBatch#Iterable-String-TextAnalyticsRequestOptions
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizePiiEntitiesBatch(Iterable,
     * TextAnalyticsRequestOptions)}
     */
    public void recognizeBatchPiiEntitiesMaxOverload() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntitiesBatch#Iterable-TextAnalyticsRequestOptions
        List<TextDocumentInput> textDocumentInputs1 = Arrays.asList(
            new TextDocumentInput("0", "My SSN is 555-55-5555."),
            new TextDocumentInput("1", "Visa card 0111 1111 1111 1111."));

        // Request options: show statistics and model version
        TextAnalyticsRequestOptions requestOptions = new TextAnalyticsRequestOptions().setIncludeStatistics(true);

        textAnalyticsAsyncClient.recognizePiiEntitiesBatch(textDocumentInputs1, requestOptions).byPage()
            .subscribe(response -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = response.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                response.getElements().forEach(recognizeEntitiesResult ->
                    recognizeEntitiesResult.getEntities().forEach(piiEntity -> System.out.printf(
                        "Recognized Personally Identifiable Information entity: %s, category: %s, score: %f.%n",
                        piiEntity.getText(), piiEntity.getCategory(), piiEntity.getConfidenceScore())));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizePiiEntitiesBatch#Iterable-TextAnalyticsRequestOptions
    }

    // Linked Entity

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeLinkedEntities(String)}
     */
    public void recognizeLinkedEntities() {

        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntities#string
        String inputText = "Old Faithful is a geyser at Yellowstone Park.";
        textAnalyticsAsyncClient.recognizeLinkedEntities(inputText).subscribe(linkedEntity -> {
            System.out.println("Linked Entities:");
            System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s.%n",
                linkedEntity.getName(), linkedEntity.getDataSourceEntityId(), linkedEntity.getUrl(),
                linkedEntity.getDataSource());
            linkedEntity.getLinkedEntityMatches().forEach(entityMatch -> System.out.printf(
                "Matched entity: %s, score: %f.%n", entityMatch.getText(), entityMatch.getConfidenceScore()));
        });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntities#string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeLinkedEntities(String, String)}
     */
    public void recognizeLinkedEntitiesWithLanguage() {

        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntities#string-string
        String inputText = "Old Faithful is a geyser at Yellowstone Park.";
        textAnalyticsAsyncClient.recognizeLinkedEntities(inputText, "en")
            .subscribe(linkedEntity -> {
                System.out.println("Linked Entities:");
                System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s.%n",
                    linkedEntity.getName(), linkedEntity.getDataSourceEntityId(), linkedEntity.getUrl(),
                    linkedEntity.getDataSource());
                linkedEntity.getLinkedEntityMatches().forEach(entityMatch -> System.out.printf(
                    "Matched entity: %s, score: %f.%n", entityMatch.getText(), entityMatch.getConfidenceScore()));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntities#string-string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeLinkedEntitiesBatch(Iterable)}
     */
    public void recognizeLinkedEntitiesStringList() {

        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntitiesBatch#Iterable
        List<String> textInputs = Arrays.asList(
            "Old Faithful is a geyser at Yellowstone Park.",
            "Mount Shasta has lenticular clouds."
        );

        textAnalyticsAsyncClient.recognizeLinkedEntitiesBatch(textInputs).byPage().subscribe(response -> {
            // Batch statistics
            TextDocumentBatchStatistics batchStatistics = response.getStatistics();
            System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

            response.getElements().forEach(recognizeLinkedEntitiesResult ->
                recognizeLinkedEntitiesResult.getEntities().forEach(linkedEntity -> {
                    System.out.println("Linked Entities:");
                    System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s.%n",
                        linkedEntity.getName(), linkedEntity.getDataSourceEntityId(), linkedEntity.getUrl(),
                        linkedEntity.getDataSource());
                    linkedEntity.getLinkedEntityMatches().forEach(entityMatch -> System.out.printf(
                        "Matched entity: %s, score: %f.%n", entityMatch.getText(), entityMatch.getConfidenceScore()));
                }));
        });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntitiesBatch#Iterable

    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeLinkedEntitiesBatch(Iterable, String)}
     */
    public void recognizeLinkedEntitiesStringListWithLanguageCode() {

        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntitiesBatch#Iterable-String
        List<String> textInputs1 = Arrays.asList(
            "Old Faithful is a geyser at Yellowstone Park.",
            "Mount Shasta has lenticular clouds."
        );

        textAnalyticsAsyncClient.recognizeLinkedEntitiesBatch(textInputs1, "en").byPage()
            .subscribe(batchResult -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                batchResult.getElements().forEach(recognizeLinkedEntitiesResult ->
                    recognizeLinkedEntitiesResult.getEntities().forEach(linkedEntity -> {
                        System.out.println("Linked Entities:");
                        System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s.%n",
                            linkedEntity.getName(), linkedEntity.getDataSourceEntityId(), linkedEntity.getUrl(),
                            linkedEntity.getDataSource());
                        linkedEntity.getLinkedEntityMatches().forEach(entityMatch -> System.out.printf(
                            "Matched entity: %s, score: %f.%n", entityMatch.getText(), entityMatch.getConfidenceScore()));
                    }));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntitiesBatch#Iterable-String
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeLinkedEntitiesBatch(Iterable, String, TextAnalyticsRequestOptions)}
     */
    public void recognizeLinkedEntitiesStringListWithOptions() {

        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntitiesBatch#Iterable-String-TextAnalyticsRequestOptions
        List<String> textInputs1 = Arrays.asList(
            "Old Faithful is a geyser at Yellowstone Park.",
            "Mount Shasta has lenticular clouds."
        );

        textAnalyticsAsyncClient.recognizeLinkedEntitiesBatch(textInputs1, "en", null).byPage()
            .subscribe(batchResult -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = batchResult.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                batchResult.getElements().forEach(recognizeLinkedEntitiesResult ->
                    recognizeLinkedEntitiesResult.getEntities().forEach(linkedEntity -> {
                        System.out.println("Linked Entities:");
                        System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s.%n",
                            linkedEntity.getName(), linkedEntity.getDataSourceEntityId(), linkedEntity.getUrl(),
                            linkedEntity.getDataSource());
                        linkedEntity.getLinkedEntityMatches().forEach(entityMatch -> System.out.printf(
                            "Matched entity: %s, score: %f.%n", entityMatch.getText(), entityMatch.getConfidenceScore()));
                    }));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntitiesBatch#Iterable-String-TextAnalyticsRequestOptions
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#recognizeLinkedEntitiesBatch(Iterable,
     * TextAnalyticsRequestOptions)}
     */
    public void recognizeBatchLinkedEntitiesMaxOverload() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntitiesBatch#Iterable-TextAnalyticsRequestOptions
        List<TextDocumentInput> textDocumentInputs1 = Arrays.asList(
            new TextDocumentInput("0", "Old Faithful is a geyser at Yellowstone Park."),
            new TextDocumentInput("1", "Mount Shasta has lenticular clouds."));

        // Request options: show statistics and model version
        TextAnalyticsRequestOptions requestOptions = new TextAnalyticsRequestOptions().setIncludeStatistics(true);

        textAnalyticsAsyncClient.recognizeLinkedEntitiesBatch(textDocumentInputs1, requestOptions).byPage()
            .subscribe(response -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = response.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                response.getElements().forEach(recognizeLinkedEntitiesResult ->
                    recognizeLinkedEntitiesResult.getEntities().forEach(linkedEntity -> {
                        System.out.println("Linked Entities:");
                        System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s.%n",
                            linkedEntity.getName(), linkedEntity.getDataSourceEntityId(), linkedEntity.getUrl(),
                            linkedEntity.getDataSource());
                        linkedEntity.getLinkedEntityMatches().forEach(entityMatch -> System.out.printf(
                            "Matched entity: %s, score: %.2f.%n", entityMatch.getText(), entityMatch.getConfidenceScore()));
                    }));
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.recognizeLinkedEntitiesBatch#Iterable-TextAnalyticsRequestOptions
    }

    // Key Phrases

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#extractKeyPhrases(String)}
     */
    public void extractKeyPhrases() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrases#string
        System.out.println("Extracted phrases:");
        textAnalyticsAsyncClient.extractKeyPhrases("Bonjour tout le monde").subscribe(keyPhrase ->
            System.out.printf("%s.%n", keyPhrase));
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrases#string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#extractKeyPhrases(String, String)}
     */
    public void extractKeyPhrasesWithLanguage() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrases#string-string
        System.out.println("Extracted phrases:");
        textAnalyticsAsyncClient.extractKeyPhrases("Bonjour tout le monde", "fr")
            .subscribe(keyPhrase -> System.out.printf("%s.%n", keyPhrase));
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrases#string-string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#extractKeyPhrasesBatch(Iterable)}
     */
    public void extractKeyPhrasesStringList() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrasesBatch#Iterable
        List<String> textInputs = Arrays.asList(
            "Hello world. This is some input text that I love.",
            "Bonjour tout le monde");

        textAnalyticsAsyncClient.extractKeyPhrasesBatch(textInputs).byPage().subscribe(extractKeyPhraseResults -> {
            // Batch statistics
            TextDocumentBatchStatistics batchStatistics = extractKeyPhraseResults.getStatistics();
            System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

            extractKeyPhraseResults.getElements().forEach(extractKeyPhraseResult -> {
                System.out.println("Extracted phrases:");
                extractKeyPhraseResult.getKeyPhrases().forEach(keyPhrase -> System.out.printf("%s.%n", keyPhrase));
            });
        });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrasesBatch#Iterable
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#extractKeyPhrasesBatch(Iterable, String)}
     */
    public void extractKeyPhrasesStringListWithLanguageCode() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrasesBatch#Iterable-String
        List<String> textInputs1 = Arrays.asList(
            "Hello world. This is some input text that I love.",
            "Bonjour tout le monde");

        textAnalyticsAsyncClient.extractKeyPhrasesBatch(textInputs1, "en").byPage().subscribe(
            extractKeyPhraseResults -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = extractKeyPhraseResults.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                extractKeyPhraseResults.getElements().forEach(extractKeyPhraseResult -> {
                    System.out.println("Extracted phrases:");
                    extractKeyPhraseResult.getKeyPhrases().forEach(keyPhrase -> System.out.printf("%s.%n", keyPhrase));
                });
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrasesBatch#Iterable-String
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#extractKeyPhrasesBatch(Iterable, String, TextAnalyticsRequestOptions)}
     */
    public void extractKeyPhrasesStringListWithOptions() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrasesBatch#Iterable-String-TextAnalyticsRequestOptions
        List<String> textInputs1 = Arrays.asList(
            "Hello world. This is some input text that I love.",
            "Bonjour tout le monde");

        textAnalyticsAsyncClient.extractKeyPhrasesBatch(textInputs1, "en", null).byPage().subscribe(
            extractKeyPhraseResults -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = extractKeyPhraseResults.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                extractKeyPhraseResults.getElements().forEach(extractKeyPhraseResult -> {
                    System.out.println("Extracted phrases:");
                    extractKeyPhraseResult.getKeyPhrases().forEach(keyPhrase -> System.out.printf("%s.%n", keyPhrase));
                });
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrasesBatch#Iterable-String-TextAnalyticsRequestOptions
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#extractKeyPhrasesBatch(Iterable,
     * TextAnalyticsRequestOptions)}
     */
    public void extractBatchKeyPhrasesMaxOverload() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrasesBatch#Iterable-TextAnalyticsRequestOptions
        List<TextDocumentInput> textDocumentInputs1 = Arrays.asList(
            new TextDocumentInput("0", "I had a wonderful trip to Seattle last week."),
            new TextDocumentInput("1", "I work at Microsoft."));

        // Request options: show statistics and model version
        TextAnalyticsRequestOptions requestOptions = new TextAnalyticsRequestOptions().setIncludeStatistics(true);

        textAnalyticsAsyncClient.extractKeyPhrasesBatch(textDocumentInputs1, requestOptions).byPage()
            .subscribe(response -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = response.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                for (ExtractKeyPhraseResult extractKeyPhraseResult : response.getElements()) {
                    System.out.println("Extracted phrases:");
                    for (String keyPhrase : extractKeyPhraseResult.getKeyPhrases()) {
                        System.out.printf("%s.%n", keyPhrase);
                    }
                }
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.extractKeyPhrasesBatch#Iterable-TextAnalyticsRequestOptions
    }

    // Sentiment

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#analyzeSentiment(String)}
     */
    public void analyzeSentiment() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentiment#string
        String inputText = "The hotel was dark and unclean.";
        textAnalyticsAsyncClient.analyzeSentiment(inputText).subscribe(documentSentiment -> {
            System.out.printf("Recognized document sentiment: %s.%n", documentSentiment.getSentiment());

            for (SentenceSentiment sentenceSentiment : documentSentiment.getSentences()) {
                System.out.printf(
                    "Recognized sentence sentiment: %s, positive score: %.2f, neutral score: %.2f, negative score: %.2f.%n",
                    sentenceSentiment.getSentiment(),
                    sentenceSentiment.getConfidenceScores().getPositive(),
                    sentenceSentiment.getConfidenceScores().getNeutral(),
                    sentenceSentiment.getConfidenceScores().getNegative());
            }
        });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentiment#string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#analyzeSentiment(String, String)}
     */
    public void analyzeSentimentWithLanguage() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentiment#string-string
        String inputText1 = "The hotel was dark and unclean.";
        textAnalyticsAsyncClient.analyzeSentiment(inputText1, "en")
            .subscribe(documentSentiment -> {
                System.out.printf("Recognized sentiment label: %s.%n", documentSentiment.getSentiment());

                for (SentenceSentiment sentenceSentiment : documentSentiment.getSentences()) {
                    System.out.printf("Recognized sentence sentiment: %s, positive score: %.2f, neutral score: %.2f, "
                            + "negative score: %.2f.%n",
                        sentenceSentiment.getSentiment(),
                        sentenceSentiment.getConfidenceScores().getPositive(),
                        sentenceSentiment.getConfidenceScores().getNeutral(),
                        sentenceSentiment.getConfidenceScores().getNegative());
                }
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentiment#string-string
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#analyzeSentimentBatch(Iterable)}
     */
    public void analyzeSentimentStringList() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentimentBatch#Iterable
        List<String> textInputs = Arrays.asList(
            "The hotel was dark and unclean.", "The restaurant had amazing gnocchi.");

        textAnalyticsAsyncClient.analyzeSentimentBatch(textInputs).byPage().subscribe(response -> {
            // Batch statistics
            TextDocumentBatchStatistics batchStatistics = response.getStatistics();
            System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

            response.getElements().forEach(analyzeSentimentResult -> {
                System.out.printf("Document ID: %s%n", analyzeSentimentResult.getId());
                DocumentSentiment documentSentiment = analyzeSentimentResult.getDocumentSentiment();
                System.out.printf("Recognized document sentiment: %s.%n", documentSentiment.getSentiment());
                documentSentiment.getSentences().forEach(sentenceSentiment ->
                    System.out.printf("Recognized sentence sentiment: %s, positive score: %.2f, neutral score: %.2f, "
                            + "negative score: %.2f.%n",
                        sentenceSentiment.getSentiment(),
                        sentenceSentiment.getConfidenceScores().getPositive(),
                        sentenceSentiment.getConfidenceScores().getNeutral(),
                        sentenceSentiment.getConfidenceScores().getNegative()));
            });
        });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentimentBatch#Iterable
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#analyzeSentimentBatch(Iterable, String)}
     */
    public void analyzeSentimentStringListWithLanguageCode() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentimentBatch#Iterable-String
        List<String> textInputs1 = Arrays.asList(
            "The hotel was dark and unclean.",
            "The restaurant had amazing gnocchi."
        );

        textAnalyticsAsyncClient.analyzeSentimentBatch(textInputs1, "en").byPage().subscribe(
            response -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = response.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                response.getElements().forEach(analyzeSentimentResult -> {
                    System.out.printf("Document ID: %s%n", analyzeSentimentResult.getId());
                    DocumentSentiment documentSentiment = analyzeSentimentResult.getDocumentSentiment();
                    System.out.printf("Recognized document sentiment: %s.%n", documentSentiment.getSentiment());
                    documentSentiment.getSentences().forEach(sentenceSentiment ->
                        System.out.printf("Recognized sentence sentiment: %s, positive score: %.2f, "
                                + "neutral score: %.2f, negative score: %.2f.%n",
                            sentenceSentiment.getSentiment(),
                            sentenceSentiment.getConfidenceScores().getPositive(),
                            sentenceSentiment.getConfidenceScores().getNeutral(),
                            sentenceSentiment.getConfidenceScores().getNegative()));
                });
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentimentBatch#Iterable-String
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#analyzeSentimentBatch(Iterable, String, TextAnalyticsRequestOptions)}
     */
    public void analyzeSentimentStringListWithOptions() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentimentBatch#Iterable-String-TextAnalyticsRequestOptions
        List<String> textInputs1 = Arrays.asList(
            "The hotel was dark and unclean.",
            "The restaurant had amazing gnocchi."
        );

        textAnalyticsAsyncClient.analyzeSentimentBatch(textInputs1, "en", null).byPage().subscribe(
            response -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = response.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                response.getElements().forEach(analyzeSentimentResult -> {
                    System.out.printf("Document ID: %s%n", analyzeSentimentResult.getId());
                    DocumentSentiment documentSentiment = analyzeSentimentResult.getDocumentSentiment();
                    System.out.printf("Recognized document sentiment: %s.%n", documentSentiment.getSentiment());
                    documentSentiment.getSentences().forEach(sentenceSentiment ->
                        System.out.printf("Recognized sentence sentiment: %s, positive score: %.2f, "
                                + "neutral score: %.2f, negative score: %.2f.%n",
                            sentenceSentiment.getSentiment(),
                            sentenceSentiment.getConfidenceScores().getPositive(),
                            sentenceSentiment.getConfidenceScores().getNeutral(),
                            sentenceSentiment.getConfidenceScores().getNegative()));
                });
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentimentBatch#Iterable-String-TextAnalyticsRequestOptions
    }

    /**
     * Code snippet for {@link TextAnalyticsAsyncClient#analyzeSentimentBatch(Iterable,
     * TextAnalyticsRequestOptions)}
     */
    public void analyzeBatchSentimentMaxOverload() {
        // BEGIN: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentimentBatch#Iterable-TextAnalyticsRequestOptions
        List<TextDocumentInput> textDocumentInputs1 = Arrays.asList(
            new TextDocumentInput("0", "The hotel was dark and unclean."),
            new TextDocumentInput("1", "The restaurant had amazing gnocchi."));

        // Request options: show statistics and model version
        TextAnalyticsRequestOptions requestOptions = new TextAnalyticsRequestOptions().setIncludeStatistics(true);

        textAnalyticsAsyncClient.analyzeSentimentBatch(textDocumentInputs1, requestOptions).byPage()
            .subscribe(response -> {
                // Batch statistics
                TextDocumentBatchStatistics batchStatistics = response.getStatistics();
                System.out.printf("Batch statistics, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getTransactionCount(),
                    batchStatistics.getValidDocumentCount());

                response.getElements().forEach(analyzeSentimentResult -> {
                    System.out.printf("Document ID: %s%n", analyzeSentimentResult.getId());
                    DocumentSentiment documentSentiment = analyzeSentimentResult.getDocumentSentiment();
                    System.out.printf("Recognized document sentiment: %s.%n", documentSentiment.getSentiment());
                    documentSentiment.getSentences().forEach(sentenceSentiment ->
                        System.out.printf("Recognized sentence sentiment: %s, positive score: %.2f, "
                                + "neutral score: %.2f, negative score: %.2f.%n",
                            sentenceSentiment.getSentiment(),
                            sentenceSentiment.getConfidenceScores().getPositive(),
                            sentenceSentiment.getConfidenceScores().getNeutral(),
                            sentenceSentiment.getConfidenceScores().getNegative()));
                });
            });
        // END: com.azure.ai.textanalytics.TextAnalyticsAsyncClient.analyzeSentimentBatch#Iterable-TextAnalyticsRequestOptions
    }

    // Text Analytics Paged flux
    public void textAnalyticsPagedFluxSample() {
        TextAnalyticsPagedFlux<CategorizedEntity> pagedFlux =
            textAnalyticsAsyncClient.recognizeEntities("");
        // BEGIN: com.azure.ai.textanalytics.util.TextAnalyticsPagedFlux.subscribe
        pagedFlux
            .log()
            .subscribe(
                item -> System.out.println("Processing item" + item),
                error -> System.err.println("Error occurred " + error),
                () -> System.out.println("Completed processing."));
        // END: com.azure.ai.textanalytics.util.TextAnalyticsPagedFlux.subscribe

        // BEGIN: com.azure.ai.textanalytics.util.TextAnalyticsPagedFlux.subscribeByPage
        pagedFlux
            .byPage()
            .log()
            .subscribe(
                page -> System.out.printf("Processing page containing model version: %s, items:",
                    page.getModelVersion(), page.getElements()),
                error -> System.err.println("Error occurred " + error),
                () -> System.out.println("Completed processing."));
        // END: com.azure.ai.textanalytics.util.TextAnalyticsPagedFlux.subscribeByPage
    }
}
