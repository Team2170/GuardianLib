/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.Controllers;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface ControllerWrapper {
    /**
     * Gets the axis value for LeftY (forward/backward) control.
     *
     * @return The axis value for LeftY control.
     */
    public default double getLeftYAxis() {
        return 0;
    }

    /**
     * Gets the axis value for strafing (side-to-side) control.
     *
     * @return The axis value for strafing control.
     */
    public default double getLeftXAxis() {
        return 0;
    }

    /**
     * Gets the axis value for RightX control.
     *
     * @return The axis value for RightX control.
     */
    public default double getRightXAxis() {
        return 0;
    }
    /**
     * Gets the axis value for RightY control.
     *
     * @return The axis value for RightY control.
     */
    public default double getRightYAxis() {
        return 0;
    }

    /**
     * Get Left Trigger
     *
     * @return Trigger
     */
    public default Trigger getLeftTrigger() {
        return null;
    }
    /**
     * Get Right Trigger
     *
     * @return Trigger
     */
    public default Trigger getRightTrigger() {
        return null;
    }
    /**
     * Get Left Bumper
     *
     * @return Trigger
     */
    public default Trigger getLeftBumper() {
        return null;
    }
    /**
     * Get RightBumper
     *
     * @return Trigger
     */
    public default Trigger getRightBumper() {
        return null;
    }
    /**
     * Get YorTriangle
     *
     * @return Trigger
     */
    public default Trigger getYorTriangle() {
        return null;
    }
    /**
     * getBorCircle
     *
     * @return Trigger
     */
    public default Trigger getBorCircle() {
        return null;
    }

    /**
     * Get A Or Cross
     *
     * @return Trigger
     */
    public default Trigger getAorCross() {
        return null;
    }
    /**
     * getXorSquare
     *
     * @return Trigger
     */
    public default Trigger getXorSquare() {
        return null;
    }
    /**
     * getDPadTriggerUp
     *
     * @return Trigger
     */
    public default Trigger getDPadTriggerUp() {
        return null;
    }
    /**
     * getDPadTriggerDown
     *
     * @return Trigger
     */
    public default Trigger getDPadTriggerDown() {
        return null;
    }
    /**
     * getDPadTriggerLeft
     *
     * @return Trigger
     */
    public default Trigger getDPadTriggerLeft() {
        return null;
    }
    /**
     * getDPadTriggerRight
     *
     * @return Trigger
     */
    public default Trigger getDPadTriggerRight() {
        return null;
    }

    public default Trigger getTopButton() {
        return null;
    }
}
