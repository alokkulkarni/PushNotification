/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * The type Notification request.
 */
public class NotificationRequest {


    private String alertTitle;
    private String alertBody;
    private Map<String, Object> customParams;
    private Map<String, Object> notificationParams;
    private int badge;
    @JsonProperty
    private boolean isSilent;
    @JsonProperty
    private boolean isInAppNotification;
    @JsonProperty
    private boolean isPushNotification;
    @JsonProperty
    private boolean isMutableContent;
    @JsonProperty
    private String mutableContent;
    @JsonProperty
    private boolean hasExpiration;
    private long expiration;
    private Priority priority;
    private String category;
    private String systemId;


    /**
     * The enum Priority.
     */
    public enum Priority {
        /**
         * Immediate priority.
         */
        IMMEDIATE(10),
        /**
         * Powerconsideration priority.
         */
        POWERCONSIDERATION(5);

        private final int code;

        /** @param code */
        Priority(int code) {
            this.code = code;
        }

        /**
         * Getter for property 'code'.
         *
         * @return Value for property 'code'.
         */
        public int getCode() {
            return this.code;
        }
    }


    /**
     * Constructs a new NotificationRequest.
     */
    public NotificationRequest() {
    }

    /**
     * Instantiates a new Notification request.
     *
     * @param alertTitle          the alert title
     * @param alertBody           the alert body
     * @param badge               the badge
     * @param isSilent            the is silent
     * @param isInAppNotification the is in app notification
     * @param isPushNotification  the is push notification
     * @param isMutableContent    the is mutable content
     * @param mutableContent      the mutable content
     * @param hasExpiration       the has expiration
     * @param expiration          the expiration
     * @param priority            the priority
     * @param category            the category
     * @param systemId
     */
    public NotificationRequest(String alertTitle, String alertBody, int badge, boolean isSilent, boolean isInAppNotification, boolean isPushNotification, boolean isMutableContent, String mutableContent, boolean hasExpiration, long expiration, Priority priority, String category, String systemId) {
        this.alertTitle = alertTitle;
        this.alertBody = alertBody;
        this.badge = badge;
        this.isSilent = isSilent;
        this.isInAppNotification = isInAppNotification;
        this.isPushNotification = isPushNotification;
        this.isMutableContent = isMutableContent;
        this.mutableContent = mutableContent;
        this.hasExpiration = hasExpiration;
        this.expiration = expiration;
        this.priority = priority;
        this.category = category;
        this.systemId = systemId;
    }

    /**
     * Instantiates a new Notification request.
     *
     * @param customParams        the custom params
     * @param notificationParams
     * @param alertTitle          the alert title
     * @param alertBody           the alert body
     * @param badge               the badge
     * @param isSilent            the is silent
     * @param isInAppNotification the is in app notification
     * @param isPushNotification  the is push notification
     * @param isMutableContent    the is mutable content
     * @param mutableContent      the mutable content
     * @param hasExpiration       the has expiration
     * @param expiration          the expiration
     * @param priority            the priority
     * @param category            the category
     * @param systemId
     */
    public NotificationRequest(Map<String, Object> customParams,Map<String, Object> notificationParams, String alertTitle, String alertBody, int badge, boolean isSilent, boolean isInAppNotification, boolean isPushNotification, boolean isMutableContent, String mutableContent, boolean hasExpiration, long expiration, Priority priority, String category, String systemId) {
        this.customParams = customParams;
        this.notificationParams = notificationParams;
        this.alertTitle = alertTitle;
        this.alertBody = alertBody;
        this.badge = badge;
        this.isSilent = isSilent;
        this.isInAppNotification = isInAppNotification;
        this.isPushNotification = isPushNotification;
        this.isMutableContent = isMutableContent;
        this.mutableContent = mutableContent;
        this.hasExpiration = hasExpiration;
        this.expiration = expiration;
        this.priority = priority;
        this.category = category;
        this.systemId = systemId;
    }

    /**
     * 
     */
    public String getAlertTitle() {
        return alertTitle;
    }

    /**
     * 
     * @param alertTitle 
     */
    public void setAlertTitle(String alertTitle) {
        this.alertTitle = alertTitle;
    }

    /**
     * 
     */
    public String getAlertBody() {
        return alertBody;
    }

    /**
     * 
     * @param alertBody 
     */
    public void setAlertBody(String alertBody) {
        this.alertBody = alertBody;
    }

    /**
     * 
     */
    public Map<String, Object> getCustomParams() {
        return customParams;
    }

    /**
     * 
     * @param customParams 
     */
    public void setCustomParams(Map<String, Object> customParams) {
        this.customParams = customParams;
    }

    /**
     * 
     */
    public Map<String, Object> getNotificationParams() {
        return notificationParams;
    }

    /**
     * 
     * @param notificationParams 
     */
    public void setNotificationParams(Map<String, Object> notificationParams) {
        this.notificationParams = notificationParams;
    }

    /**
     * 
     */
    public int getBadge() {
        return badge;
    }

    /**
     * 
     * @param badge 
     */
    public void setBadge(int badge) {
        this.badge = badge;
    }

    /**
     * 
     */
    public boolean isSilent() {
        return isSilent;
    }

    /**
     * 
     * @param silent 
     */
    public void setSilent(boolean silent) {
        isSilent = silent;
    }

    /**
     * 
     */
    public boolean isInAppNotification() {
        return isInAppNotification;
    }

    /**
     * 
     * @param inAppNotification 
     */
    public void setInAppNotification(boolean inAppNotification) {
        isInAppNotification = inAppNotification;
    }

    /**
     * 
     */
    public boolean isPushNotification() {
        return isPushNotification;
    }

    /**
     * 
     * @param pushNotification 
     */
    public void setPushNotification(boolean pushNotification) {
        isPushNotification = pushNotification;
    }

    /**
     * 
     */
    public boolean isMutableContent() {
        return isMutableContent;
    }

    /**
     * 
     * @param mutableContent 
     */
    public void setMutableContent(boolean mutableContent) {
        isMutableContent = mutableContent;
    }

    /**
     * 
     */
    public String getMutableContent() {
        return mutableContent;
    }

    /**
     * 
     * @param mutableContent 
     */
    public void setMutableContent(String mutableContent) {
        this.mutableContent = mutableContent;
    }

    /**
     * 
     */
    public boolean isHasExpiration() {
        return hasExpiration;
    }

    /**
     * 
     * @param hasExpiration 
     */
    public void setHasExpiration(boolean hasExpiration) {
        this.hasExpiration = hasExpiration;
    }

    /**
     * 
     */
    public long getExpiration() {
        return expiration;
    }

    /**
     * 
     * @param expiration 
     */
    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    /**
     * 
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * 
     * @param priority 
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * 
     */
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category 
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 
     * @param systemId 
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}

