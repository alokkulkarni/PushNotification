/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.controller;


import com.example.apns.PushNotification.domain.RemoteConfig;
import com.example.apns.PushNotification.repository.RemoteConfigRepository;
import com.example.apns.PushNotification.util.RemoteConfigRequest;
import com.example.apns.PushNotification.util.RemoteConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Remote config controller.
 */
@RestController
public class RemoteConfigController {

    private final RemoteConfigRepository remoteConfigRepository;

    /**
     * Instantiates a new Remote config controller.
     *
     * @param remoteConfigRepository the remote config repository
     */
    @Autowired
    public RemoteConfigController(RemoteConfigRepository remoteConfigRepository) {
        this.remoteConfigRepository = remoteConfigRepository;
    }

    /**
     * Gets remote active configs.
     *
     * @param status the status
     * @return the remote active configs
     */
    @GetMapping("/configs/{status}")
    public List<RemoteConfigResponse> getRemoteActiveConfigs(@PathVariable("status") String status) {

        return this.remoteConfigRepository.getRemoteConfigByStatusEquals(status)
                .stream()
                .map(this::setConfigResponse)
                .collect(Collectors.toList());
    }

    /**
     * Create remote config remote config.
     *
     * @param remoteConfig the remote config
     * @return the remote config
     */
    @PostMapping("/configs")
    public RemoteConfig createRemoteConfig(@RequestBody RemoteConfigRequest remoteConfig) {
        return this.upsertRemoteConfig(remoteConfig);
    }

    /**
     * Update config status string.
     *
     * @param id     the id
     * @param status the status
     * @return the string
     */
    @PostMapping("/configs/{id}/updateStatus")
    public String updateConfigStatus(@PathVariable("id") String id, @RequestParam String status) {

        Optional<RemoteConfig> one = remoteConfigRepository.findById(id);


        if (one.isPresent()) {
            Optional<RemoteConfig> remoteConfig = remoteConfigRepository.findById(id);
            remoteConfig.get().setStatus(status);
            remoteConfigRepository.save(remoteConfig.get());
        } else {
            System.out.println("no configs found");
            return " ";
        }

        return "Updated";
    }


    /**
     * 
     * @param remoteConfig 
     */
    private RemoteConfig upsertRemoteConfig(RemoteConfigRequest remoteConfig) {
        RemoteConfig config = new RemoteConfig();


        if (remoteConfig.getCategory() != null ) {
            config.setCategory(remoteConfig.getCategory());
        } else {
            config.setCategory("Generic");
        }

        config.setConfigSentDate(LocalDate.now());
        System.out.println(remoteConfig.getCustomParams());
        if (remoteConfig.getCustomParams() != null) {
            config.setCustomParams(remoteConfig.getCustomParams());
        } else {
            new HashMap<>();
        }

        config.setExpiration(remoteConfig.getExpiration());

        config.setStatus(remoteConfig.getStatus());

        config.setPopup(remoteConfig.getPopup());
        config.setConditional(remoteConfig.getConditional());
        config.setConditionParam(remoteConfig.getConditionParam() != null ? remoteConfig.getConditionParam() : " ");

        RemoteConfig savedConfig = remoteConfigRepository.save(config);

        return savedConfig;
    }

    /**
     * 
     * @param remoteConfig 
     */
    private RemoteConfigResponse setConfigResponse(RemoteConfig remoteConfig) {

        System.out.println(remoteConfig.getPopup());

        return RemoteConfigResponse.RemoteConfigResponseBuilder.aRemoteConfigResponse()
                    .withCategory(remoteConfig.getCategory())
                    .withConfigSentDate(remoteConfig.getConfigSentDate().toString())
                    .withExpiration(remoteConfig.getExpiration())
                    .withId(remoteConfig.getId())
                    .withStatus(remoteConfig.getStatus())
                    .withisPopup(remoteConfig.getPopup())
                    .withIsConditional(remoteConfig.getConditional())
                    .withConditionParam(remoteConfig.getConditionParam() != null ? remoteConfig.getConditionParam() : " ")
                    .withConfigParams(remoteConfig.getCustomParams() != null ? remoteConfig.getCustomParams() : new HashMap<>())
                    .build();

    }
}

