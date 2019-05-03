/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.util;

import com.clevertap.apns.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The type Extended notification.
 */
public class ExtendedNotification extends Notification {


    /**
     * Constructs a new Notification with a payload and token.
     *
     * @param payload    The JSON body (which is used for the request)
     * @param token      The device token
     * @param topic      The topic for this notification
     * @param collapseId The collapse ID
     * @param expiration A UNIX epoch date expressed in seconds (UTC)
     * @param priority   The priority of the notification (10 or 5)
     * @param uuid       A canonical UUID that identifies the notification
     */
    protected ExtendedNotification(String payload, String token, String topic, String collapseId, long expiration, Priority priority, UUID uuid) {
        super(payload, token, topic, collapseId, expiration, priority, uuid);
    }


    /**
     * Builds a notification to be sent to APNS.
     */
    public static class Builder {
        private final ObjectMapper mapper = new ObjectMapper();

        private final HashMap<String, Object> root, aps, alert;
        private final String token;
        private String topic = null;
        private String collapseId = null;
        private long expiration = -1; // defaults to -1, as 0 is a valid value (included only if greater than -1)
        private Priority priority;
        private UUID uuid;

        /**
         * Creates a new notification builder.
         *
         * @param token The device token
         */
        public Builder(String token) {
            this.token = token;
            root = new HashMap<>();
            aps = new HashMap<>();
            alert = new HashMap<>();
        }

        /**
         * Mutable content extended notification . builder.
         *
         * @param mutable the mutable
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder mutableContent(boolean mutable) {
            if (mutable) {
                aps.put("mutable-content", 1);
            } else {
                aps.remove("mutable-content");
            }

            return this;
        }

        /**
         * Mutable content extended notification . builder.
         *
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder mutableContent() {
            return this.mutableContent(true);
        }

        /**
         * Content available extended notification . builder.
         *
         * @param contentAvailable the content available
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder contentAvailable(boolean contentAvailable) {
            if (contentAvailable) {
                aps.put("content-available", 1);
            } else {
                aps.remove("content-available");
            }

            return this;
        }

        /**
         * Content available extended notification . builder.
         *
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder contentAvailable() {
            return this.contentAvailable(true);
        }

        /**
         * Alert body extended notification . builder.
         *
         * @param body the body
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder alertBody(String body) {
            alert.put("body", body);
            return this;
        }

        /**
         * Alert title extended notification . builder.
         *
         * @param title the title
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder alertTitle(String title) {
            alert.put("title", title);
            return this;
        }

        /**
         * Sound extended notification . builder.
         *
         * @param sound the sound
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder sound(String sound) {
            if (sound != null) {
                aps.put("sound", sound);
            } else {
                aps.remove("sound");
            }

            return this;
        }

        /**
         * Category extended notification . builder.
         *
         * @param category the category
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder category(String category) {
            if (category != null) {
                aps.put("category", category);
            } else {
                aps.remove("category");
            }
            return this;
        }

        /**
         * Badge extended notification . builder.
         *
         * @param badge the badge
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder badge(int badge) {
            aps.put("badge", badge);
            return this;
        }


        /**
         * Custom field extended notification . builder.
         *
         * @param notificationPref the notification pref
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder customField(Map<String, Object> notificationPref) {
            root.putAll(notificationPref);
            return this;
        }

        /**
         * Topic extended notification . builder.
         *
         * @param topic the topic
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder topic(String topic) {
            this.topic = topic;
            return this;
        }

        /**
         * Collapse id extended notification . builder.
         *
         * @param collapseId the collapse id
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder collapseId(String collapseId) {
            this.collapseId = collapseId;
            return this;
        }

        /**
         * Expiration extended notification . builder.
         *
         * @param expiration the expiration
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder expiration(long expiration) {
            this.expiration = expiration;
            return this;
        }

        /**
         * Uuid extended notification . builder.
         *
         * @param uuid the uuid
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        /**
         * Priority extended notification . builder.
         *
         * @param priority the priority
         * @return the extended notification . builder
         */
        public ExtendedNotification.Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }

        /**
         * Size int.
         *
         * @return the int
         */
        public int size() {
            try {
                return build().getPayload().getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }


        /**
         * Build notification.
         *
         * @return the notification
         */
        public Notification build() {
            root.put("aps", aps);
            aps.put("alert", alert);

            final String payload;
            try {
                payload = mapper.writeValueAsString(root);
            } catch (JsonProcessingException e) {
                // Should not happen
                throw new RuntimeException(e);
            }

            System.out.println("**********************************************");
            System.out.println(payload);
            System.out.println("**********************************************");

            return new ExtendedNotification(payload, token, topic, collapseId, expiration, priority, uuid);
        }
    }
}

