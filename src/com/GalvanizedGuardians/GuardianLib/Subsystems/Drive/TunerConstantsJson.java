package com.GalvanizedGuardians.GuardianLib.Subsystems.Drive;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.swerve.SwerveModuleConstants;

@SuppressWarnings("java:S116")
public class TunerConstantsJson {
    private SwerveDrivetrainConstants DrivetrainConstants;
    private SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> FrontLeft;
    private SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> FrontRight;
    private SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> BackLeft;
    private SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> BackRight;

    public SwerveDrivetrainConstants getDrivetrainConstants() {
        return DrivetrainConstants;
    }

    public void setDrivetrainConstants(SwerveDrivetrainConstants drivetrainConstants) {
        DrivetrainConstants = drivetrainConstants;
    }

    public SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> getFrontLeft() {
        return FrontLeft;
    }

    public void setFrontLeft(
            SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> frontLeft) {
        FrontLeft = frontLeft;
    }

    public SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> getFrontRight() {
        return FrontRight;
    }

    public void setFrontRight(
            SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> frontRight) {
        FrontRight = frontRight;
    }

    public SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> getBackLeft() {
        return BackLeft;
    }

    public void setBackLeft(
            SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> backLeft) {
        BackLeft = backLeft;
    }

    public SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> getBackRight() {
        return BackRight;
    }

    public void setBackRights(
            SwerveModuleConstants<TalonFXConfiguration, TalonFXConfiguration, CANcoderConfiguration> backRight) {
        BackRight = backRight;
    }
}
