/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.configs;

import com.turo.pushy.apns.ApnsClient;
import com.turo.pushy.apns.ApnsClientBuilder;
import com.turo.pushy.apns.ApnsClientMetricsListener;
import com.turo.pushy.apns.auth.ApnsSigningKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 
 */
@Configuration
public class PushyConfiguration {

    @Value("/file/AuthKey.p8")
    private String filePath;

    ApplicationContext applicationContext;

    /**
     * 
     */
    @Bean
    ApnsClient apnsClient() throws Exception {
        return new ApnsClientBuilder()
                .setApnsServer(ApnsClientBuilder.DEVELOPMENT_APNS_HOST)
                .setSigningKey(ApnsSigningKey.loadFromInputStream(getClass().getClassLoader().getResource(filePath).openStream(), "U5EMEFZ957", "D7F9C8W9C3"))
                .setConcurrentConnections(1000)
                .setIdlePingInterval(3, TimeUnit.SECONDS)
                .setMetricsListener(apnsClientMetricsListener())
                .setGracefulShutdownTimeout(50000, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 
     */
    @Bean
    ApnsClientMetricsListener apnsClientMetricsListener() {
        return new ApnsClientMetricsListener() {
            /**
             * 
             * @param apnsClient 
             * @param notificationId 
             */
            @Override
            public void handleWriteFailure(ApnsClient apnsClient, long notificationId) {
                System.out.println("Message Write failure -- " + notificationId);
            }

            /**
             * 
             * @param apnsClient 
             * @param notificationId 
             */
            @Override
            public void handleNotificationSent(ApnsClient apnsClient, long notificationId) {
                System.out.println("Message Sent -- " + notificationId);
            }

            /**
             * 
             * @param apnsClient 
             * @param notificationId 
             */
            @Override
            public void handleNotificationAccepted(ApnsClient apnsClient, long notificationId) {

                System.out.println("Message Accepted -- " + notificationId);

            }

            /**
             * 
             * @param apnsClient 
             * @param notificationId 
             */
            @Override
            public void handleNotificationRejected(ApnsClient apnsClient, long notificationId) {
                System.out.println("Message Rejected -- " + notificationId);
            }

            /**
             * 
             * @param apnsClient 
             */
            @Override
            public void handleConnectionAdded(ApnsClient apnsClient) {
                System.out.println("Connection created -- ");
            }

            /**
             * 
             * @param apnsClient 
             */
            @Override
            public void handleConnectionRemoved(ApnsClient apnsClient) {
                System.out.println("Connection Removed -- ");
            }

            /**
             * 
             * @param apnsClient 
             */
            @Override
            public void handleConnectionCreationFailed(ApnsClient apnsClient) {

            }
        };
    }


}

