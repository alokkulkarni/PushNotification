/*
 * Copyright (c) 2018. Alok Kulkarni
 */

package com.example.apns.PushNotification.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * The type Device details.
 */
@Document
public class DeviceDetails {

    @Id
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


    /**
     * Instantiates a new Device details.
     */
    public DeviceDetails() {
    }

    /**
     * Instantiates a new Device details.
     *
     * @param customerId               the customer id
     * @param aid                      the aid
     * @param deviceToken              the device token
     * @param deviceName               the device name
     * @param deviceOS                 the device os
     * @param deviceBundleIdentifier   the device bundle identifier
     * @param deviceType               the device type
     * @param deviceSerialNumber       the device serial number
     * @param deviceIMEINumber         the device imei number
     * @param devicedeploymentTarget   the devicedeployment target
     * @param deviceApplicationVersion the device application version
     * @param deviceBuild              the device build
     * @param physicalDeviceID         the physical device id
     * @param carrierName              the carrier name
     * @param isoCountryCode           the iso country code
     * @param mobileCountryCode        the mobile country code
     * @param mobileNetworkCode        the mobile network code
     * @param allowsVOIP               the allows voip
     * @param status                   the status
     * @param isMaster                 the is master
     */
    public DeviceDetails(String customerId, String aid, String deviceToken, String deviceName, String deviceOS, String deviceBundleIdentifier, String deviceType, String deviceSerialNumber, String deviceIMEINumber, String devicedeploymentTarget, String deviceApplicationVersion, String deviceBuild, String physicalDeviceID, String carrierName, String isoCountryCode, String mobileCountryCode, String mobileNetworkCode, String allowsVOIP, String status, Boolean isMaster) {
        this.customerId = customerId;
        this.aid = aid;
        this.deviceToken = deviceToken;
        this.deviceName = deviceName;
        this.deviceOS = deviceOS;
        this.deviceBundleIdentifier = deviceBundleIdentifier;
        this.deviceType = deviceType;
        this.deviceSerialNumber = deviceSerialNumber;
        this.deviceIMEINumber = deviceIMEINumber;
        this.devicedeploymentTarget = devicedeploymentTarget;
        this.deviceApplicationVersion = deviceApplicationVersion;
        this.deviceBuild = deviceBuild;
        this.physicalDeviceID = physicalDeviceID;
        this.carrierName = carrierName;
        this.isoCountryCode = isoCountryCode;
        this.mobileCountryCode = mobileCountryCode;
        this.mobileNetworkCode = mobileNetworkCode;
        this.allowsVOIP = allowsVOIP;
        this.status = status;
        this.isMaster = isMaster;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets aid.
     *
     * @return the aid
     */
    public String getAid() {
        return aid;
    }

    /**
     * Sets aid.
     *
     * @param aid the aid
     */
    public void setAid(String aid) {
        this.aid = aid;
    }

    /**
     * Gets device token.
     *
     * @return the device token
     */
    public String getDeviceToken() {
        return deviceToken;
    }

    /**
     * Sets device token.
     *
     * @param deviceToken the device token
     */
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    /**
     * Gets device name.
     *
     * @return the device name
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Sets device name.
     *
     * @param deviceName the device name
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * Gets device os.
     *
     * @return the device os
     */
    public String getDeviceOS() {
        return deviceOS;
    }

    /**
     * Sets device os.
     *
     * @param deviceOS the device os
     */
    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    /**
     * Gets device bundle identifier.
     *
     * @return the device bundle identifier
     */
    public String getDeviceBundleIdentifier() {
        return deviceBundleIdentifier;
    }

    /**
     * Sets device bundle identifier.
     *
     * @param deviceBundleIdentifier the device bundle identifier
     */
    public void setDeviceBundleIdentifier(String deviceBundleIdentifier) {
        this.deviceBundleIdentifier = deviceBundleIdentifier;
    }

    /**
     * Gets device type.
     *
     * @return the device type
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * Sets device type.
     *
     * @param deviceType the device type
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Gets device serial number.
     *
     * @return the device serial number
     */
    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    /**
     * Sets device serial number.
     *
     * @param deviceSerialNumber the device serial number
     */
    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    /**
     * Gets device imei number.
     *
     * @return the device imei number
     */
    public String getDeviceIMEINumber() {
        return deviceIMEINumber;
    }

    /**
     * Sets device imei number.
     *
     * @param deviceIMEINumber the device imei number
     */
    public void setDeviceIMEINumber(String deviceIMEINumber) {
        this.deviceIMEINumber = deviceIMEINumber;
    }

    /**
     * Gets devicedeployment target.
     *
     * @return the devicedeployment target
     */
    public String getDevicedeploymentTarget() {
        return devicedeploymentTarget;
    }

    /**
     * Sets devicedeployment target.
     *
     * @param devicedeploymentTarget the devicedeployment target
     */
    public void setDevicedeploymentTarget(String devicedeploymentTarget) {
        this.devicedeploymentTarget = devicedeploymentTarget;
    }

    /**
     * Gets device application version.
     *
     * @return the device application version
     */
    public String getDeviceApplicationVersion() {
        return deviceApplicationVersion;
    }

    /**
     * Sets device application version.
     *
     * @param deviceApplicationVersion the device application version
     */
    public void setDeviceApplicationVersion(String deviceApplicationVersion) {
        this.deviceApplicationVersion = deviceApplicationVersion;
    }

    /**
     * Gets device build.
     *
     * @return the device build
     */
    public String getDeviceBuild() {
        return deviceBuild;
    }

    /**
     * Sets device build.
     *
     * @param deviceBuild the device build
     */
    public void setDeviceBuild(String deviceBuild) {
        this.deviceBuild = deviceBuild;
    }

    /**
     * Gets physical device id.
     *
     * @return the physical device id
     */
    public String getPhysicalDeviceID() {
        return physicalDeviceID;
    }

    /**
     * Sets physical device id.
     *
     * @param physicalDeviceID the physical device id
     */
    public void setPhysicalDeviceID(String physicalDeviceID) {
        this.physicalDeviceID = physicalDeviceID;
    }

    /**
     * Gets carrier name.
     *
     * @return the carrier name
     */
    public String getCarrierName() {
        return carrierName;
    }

    /**
     * Sets carrier name.
     *
     * @param carrierName the carrier name
     */
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    /**
     * Gets iso country code.
     *
     * @return the iso country code
     */
    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    /**
     * Sets iso country code.
     *
     * @param isoCountryCode the iso country code
     */
    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    /**
     * Gets mobile country code.
     *
     * @return the mobile country code
     */
    public String getMobileCountryCode() {
        return mobileCountryCode;
    }

    /**
     * Sets mobile country code.
     *
     * @param mobileCountryCode the mobile country code
     */
    public void setMobileCountryCode(String mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    /**
     * Gets mobile network code.
     *
     * @return the mobile network code
     */
    public String getMobileNetworkCode() {
        return mobileNetworkCode;
    }

    /**
     * Sets mobile network code.
     *
     * @param mobileNetworkCode the mobile network code
     */
    public void setMobileNetworkCode(String mobileNetworkCode) {
        this.mobileNetworkCode = mobileNetworkCode;
    }

    /**
     * Gets allows voip.
     *
     * @return the allows voip
     */
    public String getAllowsVOIP() {
        return allowsVOIP;
    }

    /**
     * Sets allows voip.
     *
     * @param allowsVOIP the allows voip
     */
    public void setAllowsVOIP(String allowsVOIP) {
        this.allowsVOIP = allowsVOIP;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets master.
     *
     * @return the master
     */
    public Boolean getMaster() {
        return isMaster;
    }

    /**
     * Sets master.
     *
     * @param master the master
     */
    public void setMaster(Boolean master) {
        isMaster = master;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceDetails that = (DeviceDetails) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(aid, that.aid) &&
                Objects.equals(deviceToken, that.deviceToken) &&
                Objects.equals(deviceName, that.deviceName) &&
                Objects.equals(deviceOS, that.deviceOS) &&
                Objects.equals(deviceBundleIdentifier, that.deviceBundleIdentifier) &&
                Objects.equals(deviceType, that.deviceType) &&
                Objects.equals(deviceSerialNumber, that.deviceSerialNumber) &&
                Objects.equals(deviceIMEINumber, that.deviceIMEINumber) &&
                Objects.equals(devicedeploymentTarget, that.devicedeploymentTarget) &&
                Objects.equals(deviceApplicationVersion, that.deviceApplicationVersion) &&
                Objects.equals(deviceBuild, that.deviceBuild) &&
                Objects.equals(physicalDeviceID, that.physicalDeviceID) &&
                Objects.equals(carrierName, that.carrierName) &&
                Objects.equals(isoCountryCode, that.isoCountryCode) &&
                Objects.equals(mobileCountryCode, that.mobileCountryCode) &&
                Objects.equals(mobileNetworkCode, that.mobileNetworkCode) &&
                Objects.equals(allowsVOIP, that.allowsVOIP) &&
                Objects.equals(status, that.status) &&
                Objects.equals(isMaster, that.isMaster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, aid, deviceToken, deviceName, deviceOS, deviceBundleIdentifier, deviceType, deviceSerialNumber, deviceIMEINumber, devicedeploymentTarget, deviceApplicationVersion, deviceBuild, physicalDeviceID, carrierName, isoCountryCode, mobileCountryCode, mobileNetworkCode, allowsVOIP, status, isMaster);
    }

    @Override
    public String toString() {
        return "DeviceDetails{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", aid='" + aid + '\'' +
                ", deviceToken='" + deviceToken + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceOS='" + deviceOS + '\'' +
                ", deviceBundleIdentifier='" + deviceBundleIdentifier + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceSerialNumber='" + deviceSerialNumber + '\'' +
                ", deviceIMEINumber='" + deviceIMEINumber + '\'' +
                ", devicedeploymentTarget='" + devicedeploymentTarget + '\'' +
                ", deviceApplicationVersion='" + deviceApplicationVersion + '\'' +
                ", deviceBuild='" + deviceBuild + '\'' +
                ", physicalDeviceID='" + physicalDeviceID + '\'' +
                ", carrierName='" + carrierName + '\'' +
                ", isoCountryCode='" + isoCountryCode + '\'' +
                ", mobileCountryCode='" + mobileCountryCode + '\'' +
                ", mobileNetworkCode='" + mobileNetworkCode + '\'' +
                ", allowsVOIP='" + allowsVOIP + '\'' +
                ", status='" + status + '\'' +
                ", isMaster=" + isMaster +
                '}';
    }
}