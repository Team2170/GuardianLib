/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Logging.Faults;

import com.GalvanizedGuardians.GuardianLib.Logging.Alert;
import com.GalvanizedGuardians.GuardianLib.Logging.Alert.AlertType;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleFaults;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import org.littletonrobotics.junction.Logger;

/**
 * Wrapper class for monitoring and handling faults in a CANdle device. Provides functionality to
 * check for faults and activate or deactivate corresponding alerts.
 */
public class CANdleFaultsWrapper implements FaultsWrapper {
    /** ID of the CANdle device. */
    private int id;

    /** CANdle hardware instance being monitored for faults. */
    private CANdle leds;

    /** Alert for hardware faults. */
    private static Alert hardwareAlert;

    /** Alert for under-voltage faults. */
    private static Alert underVoltagedAlert;

    /** Alert for over-voltage faults. */
    private static Alert overVoltagedAlert;

    /**
     * Constructor for initializing the fault manager for a CANdle device.
     *
     * @param leds The CANdle instance to monitor.
     * @param id The ID of the CANdle device.
     */
    @SuppressWarnings({"java:S1192", "java:S125"})
    public CANdleFaultsWrapper(CANdle leds, int id) {
        this.id = id;
        this.leds = leds;
        // AlertType level = AlertType.INFO;

        // overVoltagedAlert = new Alert("Leds", "CANdle " + id + " is undervoltaged, potential
        // brownout.", level);
        // underVoltagedAlert = new Alert("Leds", "CANdle " + id + " is undervoltaged, potential
        // brownout.", level);
        // hardwareAlert = new Alert("Leds", "CANdle " + id + " has a hardware fault.", level);
    }

    /**
     * Activates a specific alert and logs it with a message.
     *
     * @param alert The alert to activate.
     */
    @Override
    public void activateAlert(Alert alert) {
        alert.set(true);
        alert.logAlert("CANdle " + id);
    }

    /**
     * Activates a specific alert and sets its severity level.
     *
     * @param alert The alert to activate.
     * @param type The severity level of the alert.
     */
    @Override
    public void activateAlert(Alert alert, AlertType type) {
        alert.setLevel(type);
        alert.set(true);
    }

    /**
     * Disables a specific alert, indicating that the fault condition no longer exists.
     *
     * @param alert The alert to disable.
     */
    @Override
    public void disableAlert(Alert alert) {
        alert.set(false);
    }

    /**
     * Checks if any faults have occurred in the CANdle device and activates the corresponding
     * alerts.
     *
     * @return True if at least one fault is detected; otherwise, false.
     */
    @Override
    public boolean hasFaultOccured() {
        List<Alert> foundFaults = new ArrayList<>();
        CANdleFaults ledFaults = new CANdleFaults();
        leds.getFaults(ledFaults);

        Map<BooleanSupplier, Alert> faultChecks =
                Map.of(
                        () -> ledFaults.V5TooLow, underVoltagedAlert,
                        () -> ledFaults.V5TooHigh, overVoltagedAlert,
                        () -> ledFaults.HardwareFault, hardwareAlert);

        faultChecks.forEach(
                (faultCondition, alert) -> {
                    if (faultCondition.getAsBoolean()) {
                        foundFaults.add(alert);
                    }
                });

        foundFaults.forEach(this::activateAlert);

        return !foundFaults.isEmpty();
    }

    /**
     * logs the state and returns the alert state.
     *
     * @param key which represents the advantage scope key that is being written too.
     * @param value from getting if the hardware has an error.
     * @return the logged state.
     */
    @Override
    public boolean LogError(String key, boolean value) {
        Logger.recordOutput("Alerts/CANdle/" + id + "/" + key, value);
        return value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CANdle getLeds() {
        return leds;
    }

    public void setLeds(CANdle leds) {
        this.leds = leds;
    }

    public static Alert getHardwareAlert() {
        return hardwareAlert;
    }

    public static void setHardwareAlert(Alert hardwareAlert) {
        CANdleFaultsWrapper.hardwareAlert = hardwareAlert;
    }

    public static Alert getUnderVoltagedAlert() {
        return underVoltagedAlert;
    }

    public static void setUnderVoltagedAlert(Alert underVoltagedAlert) {
        CANdleFaultsWrapper.underVoltagedAlert = underVoltagedAlert;
    }

    public static Alert getOverVoltagedAlert() {
        return overVoltagedAlert;
    }

    public static void setOverVoltagedAlert(Alert overVoltagedAlert) {
        CANdleFaultsWrapper.overVoltagedAlert = overVoltagedAlert;
    }
}
