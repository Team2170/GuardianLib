/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Logging.Faults;

import com.GalvanizedGuardians.GuardianLib.Logging.Alert;
import com.GalvanizedGuardians.GuardianLib.Logging.Alert.AlertType;

/**
 * Interface for managing hardware fault alerts. Provides methods to activate, deactivate, and check
 * for faults in the system.
 */
public interface FaultsWrapper {
    /**
     * Activates a specific alert, indicating that a fault condition has been detected.
     *
     * @param alert The alert to activate.
     */
    public default void activateAlert(Alert alert) {}

    /**
     * Activates a specific alert with a defined severity level.
     *
     * @param alert The alert to activate.
     * @param alertType The severity level of the alert.
     */
    public default void activateAlert(Alert alert, AlertType alertType) {}

    /**
     * Deactivates a specific alert, indicating that the fault condition no longer exists.
     *
     * @param alert The alert to deactivate.
     */
    public default void disableAlert(Alert alert) {}

    /**
     * Checks if any fault conditions have been detected.
     *
     * @return {@code true} if at least one fault is detected; otherwise, {@code false}.
     */
    public default boolean hasFaultOccured() {
        return false;
    }

    /**
     * Logs the state and returns the alert state.
     *
     * @param key which represents the advantage scope key that is being written too.
     * @param value from getting if the hardware has an error.
     * @return the logged state.
     */
    public default boolean LogError(String key, boolean value) {
        return false;
    }
}
