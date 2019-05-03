/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

/**
 * The type Remote config.
 */
@Document
public class RemoteConfig {

    @Id
    private String id;
    private ConfigType configType;
    private LocalDate configSentDate;
    private LocalDate expiration;
    private String status;
    private String category;
    private Boolean isPopup;
    private Boolean isConditional;
    private String conditionParam;
    private Map<String, Object> customParams;

    /**
     * Instantiates a new Remote config.
     */
    public RemoteConfig() {
    }

    /**
     * Instantiates a new Remote config.
     *
     * @param configType
     * @param configSentDate the config sent date
     * @param expiration     the expiration
     * @param status         the status
     * @param category       the category
     * @param isPopup        the is popup
     * @param isConditional  the is conditional
     * @param conditionParam the condition param
     * @param customParams   the custom params
     */
    public RemoteConfig(ConfigType configType, LocalDate configSentDate, LocalDate expiration, String status, String category, Boolean isPopup, Boolean isConditional, String conditionParam, Map<String, Object> customParams) {
        this.configType = configType;
        this.configSentDate = configSentDate;
        this.expiration = expiration;
        this.status = status;
        this.category = category;
        this.isPopup = isPopup;
        this.isConditional = isConditional;
        this.conditionParam = conditionParam;
        this.customParams = customParams;
    }

    /**
     * The enum Config type.
     */
    public enum ConfigType {
        /**
         * Ab testing config type.
         */
        ABTesting(10),
        /**
         * Interstetial config type.
         */
        Interstetial(15),
        /**
         * Parameter change config type.
         */
        ParameterChange(20);

        private final int code;

        /**
         * 
         * @param code 
         */
        ConfigType(int code) {
            this.code = code;
        }

        /**
         * Gets code.
         *
         * @return the code
         */
        public int getCode() {
            return this.code;
        }

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
    public LocalDate getConfigSentDate() {
        return configSentDate;
    }

    /**
     * Setter for property 'configSentDate'.
     *
     * @param configSentDate Value to set for property 'configSentDate'.
     */
    public void setConfigSentDate(LocalDate configSentDate) {
        this.configSentDate = configSentDate;
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
     * Setter for property 'expiration'.
     *
     * @param expiration Value to set for property 'expiration'.
     */
    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
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
     * Setter for property 'status'.
     *
     * @param status Value to set for property 'status'.
     */
    public void setStatus(String status) {
        this.status = status;
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
     * Setter for property 'category'.
     *
     * @param category Value to set for property 'category'.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter for property 'customParams'.
     *
     * @return Value for property 'customParams'.
     */
    public Map<String, Object> getCustomParams() {
        return customParams;
    }

    /**
     * Setter for property 'customParams'.
     *
     * @param customParams Value to set for property 'customParams'.
     */
    public void setCustomParams(Map<String, Object> customParams) {
        this.customParams = customParams;
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
     * Setter for property 'popup'.
     *
     * @param popup Value to set for property 'popup'.
     */
    public void setPopup(Boolean popup) {
        isPopup = popup;
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
     * Setter for property 'conditional'.
     *
     * @param conditional Value to set for property 'conditional'.
     */
    public void setConditional(Boolean conditional) {
        isConditional = conditional;
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
     * Setter for property 'conditionParam'.
     *
     * @param conditionParam Value to set for property 'conditionParam'.
     */
    public void setConditionParam(String conditionParam) {
        this.conditionParam = conditionParam;
    }

    /**
     * Getter for property 'configType'.
     *
     * @return Value for property 'configType'.
     */
    public ConfigType getConfigType() {
        return configType;
    }

    /**
     * Setter for property 'configType'.
     *
     * @param configType Value to set for property 'configType'.
     */
    public void setConfigType(ConfigType configType) {
        this.configType = configType;
    }

    /**
     * 
     * @param o 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoteConfig that = (RemoteConfig) o;
        return Objects.equals(id, that.id) &&
                configType == that.configType &&
                Objects.equals(configSentDate, that.configSentDate) &&
                Objects.equals(expiration, that.expiration) &&
                Objects.equals(status, that.status) &&
                Objects.equals(category, that.category) &&
                Objects.equals(isPopup, that.isPopup) &&
                Objects.equals(isConditional, that.isConditional) &&
                Objects.equals(conditionParam, that.conditionParam) &&
                Objects.equals(customParams, that.customParams);
    }

    /**
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, configType, configSentDate, expiration, status, category, isPopup, isConditional, conditionParam, customParams);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "RemoteConfig{" +
                "id='" + id + '\'' +
                ", configType=" + configType +
                ", configSentDate=" + configSentDate +
                ", expiration=" + expiration +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                ", isPopup=" + isPopup +
                ", isConditional=" + isConditional +
                ", conditionParam='" + conditionParam + '\'' +
                ", customParams=" + customParams +
                '}';
    }
}

