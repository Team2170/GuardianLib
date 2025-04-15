/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Logging;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.littletonrobotics.junction.Logger;

public class Alert {
    /** Represents an alert's level of urgency. */
    public enum AlertType {
        /** High priority alert for serious issues requiring immediate attention (red "X"). */
        ERROR,
        /** High priority alert with trace information (red "X"). */
        ERROR_TRACE,
        /** Medium priority alert for warnings (yellow "!"). */
        WARNING,
        /** Medium priority alert with trace information (yellow "!"). */
        WARNING_TRACE,
        /** Low priority alert for informational messages (green "i"). */
        INFO
    }

    /** Map of alert groups to their corresponding `SendableAlerts` instance. */
    private static Map<String, SendableAlerts> groups = new HashMap<>();

    /** The type or urgency level of the alert. */
    private AlertType type;

    /** Indicates whether the alert is currently active. */
    private boolean active = false;

    /** The timestamp when the alert was activated. */
    private double activeStartTime = 0.0;

    /** The message text of the alert. */
    private String text;

    /**
     * Creates a new alert in the default group "Alerts". If this is the first alert in the group,
     * its entries will be added to NetworkTables.
     *
     * @param text The message text of the alert.
     * @param type The urgency level of the alert.
     */
    public Alert(String text, AlertType type) {
        this("Alerts", text, type);
    }

    /**
     * Creates a new alert in the specified group. If this is the first alert in the group, its
     * entries will be added to NetworkTables.
     *
     * @param group The group identifier for the alert, also used as the NetworkTables title.
     * @param text The message text of the alert.
     * @param type The urgency level of the alert.
     */
    @SuppressWarnings("java:S3824")
    public Alert(String group, String text, AlertType type) {
        if (!groups.containsKey(group)) {
            groups.put(group, new SendableAlerts());
            SmartDashboard.putData(group, groups.get(group));
        }

        this.text = text;
        this.type = type;
        groups.get(group).alerts.add(this);
    }

    /**
     * Activates or deactivates the alert. If activated, the alert text is also sent to the console.
     *
     * @param active True to activate the alert, false to deactivate it.
     */
    public void set(boolean active) {
        if (active && !this.active) {
            activeStartTime = Timer.getFPGATimestamp();
            printAlert(text);
        }
        this.active = active;
    }

    /**
     * Updates the text of the alert.
     *
     * @param text The new text for the alert.
     */
    public void setText(String text) {
        if (active && !text.equals(this.text)) {
            printAlert(text);
        }
        this.text = text;
    }

    /**
     * Updates the urgency level of the alert.
     *
     * @param level The new urgency level for the alert.
     */
    public void setLevel(AlertType level) {
        this.type = level;
    }

    /**
     * Prints the alert message to the console or DriverStation log based on its urgency level.
     *
     * @param text The message text to print.
     */
    private void printAlert(String text) {
        switch (type) {
            case ERROR:
                DriverStation.reportError(text, false);
                break;
            case ERROR_TRACE:
                DriverStation.reportError(text, true);
                break;
            case WARNING:
                DriverStation.reportWarning(text, false);
                break;
            case WARNING_TRACE:
                DriverStation.reportWarning(text, true);
                break;
            case INFO:
                DriverStation.reportWarning(text, false);
                break;
        }
    }

    /**
     * Logs metadata for the alert using the Logger.
     *
     * @param name The name of the metadata entry.
     */
    public void logAlert(String name) {
        Logger.recordMetadata(name, text);
    }

    /**
     * Retrieves the timestamp when the alert was activated.
     *
     * @return The activation timestamp.
     */
    public double getActivationTimestamp() {
        return activeStartTime;
    }

    /** A helper class for managing alerts in a group as a Sendable object. */
    private static class SendableAlerts implements Sendable {
        /** List of alerts in this group. */
        public final List<Alert> alerts = new ArrayList<>();

        /**
         * Retrieves the active alert strings for a given alert type.
         *
         * @param type The alert type to filter.
         * @return An array of active alert strings.
         */
        @SuppressWarnings("java:S4165")
        public String[] getStrings(AlertType type) {
            List<String> alertStrings = new ArrayList<>();

            for (Alert alert : alerts) {
                alertStrings = getStrings(type, alert, alertStrings);
            }

            return alertStrings.toArray(new String[0]);
        }

        /**
         * Adds the text of active alerts of the specified type to the list.
         *
         * @param type The alert type to check.
         * @param alert The alert to evaluate.
         * @param alertStrings The list of alert strings.
         * @return The updated list of alert strings.
         */
        private List<String> getStrings(AlertType type, Alert alert, List<String> alertStrings) {
            if (alert.type == type && alert.active) {
                alertStrings.add(alert.text);
            }
            return alertStrings;
        }

        /**
         * Initializes the sendable properties for displaying alerts on the SmartDashboard. This
         * method defines string array properties corresponding to different alert types (errors,
         * warnings, and informational messages).
         *
         * @param builder The {@link SendableBuilder} used to define the properties for this
         *     sendable.
         */
        @Override
        public void initSendable(SendableBuilder builder) {
            // Set the SmartDashboard type to "Alerts"
            builder.setSmartDashboardType("Alerts");

            // Add a property for error alerts
            builder.addStringArrayProperty("errors", () -> getStrings(AlertType.ERROR), null);

            // Add a property for error alerts with trace information
            builder.addStringArrayProperty("errors", () -> getStrings(AlertType.ERROR_TRACE), null);

            // Add a property for warning alerts
            builder.addStringArrayProperty("warnings", () -> getStrings(AlertType.WARNING), null);

            // Add a property for warning alerts with trace information
            builder.addStringArrayProperty(
                    "warnings", () -> getStrings(AlertType.WARNING_TRACE), null);

            // Add a property for informational alerts
            builder.addStringArrayProperty("infos", () -> getStrings(AlertType.INFO), null);
        }
    }
}
