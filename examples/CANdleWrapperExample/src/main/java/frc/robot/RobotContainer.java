// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;

import GuardianLib.Hardware.LEDControllers.CANdleWrapper;
import GuardianLib.Hardware.LEDControllers.CANdleWrapper.CANdleState;
import GuardianLib.Hardware.LEDControllers.Utility.CANDeviceDetails;
import GuardianLib.Hardware.LEDControllers.Utility.CTREBuiltInAnimations;
import GuardianLib.Hardware.LEDControllers.Utility.CANDeviceDetails.Manufacturer;
import com.ctre.phoenix.led.CANdle;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private CANdleWrapper CANdle;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    CTREBuiltInAnimations builtInAnimations = new CTREBuiltInAnimations(92, 145, 230);
    CANdle = new CANdleWrapper(new CANDeviceDetails(1, "example CANbus", Manufacturer.CTRE, "m_exampleSubsystem"), 100);

    CANdle.setStateAnimation(CANdleState.OFF, builtInAnimations.COLORFLOW);
  }

  public void periodic() {
    CANdle.periodic();
  }
}
