/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class StopShoot extends CommandBase {
  /**
   * Creates a new StopShoot.
   */
  private final Shooter m_shooter;
  private final Limelight m_Limelight;

  public StopShoot(Shooter piboticsshooter, Limelight limelight) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = piboticsshooter;
    m_Limelight = limelight;
    addRequirements(m_shooter);
    addRequirements(m_Limelight);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.WheelsOff();
    m_Limelight.offLight();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
