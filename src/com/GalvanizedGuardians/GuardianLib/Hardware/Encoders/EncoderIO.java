/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.Encoders;

import edu.wpi.first.math.geometry.Rotation2d;

/**
 * Interface representing the interface to encoder hardware, providing methods for configuring,
 * reading, and managing encoder values and faults.
 */
public interface EncoderIO {
    /**
     * Represents the inputs for the gyro sensor used in the encoder system. This class holds the
     * data related to the encoder's position and fault status.
     */
    public static class EncoderIOInputs {
        /**
         * The current position of the encoder as a rotation. The value is represented as a {@link
         * Rotation2d} object.
         */
        private Rotation2d encoderPosition = new Rotation2d();

        /**
         * Indicates whether a fault has occurred with the encoder. This is a boolean flag that
         * reflects the faulted status of the encoder.
         */
        private boolean faulted = false;

        /**
         * Gets encoder position as rotation. The value is represented as a {@link Rotation2d}
         * object.
         *
         * @return The encoder position as a {@link Rotation2d}
         */
        public Rotation2d getEncoderPosition() {
            return encoderPosition;
        }

        /**
         * Sets encoder position as a rotation. The value is represented as a {@link Rotation2d}
         * object.
         *
         * @param encoderPosition
         */
        public void setEncoderPosition(Rotation2d encoderPosition) {
            this.encoderPosition = encoderPosition;
        }

        /**
         * Gets whether a fault has occurred with the encoder. This is a boolean flag that reflects
         * the faulted status of the encoder.
         *
         * @return Whether a fault has occured with the encoder.
         */
        public boolean getFaulted() {
            return faulted;
        }

        /**
         * Sets the boolean flag, indicating whether a fault has occurred with the encoder.
         *
         * @param faulted
         */
        public void setFaulted(boolean faulted) {
            this.faulted = faulted;
        }
    }

    /**
     * Updates the encoder inputs based on external sources. This method is typically called to
     * fetch the latest encoder data.
     *
     * @param inputs The encoder inputs to update.
     */
    public default void updateInputs(EncoderIOInputs inputs) {}

    /**
     * Periodic method that is called to process updates for a {@link CANCoderWrapper}. This is an
     * additional method for custom periodic updates based on the encoder type.
     *
     * @param encoder The CanCoderWrapper instance to process.
     */
    public default void periodic(CANCoderWrapper encoder) {}

    /**
     * Periodic method that is called to process updates for a {@link ThriftyAbsoluteEncoder}. This
     * method provides periodic updates for this encoder type.
     *
     * @param encoder The ThriftyAbsoluteEncoder instance to process.
     */
    public default void periodic(ThriftyAbsoluteEncoder encoder) {}

    /**
     * Periodic method that performs any required updates for the encoder. Typically called at
     * regular intervals during the robot's operation.
     */
    public default void periodic() {}

    /**
     * Configures the absolute encoder sensor position, including determining the inversion state.
     * This method ensures that the encoder's setup is correctly applied, including handling
     * inversion.
     */
    public default void configAbsEncoder() {}

    /**
     * Gets the absolute position of the encoder. The absolute position is typically represented in
     * a normalized rotation range.
     *
     * @return The absolute position of the encoder, typically in a rotation range of (-1 to 0) or
     *     (0 to 1).
     */
    public default double getAbsolutePosition() {
        return 0.0;
    }

    /**
     * Resets the encoder to its factory defaults. This will reset all encoder settings but will not
     * clear the stored zero offset.
     */
    public default void factoryDefault() {}

    /**
     * Clears any sticky faults on the encoder. Sticky faults may occur due to hardware issues and
     * should be cleared as part of the normal maintenance.
     */
    public default void clearStickyFaults() {}

    /**
     * Checks for any faults in the encoder system. This method should be called periodically to
     * ensure the encoder is functioning properly.
     */
    public default void checkForFaults() {}
}
