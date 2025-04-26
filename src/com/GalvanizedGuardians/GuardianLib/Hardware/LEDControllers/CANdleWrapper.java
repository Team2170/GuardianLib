/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers;

import edu.wpi.first.wpilibj.Timer;

import com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.Utility.CANDeviceDetails;
import com.GalvanizedGuardians.GuardianLib.Logging.Alert;
import com.GalvanizedGuardians.GuardianLib.Logging.Alert.AlertType;
import com.GalvanizedGuardians.GuardianLib.Logging.Faults.CANdleFaultsWrapper;
import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.CANdle;

@SuppressWarnings("java:S116")
public class CANdleWrapper implements LEDControllerIO {
    private boolean isEnabled = false;

    private int ledCount;
    private CANdle leds;
    private CANdleState state = CANdleState.OFF;
    private CANdleFaultsWrapper faults;
    private CANDeviceDetails details;
    private Animation[] CANdleStateAnimations = new Animation[CANdleState.values().length];

    private Alert sensorAlert;

    private Timer timer = new Timer();
    private double seconds = 1;
    private double defaultTime = 1;

    /** Possible states of the robot */
    public enum CANdleState {
        TURNING_CW,
        TURNING_CCW,
        RESET_POSE,
        RESET_GYRO,
        ALIGNING,
        ALIGNED,
        MOVING_FORWARD,
        MOVING_BACKWARD,
        MOVING_LEFT,
        MOVING_RIGHT,
        OFF
    }

    /** Keeps track of CANdleIOInputs for AdvantageKit */
    @SuppressWarnings("java:S1104")
    public static class CANdleIOInputs {
        public CANdleState state = CANdleState.OFF;
    }

    /**
     * Wrapper class for CTRE's CANdles. Allows for easy usage.
     *
     * @param details See {@link
     *     com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.Utility.CANDeviceDetails
     *     CANDeviceDetails}
     * @param ledCount The number of LEDs being used.
     */
    @SuppressWarnings("java:S117")
    public CANdleWrapper(CANDeviceDetails details, int ledCount) {
        this.details = details;
        int id = details.getDeviceNumber();
        this.ledCount = ledCount;

        try {
            leds = new CANdle(id, details.getCANBus());
            faults = new CANdleFaultsWrapper(leds, id);
            isEnabled = true;
        } catch (Exception e) {
            // Handle exception and set alert for hardware failure
            AlertType level = AlertType.INFO;
            sensorAlert = new Alert("LED", "LEDs " + id + " hardware not found", level);
            sensorAlert.set(true);
        }

        timer.stop();
        timer.reset();
    }

    /**
     * Updates the inputs for the LED controller I/O layer with the current CANdle state.
     *
     * @param inputs The CANdleIOInputs object to update.
     */
    @Override
    public void updateInputs(LEDControllerIOInputs inputs) {
        inputs.state = state;
    }

    /**
     * Sets the LED state to the specified CANdle state. This method will not automatically turn off
     * the LEDs; it will persist until explicitly set to a different state. Must instantiate the
     * animation you are using before calling this method via {@link #setStateAnimation(CANdleState,
     * Animation)}
     *
     * @param state The custom animation state to set on the LEDs.
     */
    @Override
    public void setLEDs(CANdleState state) {
        timer.stop();
        timer.reset();

        if (!isEnabled) {
            return;
        }

        // Core animation logic
        if (this.state != state) {
            leds.animate(null); // Wipe old state when setting new one
        }

        this.state = state;

        leds.animate(CANdleStateAnimations[state.ordinal()]);
    }

    /**
     * Sets the LED state to the specified CANdle state and duration. This method allows specifying
     * how long the animation should play.
     *
     * @param state The animation state to set on the LEDs.
     * @param seconds The duration in seconds for the animation.
     */
    @Override
    public void setLEDs(CANdleState state, double seconds) {
        setLEDs(state);
        this.seconds = seconds;
        timer.reset();
        timer.start();
    }

    /**
     * Set a custom LED animation for each custom state of the robot. This method will not
     * automatically turn off the LEDs; it will persist until explicitly set to a different state.
     *
     * @param state The custom animation state of the robot
     * @param animation The animation to play for the custom state
     */
    public void setStateAnimation(CANdleState state, Animation animation) {
        CANdleStateAnimations[state.ordinal()] = animation;
    }

    /**
     * Periodically checks the timer and updates the LED state. This method is typically called in
     * the robot's periodic function.
     */
    @Override
    public void periodic() {
        if (timer.hasElapsed(seconds) && isEnabled) {
            setLEDs(CANdleState.OFF);
            timer.stop();
            timer.reset();
            seconds = defaultTime;
        }
    }

    /**
     * Checks for any faults that may have occurred in the CANdle hardware. If any faults are
     * detected, they are logged or alerted.
     */
    @Override
    public void checkForFaults() {
        faults.hasFaultOccured();
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public int getLedCount() {
        return ledCount;
    }

    public void setLedCount(int ledCount) {
        this.ledCount = ledCount;
    }

    public CANdle getLeds() {
        return leds;
    }

    @SuppressWarnings("java:S1845")
    public void setLeds(CANdle leds) {
        this.leds = leds;
    }

    public CANdleState getState() {
        return state;
    }

    public void setState(CANdleState state) {
        this.state = state;
    }

    public CANdleFaultsWrapper getFaults() {
        return faults;
    }

    public void setFaults(CANdleFaultsWrapper faults) {
        this.faults = faults;
    }

    public CANDeviceDetails getDetails() {
        return details;
    }

    public void setDetails(CANDeviceDetails details) {
        this.details = details;
    }

    public Animation[] getCANdleStateAnimations() {
        return CANdleStateAnimations;
    }

    public void setCANdleStateAnimations(Animation[] cANdleStateAnimations) {
        CANdleStateAnimations = cANdleStateAnimations;
    }

    public Alert getSensorAlert() {
        return sensorAlert;
    }

    public void setSensorAlert(Alert sensorAlert) {
        this.sensorAlert = sensorAlert;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public double getSeconds() {
        return seconds;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getDefaultTime() {
        return defaultTime;
    }

    public void setDefaultTime(double defaultTime) {
        this.defaultTime = defaultTime;
    }
}
