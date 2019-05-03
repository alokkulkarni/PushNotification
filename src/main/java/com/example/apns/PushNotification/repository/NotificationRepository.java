/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.repository;

import com.example.apns.PushNotification.domain.NotificationDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<NotificationDetails, String> {


    /**
     * 
     * @param id 
     * @param status 
     */
    List<NotificationDetails> findNotificationByCustomerIDAndStatusEquals(String id, String status);

    /**
     * 
     * @param id 
     * @param status 
     */
    List<NotificationDetails> findNotificationDetailsByCustomerIDAndStatusEqualsAndInAppNotificationIsTrue(String id, String status);

    /**
     * 
     * @param status 
     */
    List<NotificationDetails> findNotificationByStatusEquals(String status);

    /**
     * 
     * @param expiration 
     */
    List<NotificationDetails> findNotificationDetailsByExpirationEquals(Long expiration);

}

