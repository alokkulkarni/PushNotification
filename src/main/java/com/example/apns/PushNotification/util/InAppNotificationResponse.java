/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.util;

import java.util.Map;
import java.util.Objects;

/**
 * 
 */
public class InAppNotificationResponse {

    private String id;
    private String status;
    private String systemId;
    private String systemDate;
    private String alertBody;
    private String alertTitle;
    private String category;
    private Map<String, Object> notificationParams;
    private Map<String, Object> customParams;
    private String priority;

    /**
     * 
     */
    public InAppNotificationResponse() {
    }

    /**
     * 
     * @param id 
     * @param status 
     * @param systemId 
     * @param systemDate 
     * @param alertBody 
     * @param alertTitle 
     * @param category 
     * @param notificationParams 
     * @param customParams 
     * @param priority 
     */
    public InAppNotificationResponse(String id, String status, String systemId, String systemDate, String alertBody, String alertTitle, String category, Map<String, Object> notificationParams, Map<String, Object> customParams, String priority) {
        this.id = id;
        this.status = status;
        this.systemId = systemId;
        this.systemDate = systemDate;
        this.alertBody = alertBody;
        this.alertTitle = alertTitle;
        this.category = category;
        this.notificationParams = notificationParams;
        this.customParams = customParams;
        this.priority = priority;
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
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(String id) {
        this.id = id;
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
     * Getter for property 'systemId'.
     *
     * @return Value for property 'systemId'.
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Setter for property 'systemId'.
     *
     * @param systemId Value to set for property 'systemId'.
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * Getter for property 'systemDate'.
     *
     * @return Value for property 'systemDate'.
     */
    public String getSystemDate() {
        return systemDate;
    }

    /**
     * Setter for property 'systemDate'.
     *
     * @param systemDate Value to set for property 'systemDate'.
     */
    public void setSystemDate(String systemDate) {
        this.systemDate = systemDate;
    }

    /**
     * Getter for property 'alertBody'.
     *
     * @return Value for property 'alertBody'.
     */
    public String getAlertBody() {
        return alertBody;
    }

    /**
     * Setter for property 'alertBody'.
     *
     * @param alertBody Value to set for property 'alertBody'.
     */
    public void setAlertBody(String alertBody) {
        this.alertBody = alertBody;
    }

    /**
     * Getter for property 'alertTitle'.
     *
     * @return Value for property 'alertTitle'.
     */
    public String getAlertTitle() {
        return alertTitle;
    }

    /**
     * Setter for property 'alertTitle'.
     *
     * @param alertTitle Value to set for property 'alertTitle'.
     */
    public void setAlertTitle(String alertTitle) {
        this.alertTitle = alertTitle;
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
     * Getter for property 'notificationParams'.
     *
     * @return Value for property 'notificationParams'.
     */
    public Map<String, Object> getNotificationParams() {
        return notificationParams;
    }

    /**
     * Setter for property 'notificationParams'.
     *
     * @param notificationParams Value to set for property 'notificationParams'.
     */
    public void setNotificationParams(Map<String, Object> notificationParams) {
        this.notificationParams = notificationParams;
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
     * Getter for property 'priority'.
     *
     * @return Value for property 'priority'.
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Setter for property 'priority'.
     *
     * @param priority Value to set for property 'priority'.
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * 
     * @param o 
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InAppNotificationResponse response = (InAppNotificationResponse) o;
        return Objects.equals(id, response.id) &&
                Objects.equals(status, response.status) &&
                Objects.equals(systemId, response.systemId) &&
                Objects.equals(systemDate, response.systemDate) &&
                Objects.equals(alertBody, response.alertBody) &&
                Objects.equals(alertTitle, response.alertTitle) &&
                Objects.equals(category, response.category) &&
                Objects.equals(notificationParams, response.notificationParams) &&
                Objects.equals(customParams, response.customParams) &&
                Objects.equals(priority, response.priority);
    }

    /**
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, status, systemId, systemDate, alertBody, alertTitle, category, notificationParams, customParams, priority);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "InAppNotificationResponse{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", systemId='" + systemId + '\'' +
                ", systemDate='" + systemDate + '\'' +
                ", alertBody='" + alertBody + '\'' +
                ", alertTitle='" + alertTitle + '\'' +
                ", category='" + category + '\'' +
                ", notificationParams=" + notificationParams +
                ", customParams=" + customParams +
                ", priority='" + priority + '\'' +
                '}';
    }
}

