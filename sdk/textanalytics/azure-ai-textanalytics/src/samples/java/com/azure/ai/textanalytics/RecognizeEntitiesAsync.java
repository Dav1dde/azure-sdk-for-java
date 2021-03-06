// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.models.TextAnalyticsApiKeyCredential;

import java.util.concurrent.TimeUnit;

/**
 * Sample demonstrates how to asynchronously recognize the entities of document.
 */
public class RecognizeEntitiesAsync {
    /**
     * Main method to invoke this demo about how to recognize the entities of document.
     *
     * @param args Unused arguments to the program.
     */
    public static void main(String[] args) {
        // Instantiate a client that will be used to call the service.
        TextAnalyticsAsyncClient client = new TextAnalyticsClientBuilder()
            .apiKey(new TextAnalyticsApiKeyCredential("{api_key}"))
            .endpoint("{endpoint}")
            .buildAsyncClient();

        // The text that needs be analyzed.
        String text = "Satya Nadella is the CEO of Microsoft";

        client.recognizeEntities(text).subscribe(
            entity -> System.out.printf(
                "Recognized categorized entity: %s, entity category: %s, entity sub-category: %s, score: %f.%n",
                entity.getText(), entity.getCategory(), entity.getSubCategory(), entity.getConfidenceScore()),
            error -> System.err.println("There was an error recognizing entities of the text." + error),
            () -> System.out.println("Entities recognized."));

        // The .subscribe() creation and assignment is not a blocking call. For the purpose of this example, we sleep
        // the thread so the program does not end before the send operation is complete. Using .block() instead of
        // .subscribe() will turn this into a synchronous call.
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ignored) {
        }
    }
}
