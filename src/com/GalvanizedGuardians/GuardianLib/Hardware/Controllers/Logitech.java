/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.Controllers;

import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * Wrapper class for the Logitech controller using WPILib's CommandJoystick. This class provides
 * mappings for the controller's axes, buttons, and D-Pad.
 */
@SuppressWarnings("java:S115")
public class Logitech implements ControllerWrapper {
    private CommandJoystick logitechJoystick;

    /** Axis index for forward/backward LeftY. */
    public static final int leftYAxis = 0;

    /** Axis index for side-to-side strafing. */
    public static final int leftXAxis = 1;

    /** Axis index for RightX. */
    public static final int rightXAxis = 2;

    /**
     * Constructs a Logitech controller wrapper with mappings for joystick axes and buttons.
     *
     * @param port the port the controller is connected to.
     */
    public Logitech(int port) {
        logitechJoystick = new CommandJoystick(port);
    }

    /**
     * Gets the axis value for LeftY (forward/backward) control.
     *
     * @return the axis value for LeftY control.
     */
    @Override
    public double getLeftYAxis() {
        return logitechJoystick.getRawAxis(leftYAxis);
    }

    /**
     * Gets the axis value for strafing (side-to-side) control.
     *
     * @return the axis value for strafing control.
     */
    @Override
    public double getLeftXAxis() {
        return logitechJoystick.getRawAxis(leftXAxis);
    }

    /**
     * Gets the axis value for RightX control.
     *
     * @return the axis value for RightX control.
     */
    @Override
    public double getRightXAxis() {
        return logitechJoystick.getRawAxis(rightXAxis);
    }

    /**
     * Gets a placeholder trigger for the left trigger. This is a non-functional placeholder.
     *
     * @return a Trigger object for the left trigger.
     */
    @Override
    public Trigger getLeftTrigger() {
        return new Trigger(() -> false);
    }

    /**
     * Gets a placeholder trigger for the right trigger. This is a non-functional placeholder.
     *
     * @return a Trigger object for the right trigger.
     */
    @Override
    public Trigger getRightTrigger() {
        return new Trigger(() -> false);
    }

    /**
     * Gets the trigger for the left bumper (button 5).
     *
     * @return a Trigger object for the left bumper.
     */
    @Override
    public Trigger getLeftBumper() {
        return logitechJoystick.button(5);
    }

    /**
     * Gets the trigger for the right bumper (button 6).
     *
     * @return a Trigger object for the right bumper.
     */
    @Override
    public Trigger getRightBumper() {
        return logitechJoystick.button(6);
    }

    /**
     * Gets the trigger for the Y or Triangle button (button 4).
     *
     * @return a Trigger object for the Y or Triangle button.
     */
    @Override
    public Trigger getYorTriangle() {
        return logitechJoystick.button(4);
    }

    /**
     * Gets the trigger for the B or Circle button (button 3).
     *
     * @return a Trigger object for the B or Circle button.
     */
    @Override
    public Trigger getBorCircle() {
        return logitechJoystick.button(3);
    }

    /**
     * Gets the trigger for the A or Cross button (button 2).
     *
     * @return a Trigger object for the A or Cross button.
     */
    @Override
    public Trigger getAorCross() {
        return logitechJoystick.button(2);
    }

    /**
     * Gets the trigger for the X or Square button (button 1).
     *
     * @return a Trigger object for the X or Square button.
     */
    @Override
    public Trigger getXorSquare() {
        return logitechJoystick.button(1);
    }

    /**
     * Gets the trigger for the D-Pad up direction.
     *
     * @return a Trigger object for the D-Pad up direction.
     */
    @Override
    public Trigger getDPadTriggerUp() {
        return logitechJoystick.povUp();
    }

    /**
     * Gets the trigger for the D-Pad down direction.
     *
     * @return a Trigger object for the D-Pad down direction.
     */
    @Override
    public Trigger getDPadTriggerDown() {
        return logitechJoystick.povDown();
    }

    /**
     * Gets the trigger for the D-Pad left direction.
     *
     * @return a Trigger object for the D-Pad left direction.
     */
    @Override
    public Trigger getDPadTriggerLeft() {
        return logitechJoystick.povLeft();
    }

    /**
     * Gets the trigger for the D-Pad right direction.
     *
     * @return a Trigger object for the D-Pad right direction.
     */
    @Override
    public Trigger getDPadTriggerRight() {
        return logitechJoystick.povRight();
    }

    @Override
    public Trigger getTopButton() {
        return new Trigger(() -> false);
    }
}
