/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.DriveTrain;

public class DriveLimelight extends CommandBase {
  /**
   * Creates a new LimeLight.
/** */
  Limelight m_LimeLight;
  DriveTrain m_PiboticsDrive;
  public static double ys, zs;
  public DriveLimelight(DriveTrain piboticsdrive, Limelight LimeLight) {
    m_PiboticsDrive = piboticsdrive;
    m_LimeLight = LimeLight;
    addRequirements(m_PiboticsDrive);
    addRequirements(m_LimeLight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_LimeLight.onLight();
    m_LimeLight.displayOutput();
    SmartDashboard.putBoolean("Target Acquired", m_LimeLight.isValidTarget());
    if (m_LimeLight.yaw > 2)
    {
      ys = 0.2;
    }
    else if (m_LimeLight.yaw < -2)
    {
      ys = -0.2;
    }
    else
    {
      ys = 0;
    }
    if (m_LimeLight.z < 1)
    {
      zs = -0.4;
    }
    else if (m_LimeLight.z > 2)
    {
      zs = 0.4;
    }
    else
    {
      zs = 0;
    }

    if (ys == 0 && zs == 0)
    {
      m_LimeLight.position = true;
    }
    else
    {
      m_LimeLight.position = false;
    }
    m_PiboticsDrive.Drive(zs, ys, false);
    SmartDashboard.putNumber("Zs", zs);
    SmartDashboard.putNumber("Ys", ys);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_LimeLight.isValidTarget())
    {
      return false;
    }
    else
    {
      m_LimeLight.offLight();
      return true;
    }
  }
}
