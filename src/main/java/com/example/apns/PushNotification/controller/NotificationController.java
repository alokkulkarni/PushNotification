/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.controller;

import com.clevertap.apns.ApnsClient;
import com.clevertap.apns.Notification;
import com.clevertap.apns.NotificationResponse;
import com.clevertap.apns.clients.ApnsClientBuilder;
import com.example.apns.PushNotification.repository.InAppNotificationPriorityRepository;
import com.example.apns.PushNotification.util.DeviceDetailsBuilder;
import com.example.apns.PushNotification.util.ExtendedNotification;
import com.example.apns.PushNotification.domain.NotificationDetails;
import com.example.apns.PushNotification.repository.DeviceRepository;
import com.example.apns.PushNotification.domain.DeviceDetails;
import com.example.apns.PushNotification.repository.NotificationRepository;
import com.example.apns.PushNotification.util.InAppNotificationResponse;
import com.example.apns.PushNotification.util.NotificationRequest;
import com.turo.pushy.apns.DeliveryPriority;
import com.turo.pushy.apns.PushNotificationResponse;
import com.turo.pushy.apns.util.ApnsPayloadBuilder;
import com.turo.pushy.apns.util.SimpleApnsPushNotification;
import com.turo.pushy.apns.util.concurrent.PushNotificationFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


/**
 * The type Notification controller.
 */
@RestController
public class NotificationController {

    private static final String PUSH_TOPIC = "com.alok.pushExample";
    private final DeviceRepository deviceRepository;
    private final NotificationRepository notificationRepository;
    private final InAppNotificationPriorityRepository inAppNotificationPriorityRepository;
    private final com.turo.pushy.apns.ApnsClient apnsClient;

    @Value("classpath:file/AuthKey.p8")
    private String filePath;

    /**
     * Instantiates a new Notification controller.
     *
     * @param deviceRepository                    the device repository
     * @param notificationRepository              the notification repository
     * @param inAppNotificationPriorityRepository the in app notification priority repository
     * @param apnsClient                          the apns client
     */
    @Autowired
    public NotificationController(DeviceRepository deviceRepository, NotificationRepository notificationRepository, InAppNotificationPriorityRepository inAppNotificationPriorityRepository, com.turo.pushy.apns.ApnsClient apnsClient) {
        this.deviceRepository = deviceRepository;
        this.notificationRepository = notificationRepository;
        this.inAppNotificationPriorityRepository = inAppNotificationPriorityRepository;
        this.apnsClient = apnsClient;
    }

    /**
     * Send notification string.
     *
     * @param id                  the id
     * @param notificationRequest the notification request
     * @return the string
     */
    @PostMapping("/notifications/{id}/notification")
    public String sendNotification(@PathVariable("id") String id, @RequestBody NotificationRequest notificationRequest) {

        System.out.println("Notification Request : " + notificationRequest.isInAppNotification() + " " + notificationRequest.isSilent());

        this.notification(id, notificationRequest).forEach(notificationResponse -> {
            System.out.println(notificationResponse);
            System.out.println(notificationResponse.getError() + " " + notificationResponse.getResponseBody());
        });

        return "sent";
    }

    /**
     * Gets notifications.
     *
     * @param id the id
     * @return the notifications
     */
    @GetMapping("/notifications/{id}")
    public List<InAppNotificationResponse> getNotifications(@PathVariable("id") String id) {

        return this.notificationRepository.findNotificationDetailsByCustomerIDAndStatusEqualsAndInAppNotificationIsTrue(id, "active")
                .stream()
                .map(notificationDetails -> {
                    InAppNotificationResponse response = new InAppNotificationResponse();
                    response.setId(notificationDetails.getId());
                    response.setAlertTitle(notificationDetails.getAlertTitle());
                    response.setAlertBody(notificationDetails.getAlertBody());
                    response.setCategory(notificationDetails.getCategory());
                    response.setCustomParams(notificationDetails.getCustomParams() != null ? notificationDetails.getCustomParams() : new HashMap<>());
                    response.setNotificationParams(notificationDetails.getNotificationParams() != null ? notificationDetails.getNotificationParams() : new HashMap<>());
                    response.setPriority(notificationDetails.getInAppPriority());
                    response.setSystemId(notificationDetails.getSystemId());
                    response.setSystemDate(notificationDetails.getSystemDate());
                    response.setStatus(notificationDetails.getStatus());
                    return response;
                })
                .collect(Collectors.toList());
    }

