/* Copyright (c) 2025 GalvanizedGuardians Robotics. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers;

import com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.CANdleWrapper.CANdleState;

import org.littletonrobotics.junction.AutoLog;

public interface LEDControllerIO {
    @AutoLog
    public class LEDControllerIOInputs {
        public CANdleState state = CANdleState.OFF;
    }

    public default void updateInputs(LEDControllerIOInputs inputs) {}

    public default void setLEDS(CANdleState state) {}

    public default void setLEDS(CANdleState state, double seconds) {}

    public default void periodic() {}

    public default void checkForFaults() {}
}
