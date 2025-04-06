/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Logging.Faults;

import com.GalvanizedGuardians.GuardianLib.Logging.Alert;
import com.GalvanizedGuardians.GuardianLib.Logging.Alert.AlertType;
import com.ctre.phoenix.led.CANdle;

/**
 * Wrapper class for monitoring and handling faults in a CANdle device. Provides functionality to
 * check for faults and activate or deactivate corresponding alerts.
 */
public class CANdleFaultsWrapper implements FaultsWrapper {
    /** ID of the CANdle device. */
    public int id;

    /** CANdle hardware instance being monitored for faults. */
    public CANdle leds;

    /** Alert for hardware faults. */
    public static Alert hardwareAlert;

    /** Alert for under-voltage faults. */
    public static Alert underVoltagedAlert;

    /** Alert for over-voltage faults. */
    public static Alert overVoltagedAlert;

    /**
     * Constructor for initializing the fault manager for a CANdle device.
     *
     * @param leds The CANdle instance to monitor.
     * @param id The ID of the CANdle device.
     */
    public CANdleFaultsWrapper(CANdle leds, int id) {
        this.id = id;
        this.leds = leds;
        AlertType level = AlertType.INFO;

        overVoltagedAlert =
                new Alert("Leds", "CANdle " + id + " is undervoltaged, potential brownout.", level);
        underVoltagedAlert =
                new Alert("Leds", "CANdle " + id + " is undervoltaged, potential brownout.", level);
        hardwareAlert = new Alert("Leds", "CANdle " + id + " has a hardware fault.", level);
    }
}