    /**
     * Update notification status string.
     *
     * @param id     the id
     * @param status the status
     * @return the string
     */
    @PostMapping("/notifications/{id}/{status}")
    public String updateNotificationStatus(@PathVariable("id") String id, @PathVariable("status") String status) {

        Optional<NotificationDetails> notificationDetails = notificationRepository.findById(id);

        if (notificationDetails.isPresent()) {
            NotificationDetails nd = notificationDetails.get();
            nd.setStatus(status);
            notificationRepository.save(nd);
        } else {
            System.out.println("notification details not found");
        }

        return "Updated Status";
    }

    /**
     * Create device details string.
     *
     * @param deviceDetails the device details
     * @return the string
     */
    @PostMapping("/device")
    public String createDeviceDetails(@RequestBody DeviceDetails deviceDetails) {
        this.captureDeviceDetails(deviceDetails);
        return "created";
    }

    /**
     * Update device details string.
     *
     * @param aid           the device token
     * @param deviceDetails the device details
     * @return the string
     */
    @PatchMapping("/device/{aid}/updateDeviceDetails")
    public String updateDeviceDetails(@PathVariable("aid") String aid, @RequestBody DeviceDetails deviceDetails) {
        this.updateDevice(aid, deviceDetails);
        return "Updated";
    }


    /**
     * 
     * @param customerId 
     */
    private List<DeviceDetails> getDeviceDetails(String customerId) {
        System.out.println(customerId);
        List<DeviceDetails> deviceDetailsList = deviceRepository.findDeviceDetailsByCustomerId(customerId);
        System.out.println(deviceDetailsList.get(0));
        return deviceDetailsList;
    }

    /**
     * 
     * @param topic 
     */
    private ApnsClient buildClient(String topic) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {

        final ApnsClient client = new ApnsClientBuilder()
                .inSynchronousMode()
                .withDevelopmentGateway()
                .withApnsAuthKey("MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQg/IyEb3cERbXQr4SNgzROHdXzJ/c6ASK+pSU670WyNoSgCgYIKoZIzj0DAQehRANCAAQvOji/jL86A3q0TMkxVYamqAZSlGHRpwGApcaTYKkavntmDIwfv/4BEXQ90713RS/3ddL1MZQ1jfHMOnTqD031")
                .withTeamID("U5EMEFZ957")
                .withKeyID("D7F9C8W9C3")
                .withDefaultTopic(topic)
                .build();

        return client;
    }

