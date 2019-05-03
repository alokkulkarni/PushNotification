package com.example.apns.PushNotification.util;

import com.example.apns.PushNotification.domain.DeviceDetails;

public final class DeviceDetailsBuilder {
    private String id;
    private String customerId;
    private String aid;
    private String deviceToken = " ";
    private String deviceName;
    private String deviceOS;
    private String deviceBundleIdentifier;
    private String deviceType;
    private String deviceSerialNumber;
    private String deviceIMEINumber = " ";
    private String devicedeploymentTarget;
    private String deviceApplicationVersion;
    private String deviceBuild;
    private String physicalDeviceID = " ";
    private String carrierName = " ";
    private String isoCountryCode = " ";
    private String mobileCountryCode = " ";
    private String mobileNetworkCode = " ";
    private String allowsVOIP = " ";
    private String status = "active";
    private Boolean isMaster = false;

    private DeviceDetailsBuilder() {
    }

    public static DeviceDetailsBuilder aDeviceDetails() {
        return new DeviceDetailsBuilder();
    }

    public DeviceDetailsBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public DeviceDetailsBuilder withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public DeviceDetailsBuilder withAid(String aid) {
        this.aid = aid;
        return this;
    }

    public DeviceDetailsBuilder withDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
        return this;
    }

    public DeviceDetailsBuilder withDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public DeviceDetailsBuilder withDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
        return this;
    }

    public DeviceDetailsBuilder withDeviceBundleIdentifier(String deviceBundleIdentifier) {
        this.deviceBundleIdentifier = deviceBundleIdentifier;
        return this;
    }

    public DeviceDetailsBuilder withDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public DeviceDetailsBuilder withDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
        return this;
    }

    public DeviceDetailsBuilder withDeviceIMEINumber(String deviceIMEINumber) {
        this.deviceIMEINumber = deviceIMEINumber;
        return this;
    }

    public DeviceDetailsBuilder withDevicedeploymentTarget(String devicedeploymentTarget) {
        this.devicedeploymentTarget = devicedeploymentTarget;
        return this;
    }

    public DeviceDetailsBuilder withDeviceApplicationVersion(String deviceApplicationVersion) {
        this.deviceApplicationVersion = deviceApplicationVersion;
        return this;
    }

    public DeviceDetailsBuilder withDeviceBuild(String deviceBuild) {
        this.deviceBuild = deviceBuild;
        return this;
    }

    public DeviceDetailsBuilder withPhysicalDeviceID(String physicalDeviceID) {
        this.physicalDeviceID = physicalDeviceID;
        return this;
    }

    public DeviceDetailsBuilder withCarrierName(String carrierName) {
        this.carrierName = carrierName;
        return this;
    }

    public DeviceDetailsBuilder withIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
        return this;
    }

    public DeviceDetailsBuilder withMobileCountryCode(String mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
        return this;
    }

    public DeviceDetailsBuilder withMobileNetworkCode(String mobileNetworkCode) {
        this.mobileNetworkCode = mobileNetworkCode;
        return this;
    }

    public DeviceDetailsBuilder withAllowsVOIP(String allowsVOIP) {
        this.allowsVOIP = allowsVOIP;
        return this;
    }

    public DeviceDetailsBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public DeviceDetailsBuilder withIsMaster(Boolean isMaster) {
        this.isMaster = isMaster;
        return this;
    }

    public DeviceDetails build() {
        DeviceDetails deviceDetails = new DeviceDetails(customerId, aid, deviceToken, deviceName, deviceOS, deviceBundleIdentifier, deviceType, deviceSerialNumber, deviceIMEINumber, devicedeploymentTarget, deviceApplicationVersion, deviceBuild, physicalDeviceID, carrierName, isoCountryCode, mobileCountryCode, mobileNetworkCode, allowsVOIP, status, isMaster);
        deviceDetails.setId(id);
        return deviceDetails;
    }
}
