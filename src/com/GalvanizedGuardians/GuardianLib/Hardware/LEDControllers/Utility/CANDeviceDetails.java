/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.Utility;

public class CANDeviceDetails {
    public enum Manufacturer {
        Unknown, // Unknown vendor
        Thrifty, // Thrifty vendor
        Grapple, // Grapple vendor
        Pwf, // Pwf vendor
        Redux, // Redux vendor
        Rev, // Rev vendor
        CTRE // CTRE vendor
    }

    private final Manufacturer manufacturer;
    private final int deviceNumber;
    private final String CANbus;
    private final String subsystemName;

    /**
     * Constructs a CANDeviceDetails object with the specified device number, CANbus name,
     * manufacturer, and subsystem name.
     *
     * @param deviceNumber The unique identifier for the CAN device.
     * @param CANbus The bus name to which the device is connected.
     * @param manufacturer The manufacturer of the CAN device.
     * @param subsystemName The name of the subsystem this device is associated with.
     */
    public CANDeviceDetails(
            int deviceNumber, String CANbus, Manufacturer manufacturer, String subsystemName) {
        this.deviceNumber = deviceNumber;
        this.CANbus = CANbus;
        this.manufacturer = manufacturer;
        this.subsystemName = subsystemName;
    }

    /**
     * Constructs a CANDeviceDetails object with the specified device number, CANbus name, and
     * manufacturer.
     *
     * @param deviceNumber The unique identifier for the CAN device.
     * @param CANbus The bus name to which the device is connected.
     * @param manufacturer The manufacturer of the CAN device.
     */
    public CANDeviceDetails(int deviceNumber, String CANbus, Manufacturer manufacturer) {
        this(deviceNumber, CANbus, manufacturer, "");
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
        this(deviceNumber, Manufacturer.Unknown);
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getDeviceNumber() {
        return deviceNumber;
    }

    public String getCANbus() {
        return CANbus;
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
    public boolean equals(CANDeviceDetails other) {
        return other.deviceNumber == deviceNumber
                && other.CANbus.equals(CANbus)
                && other.manufacturer == manufacturer
                && other.subsystemName.equals(subsystemName);
    }
}
