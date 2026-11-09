// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.Shooter.Shooter;
import frc.robot.Subsystems.Shooter.ShooterIOSim;

public class RobotContainer {
  private final Shooter shooter;
  private CommandXboxController xbox = new CommandXboxController(0);
  public RobotContainer() {
   shooter = new Shooter(new ShooterIOSim());
    configureBindings();
  }

  private void configureBindings() {
    xbox.y().whileTrue(shooter.shoot()).onFalse(shooter.stopCommand());
    xbox.leftTrigger().whileTrue(shooter.runIntake()).onFalse(shooter.stopCommand());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
