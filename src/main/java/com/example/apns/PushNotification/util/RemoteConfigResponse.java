/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class RemoteConfigResponse {

    private String id;
    private String configSentDate;
    private LocalDate expiration;
    private String status;
    private String category;
    private Boolean isPopup;
    private Boolean isConditional;
    private String conditionParam;
    private String configParams;


    /**
     * 
     */
    public RemoteConfigResponse() {
    }

    /**
     * 
     * @param id 
     * @param configSentDate 
     * @param expiration 
     * @param status 
     * @param category 
     * @param isPopup 
     * @param isConditional 
     * @param conditionParam 
     * @param configParams 
     */
    public RemoteConfigResponse(String id, String configSentDate, LocalDate expiration, String status, String category, Boolean isPopup, Boolean isConditional, String conditionParam, String configParams) {
        this.id = id;
        this.configSentDate = configSentDate;
        this.expiration = expiration;
        this.status = status;
        this.category = category;
        this.isPopup = isPopup;
        this.isConditional = isConditional;
        this.conditionParam = conditionParam;
        this.configParams = configParams;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for property 'configSentDate'.
     *
     * @return Value for property 'configSentDate'.
     */
    public String getConfigSentDate() {
        return configSentDate;
    }

    /**
     * Getter for property 'expiration'.
     *
     * @return Value for property 'expiration'.
     */
    public LocalDate getExpiration() {
        return expiration;
    }

    /**
     * Getter for property 'status'.
     *
     * @return Value for property 'status'.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Getter for property 'category'.
     *
     * @return Value for property 'category'.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Getter for property 'popup'.
     *
     * @return Value for property 'popup'.
     */
    public Boolean getPopup() {
        return isPopup;
    }

    /**
     * Getter for property 'configParams'.
     *
     * @return Value for property 'configParams'.
     */
    public String getConfigParams() {
        return configParams;
    }

    /**
     * Getter for property 'conditional'.
     *
     * @return Value for property 'conditional'.
     */
    public Boolean getConditional() {
        return isConditional;
    }

    /**
     * Getter for property 'conditionParam'.
     *
     * @return Value for property 'conditionParam'.
     */
    public String getConditionParam() {
        return conditionParam;
    }

    /**
     * 
     */
    public static class RemoteConfigResponseBuilder {
        private final ObjectMapper mapper = new ObjectMapper();

        private final HashMap<String, Object> root;
        private String id;
        private String configSentDate;
        private LocalDate expiration;
        private String status;
        private String category;
        private Boolean isPopup;
        private Boolean isConditional;
        private String conditionParam;

        /**
         * 
         */
        private RemoteConfigResponseBuilder() {
            root = new HashMap<>();
        }

        /**
         * 
         */
        public static RemoteConfigResponseBuilder aRemoteConfigResponse() {
            return new RemoteConfigResponseBuilder();
        }

        /**
         * 
         * @param id 
         */
        public RemoteConfigResponseBuilder withId(String id) {
            this.id = id;
            return this;
        }

        /**
         * 
         * @param configSentDate 
         */
        public RemoteConfigResponseBuilder withConfigSentDate(String configSentDate) {
            this.configSentDate = configSentDate;
            return this;
        }

        /**
         * 
         * @param expiration 
         */
        public RemoteConfigResponseBuilder withExpiration(LocalDate expiration) {
            this.expiration = expiration;
            return this;
        }

        /**
         * 
         * @param status 
         */
        public RemoteConfigResponseBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        /**
         * 
         * @param category 
         */
        public RemoteConfigResponseBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        /**
         * 
         * @param popup 
         */
        public RemoteConfigResponseBuilder withisPopup(Boolean popup) {
            this.isPopup = popup;
            return this;
        }

        /**
         * 
         * @param params 
         */
        public RemoteConfigResponseBuilder withConfigParams(Map<String, Object> params) {
            if (params != null ) {
                root.putAll(params);
            }
            return this;
        }

        /**
         * 
         * @param conditional 
         */
        public RemoteConfigResponseBuilder withIsConditional(Boolean conditional) {
            this.isConditional = conditional;
            return this;
        }

        /**
         * 
         * @param conditionParam 
         */
        public RemoteConfigResponseBuilder withConditionParam(String conditionParam) {
            this.conditionParam = conditionParam;
            return this;
        }



        /**
         * 
         */
        public RemoteConfigResponse build() {

            final String configParams;
            try {
                configParams = mapper.writeValueAsString(root);
            } catch (JsonProcessingException e) {
                // Should not happen
                throw new RuntimeException(e);
            }

            return new RemoteConfigResponse(id, configSentDate, expiration, status, category, isPopup, isConditional, conditionParam, configParams);
        }
    }
}

