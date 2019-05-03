/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.repository;

import com.example.apns.PushNotification.domain.RemoteConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RemoteConfigRepository extends MongoRepository<RemoteConfig, String> {


    /**
     * 
     * @param Status 
     */
    List<RemoteConfig> getRemoteConfigByStatusEquals(String Status);

    /**
     * 
     * @param id 
     */
    @Query(value = "{_id: ?0}")
    Optional<RemoteConfig> findRemoteConfigByIdentifier(String id);


}

