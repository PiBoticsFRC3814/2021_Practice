/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.BlockingMotor;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeMaintain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class AutoShoot extends CommandBase {
  /**
   * Creates a new AutoShoot.
   */
  Limelight m_LimeLight;
  Shooter m_Shooter;
  DriveTrain m_PiboticsDrive;
  IntakeMaintain m_Intake;
  BlockingMotor m_Gate;
  public boolean isFinished = false;
  public static double ys = 0.0, zs = 0.0;
  public AutoShoot(Limelight limelight, Shooter shooter, DriveTrain drive, IntakeMaintain intake, BlockingMotor gate) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_LimeLight = limelight;
    m_Shooter = shooter;
    m_PiboticsDrive = drive;
    m_Intake = intake;
    m_Gate = gate;
    addRequirements(m_LimeLight);
    addRequirements(m_Shooter);
    addRequirements(m_PiboticsDrive);
    addRequirements(m_Intake);
    addRequirements(m_Gate);
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

    //m_Shooter.WheelsOn();

    if (m_LimeLight.isInPosition() && m_Shooter.maxRPM())
    {
      //shoot
    }
    else
    {
      //noshoot
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
