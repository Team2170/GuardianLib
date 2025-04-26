/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package GuardianLib.Hardware.LEDControllers;

import GuardianLib.Hardware.LEDControllers.LEDControllerIO.LEDControllerIOInputs;

/**
 * Represents a base LED controller that interacts with an LED controller hardware interface. It
 * periodically updates the LED controller inputs and checks for faults.
 */
public class BaseLEDController {
    private final LEDControllerIO io;
    private final LEDControllerIOInputs inputs = new LEDControllerIOInputs();
    private final String name;

    /**
     * Constructs a BaseLedController instance with the specified name and LED
     * controller interface.
     *
     * @param name The name of the LED controller.
     * @param io   The LED controller input/output interface to interact with the
     *             hardware.
     */
    public BaseLEDController(String name, LEDControllerIO io) {
        this.name = name;
        this.io = io;
    }

    /**
     * Periodically updates the LED controller inputs by calling the corresponding
     * method from the I/O interface.
     */
    public void periodic() {
        io.updateInputs(inputs);
    }

    /**
     * Checks for faults in the LED controller by calling the corresponding method
     * from the I/O
     * interface.
     */
    public void checkForFaults() {
        io.checkForFaults();
    }
}