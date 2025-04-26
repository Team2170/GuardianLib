// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;

import GuardianLib.Hardware.Controllers.ReyannController; // Import ReyannController
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
 * This class is where the bulk of the robot should be declared. It contains subsystems, commands,
 * and mappings for operator input devices like controllers.
 */
public class RobotContainer {
  // Example subsystem for demonstration purposes
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private CANdleWrapper CANdle;

  // Declare a ReyannController instance to handle input from a Reyann joystick/gamepad
  private ReyannController reyannController = new ReyannController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Initialize the ReyannController on port 0
    // Port 0 corresponds to the USB port where the controller is connected
    reyannController = new ReyannController(0);

    // Map buttons on the ReyannController to specific actions or commands
    mapControllerButtons();

    // Initialize CANdleWrapper (existing code)
    CTREBuiltInAnimations builtInAnimations = new CTREBuiltInAnimations(92, 145, 230);
    CANdle = new CANdleWrapper(new CANDeviceDetails(1, "example CANbus", Manufacturer.CTRE, "m_exampleSubsystem"), 100);
    CANdle.setStateAnimation(CANdleState.OFF, builtInAnimations.COLORFLOW);
  }

  /**
   * Maps buttons on the ReyannController to specific actions or commands.
   * For example, pressing button A triggers an ExampleCommand.
   */
  private void mapControllerButtons() {
    // Map button A to trigger a command
    new Trigger(() -> reyannController.isButtonPressed("A"))
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Map button B to print a message to the console
    new Trigger(() -> reyannController.isButtonPressed("B"))
        .onTrue(() -> System.out.println("Button B pressed!")); // Example action
  }

  public void periodic() {
    // Periodic updates for CANdleWrapper
    CANdle.periodic();
  }
}
