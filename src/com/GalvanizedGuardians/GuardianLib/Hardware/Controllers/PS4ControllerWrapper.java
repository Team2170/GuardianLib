/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.Controllers;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * A wrapper class for the PS4 controller that implements the {@link ControllerWrapper} interface.
 * This class provides standardized access to joystick axes and button triggers for the PS4
 * controller.
 */
@SuppressWarnings("java:S116")
public class PS4ControllerWrapper extends CommandPS4Controller implements ControllerWrapper {
    /** Axis index for forward/backward LeftY. */
    public final int LeftYAxis = PS4Controller.Axis.kLeftY.value;

    /** Axis index for side-to-side strafing. */
    public final int LeftXAxis = PS4Controller.Axis.kLeftX.value;

    /** Axis index for RightX control. */
    public final int RightXAxis = PS4Controller.Axis.kRightX.value;

    /** Axis index for RightY control. */
    public final int RightYAxis = PS4Controller.Axis.kRightY.value;

    /**
     * Constructs a PS4 controller wrapper for the specified port. The wrapper includes access to
     * left and right joysticks, POV controls, and button mappings (Triangle, Circle, Cross, Square).
     *
     * @param port the port the PS4 controller is connected to.
     */
    public PS4ControllerWrapper(int port) {
        super(port);
    }

    /**
     * Gets the axis value for LeftY (forward/backward) control.
     *
     * @return the axis value for LeftY control.
     */
    @Override
    public double getLeftYAxis() {
        return super.getRawAxis(LeftYAxis);
    }

    /**
     * Gets the axis value for strafing (side-to-side) control.
     *
     * @return the axis value for strafing control.
     */
    @Override
    public double getLeftXAxis() {
        return super.getRawAxis(LeftXAxis);
    }

    /**
     * Gets the axis value for RightX control.
     *
     * @return the axis value for RightX control.
     */
    @Override
    public double getRightXAxis() {
        return super.getRawAxis(RightXAxis);
    }

    /**
     * Gets the axis value for RightY control.
     *
     * @return the axis value for RightY control.
     */
    @Override
    public double getRightYAxis() {
        return super.getRawAxis(RightYAxis);
    }

    /**
     * Gets the trigger for the L2 trigger button.
     *
     * @return a {@link Trigger} object for the left trigger button.
     */
    @Override
    public Trigger getLeftTrigger() {
        return super.L2();
    }

    /**
     * Gets the trigger for the R2 trigger button.
     *
     * @return a {@link Trigger} object for the right trigger button.
     */
    @Override
    public Trigger getRightTrigger() {
        return super.R2();
    }

    /**
     * Gets the trigger for the L1 bumper button.
     *
     * @return a {@link Trigger} object for the left bumper button.
     */
    @Override
    public Trigger getLeftBumper() {
        return super.L1();
    }

    /**
     * Gets the trigger for the R1 bumper button.
     *
     * @return a {@link Trigger} object for the right bumper button.
     */
    @Override
    public Trigger getRightBumper() {
        return super.R1();
    }

    /**
     * Gets the trigger for the Triangle button.
     *
     * @return a {@link Trigger} object for the Triangle button.
     */
    @Override
    public Trigger getYorTriangle() {
        return super.triangle();
    }

    /**
     * Gets the trigger for the Circle button.
     *
     * @return a {@link Trigger} object for the Circle button.
     */
    @Override
    public Trigger getBorCircle() {
        return super.circle();
    }

    /**
     * Gets the trigger for the Cross button.
     *
     * @return a {@link Trigger} object for the Cross button.
     */
    @Override
    public Trigger getAorCross() {
        return super.cross();
    }

    /**
     * Gets the trigger for the Square button.
     *
     * @return a {@link Trigger} object for the Square button.
     */
    @Override
    public Trigger getXorSquare() {
        return super.square();
    }

    /**
     * Gets the trigger for the D-Pad up direction.
     *
     * @return a {@link Trigger} object for the D-Pad up direction.
     */
    @Override
    public Trigger getDPadTriggerUp() {
        return super.povUp();
    }

    /**
     * Gets the trigger for the D-Pad down direction.
     *
     * @return a {@link Trigger} object for the D-Pad down direction.
     */
    @Override
    public Trigger getDPadTriggerDown() {
        return super.povDown();
    }

    /**
     * Gets the trigger for the D-Pad left direction.
     *
     * @return a {@link Trigger} object for the D-Pad left direction.
     */
    @Override
    public Trigger getDPadTriggerLeft() {
        return super.povLeft();
    }

    /**
     * Gets the trigger for the D-Pad right direction.
     *
     * @return a {@link Trigger} object for the D-Pad right direction.
     */
    @Override
    public Trigger getDPadTriggerRight() {
        return super.povRight();
    }
}
