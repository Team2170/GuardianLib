/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.Controllers;

import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * Wrapper class for the EightBitDo controller using WPILib's CommandJoystick.
 * This class provides
 * mappings for the controller's axes, buttons, and D-Pad.
 */
@SuppressWarnings("java:S115")
public class EightBitDo implements ControllerWrapper {
    private CommandJoystick ebdJoystick;

    /** Axis index for forward/backward LeftY. */
    public static final int leftYAxis = 0;

    /** Axis index for side-to-side strafing. */
    public static final int leftXAxis = 1;

    /** Axis index for RightX. */
    public static final int rightXAxis = 4;

    /**
     * Constructs an EightBitDo controller wrapper with mappings for joystick axes
     * and buttons.
     *
     * @param port the port the controller is connected to.
     */
    public EightBitDo(int port) {
        ebdJoystick = new CommandJoystick(port);
    }

    /**
     * Gets the axis value for LeftY (forward/backward) control.
     *
     * @return the axis value for LeftY control.
     */
    @Override
    public double getLeftYAxis() {
        return ebdJoystick.getRawAxis(leftYAxis);
    }

    /**
     * Gets the axis value for strafing (side-to-side) control.
     *
     * @return the axis value for strafing control.
     */
    @Override
    public double getLeftXAxis() {
        return ebdJoystick.getRawAxis(leftXAxis);
    }

    /**
     * Gets the axis value for RightX control.
     *
     * @return the axis value for RightX control.
     */
    @Override
    public double getRightXAxis() {
        return ebdJoystick.getRawAxis(rightXAxis);
    }

    /**
     * Gets the trigger for the left button (button 9).
     *
     * @return a Trigger object for the left button.
     */
    @Override
    public Trigger getLeftTrigger() {
        return ebdJoystick.button(9);
    }

    /**
     * Gets the trigger for the right button (button 10).
     *
     * @return a Trigger object for the right button.
     */
    @Override
    public Trigger getRightTrigger() {
        return ebdJoystick.button(10);
    }

    /**
     * Gets the trigger for the left bumper (button 5).
     *
     * @return a Trigger object for the left bumper.
     */
    @Override
    public Trigger getLeftBumper() {
        return ebdJoystick.button(5);
    }

    /**
     * Gets the trigger for the right bumper (button 6).
     *
     * @return a Trigger object for the right bumper.
     */
    @Override
    public Trigger getRightBumper() {
        return ebdJoystick.button(6);
    }

    /**
     * Gets the trigger for the Y or Triangle button (button 3).
     *
     * @return a Trigger object for the Y or Triangle button.
     */
    @Override
    public Trigger getYorTriangle() {
        return ebdJoystick.button(3);
    }

    /**
     * Gets the trigger for the B or Circle button (button 1).
     *
     * @return a Trigger object for the B or Circle button.
     */
    @Override
    public Trigger getBorCircle() {
        return ebdJoystick.button(1);
    }

    /**
     * Gets the trigger for the A or Cross button (button 2).
     *
     * @return a Trigger object for the A or Cross button.
     */
    @Override
    public Trigger getAorCross() {
        return ebdJoystick.button(2);
    }

    /**
     * Gets the trigger for the X or Square button (button 4).
     *
     * @return a Trigger object for the X or Square button.
     */
    @Override
    public Trigger getXorSquare() {
        return ebdJoystick.button(4);
    }

    /**
     * Gets the trigger for the D-Pad up direction.
     *
     * @return a Trigger object for the D-Pad up direction.
     */
    @Override
    public Trigger getDPadTriggerUp() {
        return ebdJoystick.povUp();
    }

    /**
     * Gets the trigger for the D-Pad down direction.
     *
     * @return a Trigger object for the D-Pad down direction.
     */
    @Override
    public Trigger getDPadTriggerDown() {
        return ebdJoystick.povDown();
    }

    /**
     * Gets the trigger for the D-Pad left direction.
     *
     * @return a Trigger object for the D-Pad left direction.
     */
    @Override
    public Trigger getDPadTriggerLeft() {
        return ebdJoystick.povLeft();
    }

    /**
     * Gets the trigger for the D-Pad right direction.
     *
     * @return a Trigger object for the D-Pad right direction.
     */
    @Override
    public Trigger getDPadTriggerRight() {
        return ebdJoystick.povRight();
    }

    @Override
    public Trigger getTopButton() {
        return new Trigger(() -> false);
    }
}