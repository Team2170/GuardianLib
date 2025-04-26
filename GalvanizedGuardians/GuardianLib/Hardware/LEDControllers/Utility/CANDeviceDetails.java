/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.Utility;

public class CANDeviceDetails {
    /** Common manufacturers of CAN Devices. */
    public enum Manufacturer {
        THRIFTY, // Thrifty vendor
        GRAPPLE, // Grapple vendor
        PWF, // Pwf vendor
        REDUX, // Redux vendor
        REV, // Rev vendor
        CTRE, // CTRE vendor
        UNKNOWN // Unknown vendor
    }

    private final Manufacturer manufacturer;
    private final int deviceNumber;
    private final String CANBus;
    private final String subsystemName;

    /**
     * Constructs a CANDeviceDetails object with the specified device number, CANBus name,
     * manufacturer, and subsystem name.
     *
     * @param deviceNumber The unique identifier for the CAN device.
     * @param CANBus The bus name to which the device is connected.
     * @param manufacturer The manufacturer of the CAN device.
     * @param subsystemName The name of the subsystem this device is associated with.
     */
    @SuppressWarnings("java:S116")
    public CANDeviceDetails(
            int deviceNumber, String CANBus, Manufacturer manufacturer, String subsystemName) {
        this.deviceNumber = deviceNumber;
        this.CANBus = CANBus;
        this.manufacturer = manufacturer;
        this.subsystemName = subsystemName;
    }

    /**
     * Constructs a CANDeviceDetails object with the specified device number, CANBus name, and
     * manufacturer.
     *
     * @param deviceNumber The unique identifier for the CAN device.
     * @param CANBus The bus name to which the device is connected.
     * @param manufacturer The manufacturer of the CAN device.
     */
    public CANDeviceDetails(int deviceNumber, String CANBus, Manufacturer manufacturer) {
        this(deviceNumber, CANBus, manufacturer, "");
    }

    /**
     * Constructs a CANDeviceDetails object with the specified device number, and manufacturer.
     *
     * @param deviceNumber The unique identifier for the CAN device.
     * @param manufacturer The manufacturer of the CAN device.
     */
    public CANDeviceDetails(int deviceNumber, Manufacturer manufacturer) {
        this(deviceNumber, "", manufacturer);
    }

    /**
     * Constructs a CANDeviceDetails object with the specified device number.
     *
     * @param deviceNumber The unique identifier for the CAN device.
     */
    public CANDeviceDetails(int deviceNumber) {
        this(deviceNumber, Manufacturer.UNKNOWN);
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getDeviceNumber() {
        return deviceNumber;
    }

    public String getCANBus() {
        return CANBus;
    }

    public String getSubsystemName() {
        return subsystemName;
    }

    /**
     * Compares this CANDeviceDetails object with another to determine if they are equal.
     *
     * @param other The other CANDeviceDetails object to compare.
     * @return {@code true} if the device numbers, bus, manufacturer, and subsystem name are all the
     *     same; {@code false} otherwise.
     */
    @SuppressWarnings("java:S1201")
    public boolean equals(CANDeviceDetails other) {
        return other.deviceNumber == deviceNumber
                && other.CANBus.equals(CANBus)
                && other.manufacturer == manufacturer
                && other.subsystemName.equals(subsystemName);
    }
}
