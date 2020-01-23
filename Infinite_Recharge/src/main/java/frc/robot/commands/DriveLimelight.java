/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;

public class LimeLight extends CommandBase {
  /**
   * Creates a new LimeLight.
/** */
  double xs, ys, zs;
  public LimeLight() {
    requires(RobotContainer.m_piboticsdrive);
    requires(RobotContainer.m_LimeLight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_LimeLight.getData();
    SmartDashboard.puBoolean("Target Acquired", RobotContainer.m_LimeLight.isValidTarget());
    if (RobotContainer.m_LimeLight.x > 1)
    {
      xs = -0.3;
    }
    else if (RobotContainer.m_LimeLight.x < -1)
    {
      xs = 0.3;
    }
    else
    {
      xs = 0;
    }

    if (RobotContainer.m_LimeLight.yaw > 2)
    {
      ys = 0.1;
    }
    else if (RobotContainer.m_LimeLight.yaw < -2)
    {
      ys = -0.1;
    }
    else
    {
      ys = 0;
    }
    
    if (RobotContainer.m_LimeLight.z < -20)
    {
      zs = -0.2;
    }
    else
    {
      zs = 0;
    }

    RobotContainer.m_piboticsdrive.
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (RobotContainer.m_LimeLight.isValidTarget())
    {
      return false;
    }
    else
    {
      return true;
    }
  }
}
