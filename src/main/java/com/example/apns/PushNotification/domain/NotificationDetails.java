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
 * 
 */
@Document
public class NotificationDetails {

    @Id
    private String id;
    private String customerID;
    private String aid;
    private LocalDate notificationSentDate;
    private Long expiration;
    private String status;
    private String systemId;
    private String systemDate;
    private String alertBody;
    private String topic;
    private String alertTitle;
    private String category;
    private Map<String, Object> notificationParams;
    private Map<String, Object> customParams;
    private Boolean isMutableContent;
    private String inAppPriority;
    private String pushPriority;
    private int size;
    private boolean contentAvailable;
    private boolean silent;
    private boolean inAppNotification;
    private boolean pushNotification;


    /**
     * 
     */
    public NotificationDetails() {
    }

    /**
     * 
     * @param customerID 
     * @param aid 
     * @param notificationSentDate 
     * @param expiration 
     * @param status 
     * @param systemId 
     * @param systemDate 
     * @param alertBody 
     * @param topic 
     * @param alertTitle 
     * @param category 
     * @param notificationParams 
     * @param customParams 
     * @param mutableContent 
     * @param inAppPriority 
     * @param pushPriority 
     * @param size 
     * @param contentAvailable 
     * @param silent 
     * @param inAppNotification 
     * @param pushNotification 
     */
    public NotificationDetails(String customerID, String aid, LocalDate notificationSentDate, Long expiration, String status, String systemId, String systemDate, String alertBody, String topic, String alertTitle, String category, Map<String, Object> notificationParams, Map<String, Object> customParams, Boolean mutableContent, String inAppPriority, String pushPriority, int size, boolean contentAvailable, boolean silent, boolean inAppNotification, boolean pushNotification) {
        this.customerID = customerID;
        this.aid = aid;
        this.notificationSentDate = notificationSentDate;
        this.expiration = expiration;
        this.status = status;
        this.systemId = systemId;
        this.systemDate = systemDate;
        this.alertBody = alertBody;
        this.topic = topic;
        this.alertTitle = alertTitle;
        this.category = category;
        this.notificationParams = notificationParams;
        this.customParams = customParams;
        this.isMutableContent = mutableContent;
        this.inAppPriority = inAppPriority;
        this.pushPriority = pushPriority;
        this.size = size;
        this.contentAvailable = contentAvailable;
        this.silent = silent;
        this.inAppNotification = inAppNotification;
        this.pushNotification = pushNotification;
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
     * 
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * 
     * @param customerID 
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * 
     */
    public String getAid() {
        return aid;
    }

    /**
     * 
     * @param aid 
     */
    public void setAid(String aid) {
        this.aid = aid;
    }

    /**
     * 
     */
    public LocalDate getNotificationSentDate() {
        return notificationSentDate;
    }

    /**
     * 
     * @param notificationSentDate 
     */
    public void setNotificationSentDate(LocalDate notificationSentDate) {
        this.notificationSentDate = notificationSentDate;
    }

    /**
     * 
     */
    public Long getExpiration() {
        return expiration;
    }

    /**
     * 
     * @param expiration 
     */
    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    /**
     * 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * 
     */
    public String getSystemDate() {
        return systemDate;
    }

    /**
     * 
     * @param systemDate 
     */
    public void setSystemDate(String systemDate) {
        this.systemDate = systemDate;
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
    public String getTopic() {
        return topic;
    }

    /**
     * 
     * @param topic 
     */
    public void setTopic(String topic) {
        this.topic = topic;
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
    public Boolean getMutableContent() {
        return isMutableContent;
    }

    /**
     * 
     * @param mutableContent 
     */
    public void setMutableContent(Boolean mutableContent) {
        this.isMutableContent = mutableContent;
    }

    /**
     * 
     */
    public String getInAppPriority() {
        return inAppPriority;
    }

    /**
     * 
     * @param inAppPriority 
     */
    public void setInAppPriority(String inAppPriority) {
        this.inAppPriority = inAppPriority;
    }

    /**
     * 
     */
    public String getPushPriority() {
        return pushPriority;
    }

    /**
     * 
     * @param pushPriority 
     */
    public void setPushPriority(String pushPriority) {
        this.pushPriority = pushPriority;
    }

    /**
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * 
     * @param size 
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 
     */
    public boolean isContentAvailable() {
        return contentAvailable;
    }

    /**
     * 
     * @param contentAvailable 
     */
    public void setContentAvailable(boolean contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    /**
     * 
     */
    public boolean isSilent() {
        return silent;
    }

    /**
     * 
     * @param silent 
     */
    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    /**
     * 
     */
    public boolean isInAppNotification() {
        return inAppNotification;
    }

    /**
     * 
     * @param inAppNotification 
     */
    public void setInAppNotification(boolean inAppNotification) {
        this.inAppNotification = inAppNotification;
    }

    /**
     * 
     */
    public boolean isPushNotification() {
        return pushNotification;
    }

    /**
     * 
     * @param pushNotification 
     */
    public void setPushNotification(boolean pushNotification) {
        this.pushNotification = pushNotification;
    }

    /**
     * 
     * @param o 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationDetails that = (NotificationDetails) o;
        return size == that.size &&
                contentAvailable == that.contentAvailable &&
                silent == that.silent &&
                inAppNotification == that.inAppNotification &&
                pushNotification == that.pushNotification &&
                Objects.equals(id, that.id) &&
                Objects.equals(customerID, that.customerID) &&
                Objects.equals(aid, that.aid) &&
                Objects.equals(notificationSentDate, that.notificationSentDate) &&
                Objects.equals(expiration, that.expiration) &&
                Objects.equals(status, that.status) &&
                Objects.equals(systemId, that.systemId) &&
                Objects.equals(systemDate, that.systemDate) &&
                Objects.equals(alertBody, that.alertBody) &&
                Objects.equals(topic, that.topic) &&
                Objects.equals(alertTitle, that.alertTitle) &&
                Objects.equals(category, that.category) &&
                Objects.equals(notificationParams, that.notificationParams) &&
                Objects.equals(customParams, that.customParams) &&
                Objects.equals(isMutableContent, that.isMutableContent) &&
                Objects.equals(inAppPriority, that.inAppPriority) &&
                Objects.equals(pushPriority, that.pushPriority);
    }

    /**
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, customerID, aid, notificationSentDate, expiration, status, systemId, systemDate, alertBody, topic, alertTitle, category, notificationParams, customParams, isMutableContent, inAppPriority, pushPriority, size, contentAvailable, silent, inAppNotification, pushNotification);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "NotificationDetails{" +
                "id='" + id + '\'' +
                ", customerID='" + customerID + '\'' +
                ", aid='" + aid + '\'' +
                ", notificationSentDate=" + notificationSentDate +
                ", expiration=" + expiration +
                ", status='" + status + '\'' +
                ", systemId='" + systemId + '\'' +
                ", systemDate='" + systemDate + '\'' +
                ", alertBody='" + alertBody + '\'' +
                ", topic='" + topic + '\'' +
                ", alertTitle='" + alertTitle + '\'' +
                ", category='" + category + '\'' +
                ", notificationParams=" + notificationParams +
                ", customParams=" + customParams +
                ", isMutableContent=" + isMutableContent +
                ", inAppPriority='" + inAppPriority + '\'' +
                ", pushPriority='" + pushPriority + '\'' +
                ", size=" + size +
                ", contentAvailable=" + contentAvailable +
                ", silent=" + silent +
                ", inAppNotification=" + inAppNotification +
                ", pushNotification=" + pushNotification +
                '}';
    }
}

