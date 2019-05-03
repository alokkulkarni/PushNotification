/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.util;

import com.example.apns.PushNotification.domain.RemoteConfig;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

/**
 * 
 */
public class RemoteConfigRequest {

    private LocalDate expiration;
    private String status;
    private String category;
    private Boolean isPopup;
    private Boolean isConditional;
    private String conditionParam;
    private RemoteConfig.ConfigType configType;
    private Map<String, Object> customParams;

    /**
     * 
     */
    public RemoteConfigRequest() {
    }

    /**
     * 
     * @param expiration 
     * @param status 
     * @param category 
     * @param isPopup 
     * @param isConditional 
     * @param conditionParam 
     * @param customParams 
     */
    public RemoteConfigRequest(LocalDate expiration, String status, String category, Boolean isPopup, Boolean isConditional, String conditionParam, Map<String, Object> customParams) {
        this.expiration = expiration;
        this.status = status;
        this.category = category;
        this.isPopup = isPopup;
        this.isConditional = isConditional;
        this.conditionParam = conditionParam;
        this.customParams = customParams;
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
     * 
     * @param o 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoteConfigRequest that = (RemoteConfigRequest) o;
        return Objects.equals(expiration, that.expiration) &&
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
        return Objects.hash(expiration, status, category, isPopup, isConditional, conditionParam, customParams);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "RemoteConfigRequest{" +
                "expiration=" + expiration +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                ", isPopup=" + isPopup +
                ", isConditional=" + isConditional +
                ", conditionParam='" + conditionParam + '\'' +
                ", customParams=" + customParams +
                '}';
    }
}

