/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.repository;

import com.example.apns.PushNotification.domain.DeviceDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * The interface Device repository.
 */
@Repository
public interface DeviceRepository extends MongoRepository<DeviceDetails, Long> {

    /**
     * Find device details by customer id list.
     *
     * @param id the id
     * @return the list
     */
    List<DeviceDetails> findDeviceDetailsByCustomerId(String id);

    /**
     * Find device details by aid device details.
     *
     * @param aid the aid
     * @return the device details
     */
    DeviceDetails findDeviceDetailsByAid(String aid);

    /**
     * Find device details by status list.
     *
     * @param status the status
     * @return the list
     */
    List<DeviceDetails> findDeviceDetailsByStatus(String status);

    /**
     * Instantiates a new Find device details by customer id andis master.
     *
     * @param id     the id
     * @param master the master
     */
//    DeviceDetails findDeviceDetailsByCustomerIDAndisMaster(String id, Boolean master);


}

