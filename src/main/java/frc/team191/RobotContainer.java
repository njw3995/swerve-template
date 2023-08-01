// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team191;

import java.io.File;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.team191.subsystems.SwerveSubsystem;

public class RobotContainer 
{

  CommandXboxController driver = new CommandXboxController(Constants.GeneralConstants.DRIVER_CONTROLLER_ID);
  CommandXboxController operator = new CommandXboxController(Constants.GeneralConstants.OPERATOR_CONTROLLER_ID);

  public static final SwerveSubsystem swerve = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(), "swerve"));

  public RobotContainer() 
  {
    configureBindings();
    swerve.setDefaultCommand(new InstantCommand());
  }

  private void configureBindings() 
  {
    driver.x().onTrue(new InstantCommand(() -> swerve.zeroGyro()));
  }
}
