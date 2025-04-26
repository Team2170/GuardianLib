/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.Controllers;

import edu.wpi.first.wpilibj.event.EventLoop;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** A version of {@link ReyannController} with {@link Trigger} factories for command-based. */
public class CommandReyannController extends CommandGenericHID {
    private final ReyannController m_hid;

    /**
     * Construct an instance of a controller.
     *
     * @param port The port index on the Driver Station that the controller is plugged into.
     */
    public CommandReyannController(int port) {
        super(port);
        m_hid = new ReyannController(port);
    }

    /**
     * Get the underlying GenericHID object.
     *
     * @return the wrapped GenericHID object
     */
    @Override
    public ReyannController getHID() {
        return m_hid;
    }

    /**
     * Constructs a Trigger instance around the specified button's digital signal.
     *
     * @param button The button index, starting from 1
     * @return a Trigger instance representing the specified button's digital signal attached to the
     *     {@link CommandScheduler#getDefaultButtonLoop() default scheduler button loop}.
     * @see #a(EventLoop)
     */
    public Trigger getButtonTrigger(int button) {
        return button(button, CommandScheduler.getInstance().getDefaultButtonLoop());
    }

    /**
     * Constructs a Trigger instance around the specified button's digital signal.
     *
     * @param button The button index, starting from 1
     * @param loop the event loop instance to attach the event to.
     * @return a Trigger instance representing the A button's digital signal attached to the given
     *     loop.
     */
    public Trigger getButtonTrigger(int button, EventLoop loop) {
        return button(button, loop);
    }
}
