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
     * Sets the LED state to the specified CANdle state. This method will not automatically turn off the LEDs; it will persist until explicitly set to a different state. Must instantiate the animation you are using before calling this method via {@link #setStateAnimation(CANdleState,Animation)}
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
     * Sets the LED state to the specified CANdle state and duration. This method allows specifying how long the animation should play.
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
     * Set a custom LED animation for each custom state of the robot. This method will not automatically turn off the LEDs; it will persist until explicitly set to a different state.
     *
     * @param state The custom animation state of the robot
     * @param animation The animation to play for the custom state
     */
    public void setStateAnimation(CANdleState state, Animation animation) {
        CANdleStateAnimations[state.ordinal()] = animation;
    }

    /**
     * Periodically checks the timer and updates the LED state. This method is typically called in the robot's periodic function.
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
     * Checks for any faults that may have occurred in the CANdle hardware. If any faults are detected, they are logged or alerted.
     */
    @Override
    public void checkForFaults() {
        faults.hasFaultOccured();
    }

    /**
     * Tells the user if the LED is enabled or not
     * 
     * @return a boolean of the on/off state of the LED
     */
    public boolean isEnabled() {
        return isEnabled;
    }

    /**
     * sets the LED on/off
     * 
     * @param isEnabled true for on, false for off
     */
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * @return the total amount of LEDS on a strip/wrapper
     */
    public int getLedCount() {
        return ledCount;
    }

    /**
     * @param ledCount sets the # of LEDS per strip on this
     */
    public void setLedCount(int ledCount) {
        this.ledCount = ledCount;
    }

    /**
     * gets the LEDS object
     * 
     * @return the leds (NOT COLOR OR ON/OFF STATE)
     */
    public CANdle getLeds() {
        return leds;
    }

    /**
     * Sets the LEDS object
     * 
     * @param leds what the leds are being set to (NOT COLOR OR ON/OFF STATE)
     */
    @SuppressWarnings("java:S1845")
    public void setLeds(CANdle leds) {
        this.leds = leds;
    }

    /**
     * @return the state of the CANdle
     */
    public CANdleState getState() {
        return state;
    }

    /**
     * @param state sets the state of the CANdle
     */
    public void setState(CANdleState state) {
        this.state = state;
    }

     /**
     * Retrieves the CANdleFaultsWrapper object used to monitor hardware faults.
     * 
     * @return The CANdleFaultsWrapper instance.
     */
    public CANdleFaultsWrapper getFaults() {
        return faults;
    }

     /**
     * Sets the CANdleFaultsWrapper object used to monitor hardware faults.
     * 
     * @param faults The CANdleFaultsWrapper instance to set.
     */
    public void setFaults(CANdleFaultsWrapper faults) {
        this.faults = faults;
    }

    /**
     * Retrieves the CAN device details for this CANdle instance.
     *
     * @return The CANDeviceDetails object.
     */
    public CANDeviceDetails getDetails() {
        return details;
    }

    /**
     * Sets the CAN device details for this CANdle instance.
     * 
     * @param details The CANDeviceDetails to set.
     */
    public void setDetails(CANDeviceDetails details) {
        this.details = details;
    }

    /**
     * Gets the animation array mapped to each CANdleState.
     * 
     * @return An array of animations
     */
    public Animation[] getCANdleStateAnimations() {
        return CANdleStateAnimations;
    }

      /**
     * Sets the animation array mapped to each CANdleState.
     *
     * @param cANdleStateAnimations An array of animations
     */
    public void setCANdleStateAnimations(Animation[] cANdleStateAnimations) {
        CANdleStateAnimations = cANdleStateAnimations;
    }

      /**
     * Retrieves the alert associated with LED hardware detection failure.
     *
     * @return The Alert instance for this CANdle.
     */
    public Alert getSensorAlert() {
        return sensorAlert;
    }

    /**
     * Sets the alert associated with LED hardware detection failure.
     *
     * @param sensorAlert The Alert instance to set.
     */
    public void setSensorAlert(Alert sensorAlert) {
        this.sensorAlert = sensorAlert;
    }

      /**
     * Gets the internal timer used for animation durations.
     *
     * @return The Timer instance.
     */
    public Timer getTimer() {
        return timer;
    }

      /**
     * Sets the internal timer used for animation durations.
     *
     * @param timer The Timer instance to use.
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

     /**
     * Gets the number of seconds an animation is intended to play.
     *
     * @return Duration in seconds.
     */
    public double getSeconds() {
        return seconds;
    }

     /**
     * Sets the number of seconds an animation should play.
     *
     * @param seconds Duration in seconds.
     */
    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

     /**
     * Gets the default time used if no specific duration is set.
     *
     * @return Default animation duration in seconds.
     */
    public double getDefaultTime() {
        return defaultTime;
    }

     /**
     * Sets the default time used for animations if no specific duration is provided.
     *
     * @param defaultTime Duration in seconds.
     */
    public void setDefaultTime(double defaultTime) {
        this.defaultTime = defaultTime;
    }
}