    /**
     * 
     * @param id 
     * @param notificationRequest 
     */
    private List<NotificationResponse> notification(String id, NotificationRequest notificationRequest) {



        System.out.println("id is : - " + id);

        return this.getDeviceDetails(id)
                .stream()
                .map(deviceDetails -> {
                    Notification n;
                    ApnsPayloadBuilder payloadBuilder = new ApnsPayloadBuilder();
                    System.out.println("Token is : - " + deviceDetails.getDeviceToken());
                    System.out.println("Notification Request : " + notificationRequest.isInAppNotification() + " " + notificationRequest.isSilent());

                    if (notificationRequest.isSilent()) {
                        System.out.println("Notification Request : " + " " + notificationRequest.isSilent());
                        n = new ExtendedNotification.Builder(deviceDetails.getDeviceToken())
                                .contentAvailable(true)
                                .mutableContent(notificationRequest.isMutableContent())
                                .category(notificationRequest.getCategory() != null ? notificationRequest.getCategory() : "Generic")
                                .expiration(notificationRequest.isHasExpiration() ? notificationRequest.getExpiration() : 0)
                                .customField(notificationRequest.getNotificationParams() != null ? notificationRequest.getNotificationParams() : new HashMap<>())
                                .uuid(UUID.randomUUID())
                                .priority(Notification.Priority.IMMEDIATE)
                                .build();
                        payloadBuilder.setAlertTitle(notificationRequest.getAlertTitle() != null ? notificationRequest.getAlertTitle() : "Hello")
                                .setAlertSubtitle("This is a test Message")
                                .setAlertBody(notificationRequest.getAlertBody() != null ? notificationRequest.getAlertBody() : "Hello")
                                .setBadgeNumber(notificationRequest.getBadge() <= 0 ? 0 : notificationRequest.getBadge())
                                .setCategoryName(notificationRequest.getCategory() != null ? notificationRequest.getCategory() : "Generic")
                                .setContentAvailable(true)
                                .setMutableContent(notificationRequest.isMutableContent())
                                .setPreferStringRepresentationForAlerts(true)
                                .setShowActionButton(false)
                                .setSound(" ", false, 0.0)
                                .buildWithDefaultMaximumLength();
                    } else {
                        n = new ExtendedNotification.Builder(deviceDetails.getDeviceToken())
                                .contentAvailable(false)
                                .alertTitle(notificationRequest.getAlertTitle() != null ? notificationRequest.getAlertTitle() : "Hello")
                                .alertBody(notificationRequest.getAlertBody() != null ? notificationRequest.getAlertBody() : "Hello")
                                .badge(notificationRequest.getBadge() <= 0 ? 0 : notificationRequest.getBadge())
                                .category(notificationRequest.getCategory() != null ? notificationRequest.getCategory() : "Generic")
                                .expiration(notificationRequest.isHasExpiration() ? notificationRequest.getExpiration() : 0)
                                .priority(Notification.Priority.IMMEDIATE)
                                .mutableContent(notificationRequest.isMutableContent())
                                .customField(notificationRequest.getNotificationParams() != null ? notificationRequest.getNotificationParams() : new HashMap<>())
                                .uuid(UUID.randomUUID())
                                .build();
                        payloadBuilder.setAlertTitle(notificationRequest.getAlertTitle() != null ? notificationRequest.getAlertTitle() : "Hello")
                                .setAlertSubtitle("This is a test Message")
                                .setAlertBody(notificationRequest.getAlertBody() != null ? notificationRequest.getAlertBody() : "Hello")
                                .setBadgeNumber(notificationRequest.getBadge() <= 0 ? 0 : notificationRequest.getBadge())
                                .setCategoryName(notificationRequest.getCategory() != null ? notificationRequest.getCategory() : "Generic")
                                .setContentAvailable(false)
                                .setMutableContent(notificationRequest.isMutableContent())
                                .setPreferStringRepresentationForAlerts(true)
                                .setShowActionButton(true)
                                .setSound("Default", false, 1.0)
                                .setActionButtonLabel("Reply")
                                .setThreadId(UUID.randomUUID().toString())
                                .buildWithDefaultMaximumLength();
                    }

                    int size  = 0;
                    try {
                        size = n.getPayload().getBytes("UTF-8").length;
                    } catch (UnsupportedEncodingException e) {
                        size = 0;
                        e.printStackTrace();
                    }

                    this.saveNotification(notificationRequest, deviceDetails, size);


                    PushNotificationFuture<SimpleApnsPushNotification, PushNotificationResponse<SimpleApnsPushNotification>> responsePushNotificationFuture = apnsClient.sendNotification(new SimpleApnsPushNotification(deviceDetails.getDeviceToken(), deviceDetails.getDeviceBundleIdentifier().isEmpty() ? PUSH_TOPIC : deviceDetails.getDeviceBundleIdentifier(), payloadBuilder.buildWithDefaultMaximumLength(), new Date(), DeliveryPriority.IMMEDIATE, UUID.randomUUID().toString(), UUID.randomUUID()));
                    try {
                        if (responsePushNotificationFuture.get().isAccepted()) {
                            System.out.println("using pushy sucess --- " + responsePushNotificationFuture.get().toString());
                        } else {
                            System.out.println("using pushy rejection --- " + responsePushNotificationFuture.get().getRejectionReason());

                            if (responsePushNotificationFuture.get().getTokenInvalidationTimestamp() != null) {
                                System.out.println("using pushy invalid token --- " + responsePushNotificationFuture.get().getTokenInvalidationTimestamp());
                            }
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    ApnsClient client = null;
                    try {
                        client = this.buildClient(deviceDetails.getDeviceBundleIdentifier().isEmpty() ? PUSH_TOPIC : deviceDetails.getDeviceBundleIdentifier());
                    } catch (CertificateException e) {
                        e.printStackTrace();
                    } catch (UnrecoverableKeyException e) {
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (KeyStoreException e) {
                        e.printStackTrace();
                    } catch (KeyManagementException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    NotificationResponse result = client.push(n);
                    System.out.println("every result  : " + result);

                    if (result.getHttpStatusCode() == 410 ) {
                        deviceDetails.setStatus("Unregistered");
                        this.updateDevice("0", deviceDetails);
                    }
                    return result;

                })
                .collect(Collectors.toList());
    }

    /**
     * 
     * @param deviceDetails 
     */
    private DeviceDetails captureDeviceDetails(DeviceDetails deviceDetails) {

        DeviceDetails details = DeviceDetailsBuilder.aDeviceDetails()
                .withCustomerId(deviceDetails.getCustomerId().isEmpty() ? "12345678" : deviceDetails.getCustomerId())
                .withAid(deviceDetails.getAid().isEmpty() ? UUID.randomUUID().toString() : deviceDetails.getAid())
                .withDeviceApplicationVersion(deviceDetails.getDeviceApplicationVersion().isEmpty() ? "1.0" : deviceDetails.getDeviceApplicationVersion())
                .withDeviceBuild(deviceDetails.getDeviceBuild().isEmpty() ? "1.0" : deviceDetails.getDeviceBuild())
                .withDeviceBundleIdentifier(deviceDetails.getDeviceBundleIdentifier().isEmpty() ? "com.barclays" : deviceDetails.getDeviceBundleIdentifier() )
                .withDevicedeploymentTarget(deviceDetails.getDevicedeploymentTarget().isEmpty() ? "11.0" : deviceDetails.getDevicedeploymentTarget())
                .withDeviceIMEINumber(deviceDetails.getDeviceIMEINumber().isEmpty() ? " " : deviceDetails.getDeviceIMEINumber())
                .withDeviceName(deviceDetails.getDeviceName().isEmpty() ? "Barclays" : deviceDetails.getDeviceName())
                .withDeviceOS(deviceDetails.getDeviceOS().isEmpty() ? "iOS" : deviceDetails.getDeviceOS())
                .withDeviceSerialNumber(deviceDetails.getDeviceSerialNumber().isEmpty() ? " ": deviceDetails.getDeviceSerialNumber())
                .withDeviceToken(deviceDetails.getDeviceToken().isEmpty() ? " " : deviceDetails.getDeviceToken())
                .withDeviceType(deviceDetails.getDeviceType().isEmpty() ? "iPhone" : deviceDetails.getDeviceType())
                .withStatus(deviceDetails.getStatus().isEmpty() ? "active" : deviceDetails.getStatus())
                .withIsMaster(deviceDetails.getMaster() == null ? false : deviceDetails.getMaster())
                .withAllowsVOIP(deviceDetails.getAllowsVOIP().isEmpty() ? "false" : deviceDetails.getAllowsVOIP())
                .withCarrierName(deviceDetails.getCarrierName().isEmpty() ? " ": deviceDetails.getCarrierName())
                .withIsoCountryCode(deviceDetails.getIsoCountryCode().isEmpty() ? " ":deviceDetails.getIsoCountryCode())
                .withMobileCountryCode(deviceDetails.getMobileCountryCode().isEmpty() ? " ": deviceDetails.getMobileCountryCode())
                .withMobileNetworkCode(deviceDetails.getMobileNetworkCode().isEmpty() ? " ": deviceDetails.getMobileNetworkCode())
                .withPhysicalDeviceID(deviceDetails.getPhysicalDeviceID().isEmpty() ? " ": deviceDetails.getPhysicalDeviceID())
                .build();

        return deviceRepository.save(details);
    }

    /**
     * 
     * @param aid 
     * @param deviceDetails 
     */
    private DeviceDetails updateDevice(String aid, DeviceDetails deviceDetails) {

        DeviceDetails details = deviceRepository.findDeviceDetailsByAid(deviceDetails.getAid());
        if (details != null ) {
            this.deviceRepository.delete(details);
        }
        return this.captureDeviceDetails(deviceDetails);
    }



    /**
     * 
     * @param request 
     * @param deviceDetails 
     * @param size 
     */
    private NotificationDetails saveNotification(NotificationRequest request, DeviceDetails deviceDetails, int size) {

        NotificationDetails details = new NotificationDetails();
        details.setAid(deviceDetails.getAid());
        details.setCustomerID(deviceDetails.getCustomerId());
        if (request.isHasExpiration()) {
            details.setExpiration(request.getExpiration());
        } else {
            details.setExpiration(-1L);
        }

        if (request.getCustomParams() != null) {
            details.setCustomParams(request.getCustomParams());
        } else {
            details.setCustomParams(new HashMap<>());
        }
        if (request.getNotificationParams() != null) {
            details.setNotificationParams(request.getNotificationParams());
        } else {
            details.setNotificationParams(new HashMap<>());
        }
        details.setAlertTitle(request.getAlertTitle());
        details.setCategory(request.getCategory());
        details.setContentAvailable(false);
        details.setInAppNotification(request.isInAppNotification());
        details.setInAppPriority(inAppNotificationPriorityRepository.findInAppNotificationPriorityByCategoryEquals(request.getCategory()).getPriority());
        details.setPushPriority(NotificationRequest.Priority.IMMEDIATE.name());
        details.setTopic(deviceDetails.getDeviceBundleIdentifier());
        details.setSilent(request.isSilent());
        details.setPushNotification(request.isPushNotification());
        details.setSize(size > 0 ? size : 0);
        details.setAlertBody(request.getAlertBody());
        details.setNotificationSentDate(LocalDate.now());
        details.setStatus("active");
        details.setSystemId(request.getSystemId());
        details.setSystemDate(new Date().toString());
        details.setMutableContent(request.isMutableContent());

        return this.notificationRepository.save(details);
    }

    /**
     * Clear tokens.
     */
    @Scheduled(fixedRate = 100000L)
    public void clearTokens() {
        this.deviceRepository.findDeviceDetailsByStatus("Unregistered")
                .forEach(deviceDetails -> this.deviceRepository.delete(deviceDetails));

        System.out.println("Device Records Unregistered were deleted");
    }

    /**
     * Clear expired notifications.
     */
    @Scheduled(fixedRate = 100000L)
    public void clearExpiredNotifications() {
        this.notificationRepository.findNotificationByStatusEquals("expired")
                .forEach(notification -> this.notificationRepository.delete(notification));

        System.out.println("Notification Records expired were deleted");
    }

    /**
     * Sets notifications as expired.
     */
    @Scheduled(fixedRate = 100000L)
    public void setNotificationsAsExpired() {
        this.notificationRepository.findNotificationDetailsByExpirationEquals(System.currentTimeMillis())
                .forEach(notification -> {
                    notification.setStatus("expired");
                    this.notificationRepository.save(notification);
                });

        System.out.println("Notification Records Updated to Expired");
    }

}

