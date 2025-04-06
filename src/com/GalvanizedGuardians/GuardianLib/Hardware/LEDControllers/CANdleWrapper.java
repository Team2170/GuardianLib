/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers;

import edu.wpi.first.wpilibj.Timer;

import com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.Utility.CANDeviceDetails;
import com.GalvanizedGuardians.GuardianLib.Logging.Alert;
import com.GalvanizedGuardians.GuardianLib.Logging.Alert.AlertType;
import com.GalvanizedGuardians.GuardianLib.Logging.Faults.CANdleFaultsWrapper;
import com.ctre.phoenix.led.CANdle;

public class CANdleWrapper implements LEDControllerIO {
    private boolean isEnabled = false;

    private CANdle leds;
    private int ledCount;
    private CANdleState state = CANdleState.OFF;
    private CANdleFaultsWrapper faults;
    private CANDeviceDetails details;

    private Alert sensorAlert;

    private Timer timer = new Timer();
    private double seconds = 1;
    private double defaultTime = 1;

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

    public CANdleWrapper(CANDeviceDetails details, int ledCount, String CANbus) {
        this.details = details;
        int id = details.getDeviceNumber();
        this.ledCount = ledCount;

        try {
            leds = new CANdle(id, CANbus);
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
}
