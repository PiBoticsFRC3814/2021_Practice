/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ToggleFeet;

public class FToggleFeet extends CommandBase {
  /**
   * Creates a new FToggleFeet.
   */

  private final ToggleFeet m_ToggleFeet;

  public FToggleFeet(ToggleFeet m_Toggle) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_ToggleFeet = m_Toggle;

    addRequirements(m_ToggleFeet);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!m_ToggleFeet.frontDirection)
    {
      m_ToggleFeet.FrontExtend();
    }
    else
    {
      m_ToggleFeet.FrontRetract();
    }
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
