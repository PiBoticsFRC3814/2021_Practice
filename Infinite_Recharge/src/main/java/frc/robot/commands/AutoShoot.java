/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
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
  ADXRS450_Gyro gyro;
  Timer shootDelay;
  public boolean isFinished = false;
  public static double ys = 0.0, zs = 0.0;
  public AutoShoot(Limelight limelight, Shooter shooter, DriveTrain drive, IntakeMaintain intake, BlockingMotor gate, ADXRS450_Gyro gyroscope) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_LimeLight = limelight;
    m_Shooter = shooter;
    m_PiboticsDrive = drive;
    m_Intake = intake;
    m_Gate = gate;
    gyro = gyroscope;
    addRequirements(m_LimeLight);
    addRequirements(m_Shooter);
    addRequirements(m_PiboticsDrive);
    addRequirements(m_Intake);
    addRequirements(m_Gate);
    shootDelay = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shootDelay.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_LimeLight.onLight();
    m_LimeLight.displayOutput(gyro.getAngle());
    SmartDashboard.putBoolean("Target Acquired", m_LimeLight.isValidTarget());
    if (m_LimeLight.yaw > 2)
    {
      ys = 0.3;
    }
    else if (m_LimeLight.yaw < -2)
    {
      ys = -0.3;
    }
    else
    {
      ys = 0;
    }
    if (m_LimeLight.z < 9)
    {
      zs = -0.4;
    }
    else if (m_LimeLight.z > 11)
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
      shootDelay.start();
    }
    else
    {
      m_LimeLight.position = false;
    }
    m_PiboticsDrive.Drive(zs, ys, false);
    SmartDashboard.putNumber("Zs", zs);
    SmartDashboard.putNumber("Ys", ys);

    m_Shooter.WheelsOn();

    if (m_LimeLight.isInPosition())
    {
      
      m_Intake.intakeOn();
      
    }
    else
    {
      m_Intake.intakeOff();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_LimeLight.isValidTarget())
    {
      return false;
    }
    else
    {

      return true;
    }
  }
}
