/* Copyright (c) 2025 GalvanizedGuardians Robotics. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers;

import com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.Utility.CANDeviceDetails;
import com.GalvanizedGuardians.GuardianLib.Logging.Faults.CANdleFaultsWrapper;

import com.ctre.phoenix.led.CANdle;

public class CANdleWrapper implements LEDControllerIO {
    private CANdle leds;
    private CANdleState currState;
    private CANdleFaultsWrapper faults;
    private CANDeviceDetails details;
    private int ledCount;

    public enum CANdleState {
        OFF,
        TURNING_CW,
        TURNING_CCW,
        RESET_POSE,
        RESET_GYRO,
        ALIGNING,
        ALIGNED
    }

    public enum Animations {
        ColorFlow,
        Fire,
        Larson,
        Rainbow,
        RgbFade,
        SingleFade,
        Strobe,
        Twinkle,
        TwinkleOff,
        SetAll,
        Empty
    }

    public class CANdleIOInputs {
        public CANdleState state = CANdleState.OFF;
    }

    public CANdleWrapper(CANDeviceDetails details, int ledCount, String CANBus) {
        this.details = details;
    }
}
