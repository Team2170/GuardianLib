/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.Controllers;

import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.event.BooleanEvent;
import edu.wpi.first.wpilibj.event.EventLoop;

@SuppressWarnings({"java:S115", "java:S100"})
public class ReyannController extends GenericHID implements Sendable {
    /** Represents a digital button on a Reyann Controller. */
    public enum Button {
        /** 1st Button. */
        k1(1),
        /** 2nd Button. */
        k2(2),
        /** 3rd button. */
        k3(3),
        /** 4th button. */
        k4(4),
        /** 5rd button. */
        k5(6),
        /** 6rd button. */
        k6(6),
        /** 7rd button. */
        k7(7),
        /** 8rd button. */
        k8(8),
        /** 9rd button. */
        k9(9),
        /** 10rd button. */
        k10(10),
        /** 11rd button. */
        k11(11),
        /** 12rd button. */
        k12(12);

        /** Button value. */
        public final int value;

        Button(int value) {
            this.value = value;
        }

        /**
         * Get the human-friendly name of the button, matching the relevant methods. This is done by
         * stripping the leading `k`, and appending `Button`.
         *
         * <p>Primarily used for automated unit tests.
         *
         * @return the human-friendly name of the button.
         */
        @Override
        public String toString() {
            // Remove leading `k`
            return this.name().substring(1) + " Button";
        }
    }

    /**
     * Construct an instance of a controller.
     *
     * @param port The port index on the Driver Station that the controller is plugged into (0-5).
     */
    public ReyannController(final int port) {
        super(port);
        HAL.report(tResourceType.kResourceType_Button, port + 1);
    }

    /**
     * Reads the value of the specified button on the controller.
     *
     * @param button The button number to be read, starting at 1.
     * @return {@code true} if the specified button has been pressed, {@code false} otherwise.
     */
    public boolean getButton(int button) {
        switch (button) {
            case 1:
                return getRawButton(Button.k1.value);
            case 2:
                return getRawButton(Button.k2.value);
            case 3:
                return getRawButton(Button.k3.value);
            case 4:
                return getRawButton(Button.k4.value);
            case 5:
                return getRawButton(Button.k5.value);
            case 6:
                return getRawButton(Button.k6.value);
            case 7:
                return getRawButton(Button.k7.value);
            case 8:
                return getRawButton(Button.k8.value);
            case 9:
                return getRawButton(Button.k9.value);
            case 10:
                return getRawButton(Button.k10.value);
            case 11:
                return getRawButton(Button.k11.value);
            case 12:
                return getRawButton(Button.k12.value);
            default:
                return false;
        }
    }

    /**
     * Gets whether the specified button was pressed since the last check.
     *
     * @param button The button index, starting with 1.
     * @return {@code true} if the specified button was pressed since the last check, {@code false}
     *     otherwise.
     */
    public boolean getButtonPressed(int button) {
        switch (button) {
            case 1:
                return getRawButtonPressed(Button.k1.value);
            case 2:
                return getRawButtonPressed(Button.k2.value);
            case 3:
                return getRawButtonPressed(Button.k3.value);
            case 4:
                return getRawButtonPressed(Button.k4.value);
            case 5:
                return getRawButtonPressed(Button.k5.value);
            case 6:
                return getRawButtonPressed(Button.k6.value);
            case 7:
                return getRawButtonPressed(Button.k7.value);
            case 8:
                return getRawButtonPressed(Button.k8.value);
            case 9:
                return getRawButtonPressed(Button.k9.value);
            case 10:
                return getRawButtonPressed(Button.k10.value);
            case 11:
                return getRawButtonPressed(Button.k11.value);
            case 12:
                return getRawButtonPressed(Button.k12.value);
            default:
                return false;
        }
    }

    /**
     * Gets whether the specified button was released since the last check.
     *
     * @param button The button index, beginning at 1.
     * @return {@code true} if the specified button was released since the last check, {@code false}
     *     otherwise.
     */
    public boolean getButtonReleased(int button) {
        switch (button) {
            case 1:
                return getRawButtonReleased(Button.k1.value);
            case 2:
                return getRawButtonReleased(Button.k2.value);
            case 3:
                return getRawButtonReleased(Button.k3.value);
            case 4:
                return getRawButtonReleased(Button.k4.value);
            case 5:
                return getRawButtonReleased(Button.k5.value);
            case 6:
                return getRawButtonReleased(Button.k6.value);
            case 7:
                return getRawButtonReleased(Button.k7.value);
            case 8:
                return getRawButtonReleased(Button.k8.value);
            case 9:
                return getRawButtonReleased(Button.k9.value);
            case 10:
                return getRawButtonReleased(Button.k10.value);
            case 11:
                return getRawButtonReleased(Button.k11.value);
            case 12:
                return getRawButtonReleased(Button.k12.value);
            default:
                return false;
        }
    }

    /**
     * Constructs an event instance around the specified button's digital signal.
     *
     * @param button The button index, starting with 1.
     * @param loop the event loop instance to attach the event to.
     * @return an event instance representing the specified button's digital signal attached to the
     *     given loop.
     */
    public BooleanEvent getButtonEvent(int button, EventLoop loop) {
        switch (button) {
            case 1:
                return button(Button.k1.value, loop);
            case 2:
                return button(Button.k1.value, loop);
            case 3:
                return button(Button.k1.value, loop);
            case 4:
                return button(Button.k1.value, loop);
            case 5:
                return button(Button.k5.value, loop);
            case 6:
                return button(Button.k6.value, loop);
            case 7:
                return button(Button.k7.value, loop);
            case 8:
                return button(Button.k8.value, loop);
            case 9:
                return button(Button.k9.value, loop);
            case 10:
                return button(Button.k10.value, loop);
            case 11:
                return button(Button.k11.value, loop);
            case 12:
                return button(Button.k12.value, loop);
            default:
                return new BooleanEvent(loop, () -> false);
        }
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("HID");
        builder.publishConstString("ControllerType", "Reyann");
        builder.addBooleanProperty("1st Button", () -> getButton(1), null);
        builder.addBooleanProperty("2st Button", () -> getButton(2), null);
        builder.addBooleanProperty("3st Button", () -> getButton(3), null);
        builder.addBooleanProperty("4st Button", () -> getButton(4), null);
        builder.addBooleanProperty("5st Button", () -> getButton(5), null);
        builder.addBooleanProperty("6st Button", () -> getButton(6), null);
        builder.addBooleanProperty("7st Button", () -> getButton(7), null);
        builder.addBooleanProperty("8st Button", () -> getButton(8), null);
        builder.addBooleanProperty("9st Button", () -> getButton(9), null);
        builder.addBooleanProperty("10st Button", () -> getButton(10), null);
        builder.addBooleanProperty("11st Button", () -> getButton(11), null);
        builder.addBooleanProperty("12st Button", () -> getButton(12), null);
    }
}
