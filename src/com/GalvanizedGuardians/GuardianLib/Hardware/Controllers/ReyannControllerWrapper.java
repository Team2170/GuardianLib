/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.Controllers;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public class ReyannControllerWrapper extends CommandReyannController {
    /**
     * Constructs an Reyann controller wrapper for the specified port.
     *
     * @param port the port the Xbox controller is connected to.
     */
    public ReyannControllerWrapper(int port) {
        super(port);
    }

    /**
     * Gets the trigger for the any specified button.
     *
     * @param button The button index, starting from 1.
     * @return A {@link Trigger} object for the specified button's state.
     */
    public Trigger getButtonTrigger(int button) {
        return super.getButtonTrigger(button);
    }
}
