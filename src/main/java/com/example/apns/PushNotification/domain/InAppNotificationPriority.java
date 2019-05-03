/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * 
 */
@Document
public class InAppNotificationPriority {

    @Id
    private String id;
    private String category;
    private String priority;
    private int priorityCode;

    /**
     * 
     */
    public InAppNotificationPriority() {
    }

    /**
     * 
     * @param category 
     * @param priority 
     * @param priorityCode 
     */
    public InAppNotificationPriority(String category, String priority, int priorityCode) {
        this.category = category;
        this.priority = priority;
        this.priorityCode = priorityCode;
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
     * Getter for property 'priorityCode'.
     *
     * @return Value for property 'priorityCode'.
     */
    public int getPriorityCode() {
        return priorityCode;
    }

    /**
     * Setter for property 'priorityCode'.
     *
     * @param priorityCode Value to set for property 'priorityCode'.
     */
    public void setPriorityCode(int priorityCode) {
        this.priorityCode = priorityCode;
    }

    /**
     * 
     * @param o 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InAppNotificationPriority that = (InAppNotificationPriority) o;
        return priorityCode == that.priorityCode &&
                Objects.equals(id, that.id) &&
                Objects.equals(category, that.category) &&
                Objects.equals(priority, that.priority);
    }

    /**
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, category, priority, priorityCode);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "InAppNotificationPriority{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", priorityCode=" + priorityCode +
                '}';
    }
}

