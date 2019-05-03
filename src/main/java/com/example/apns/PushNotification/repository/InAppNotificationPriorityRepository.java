/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.repository;

import com.example.apns.PushNotification.domain.InAppNotificationPriority;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InAppNotificationPriorityRepository extends MongoRepository<InAppNotificationPriority, String> {

    /**
     * 
     * @param category 
     */
    InAppNotificationPriority findInAppNotificationPriorityByCategoryEquals(String category);
}

