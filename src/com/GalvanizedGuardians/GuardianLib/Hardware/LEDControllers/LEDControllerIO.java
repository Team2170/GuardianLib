/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers;

import com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.CANdleWrapper.CANdleState;

public interface LEDControllerIO {
    /**
     * Represents the I/O inputs for the LED controller, including the current state of the LEDs.
     */
    public class LEDControllerIOInputs {
        /** The current state of the LED controller (e.g., OFF, TURNING_CW, etc.). */
        public CANdleState state = CANdleState.OFF;
    }

    public default void updateInputs(LEDControllerIOInputs inputs) {}

    public default void setLEDS(CANdleState state) {}

    public default void setLEDS(CANdleState state, double seconds) {}

    public default void periodic() {}

    public default void checkForFaults() {}
}
