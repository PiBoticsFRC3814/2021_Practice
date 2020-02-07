/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

public class RotationControl extends CommandBase {
  /**
   * Creates a new RotationControl.
   */
  ControlPanel m_ControlPanel;
  public RotationControl(ControlPanel panel) {
    m_ControlPanel = panel;
    addRequirements(m_ControlPanel);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ControlPanel.rotFinish = false;  
    m_ControlPanel.counter = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ControlPanel.PutColorValue();
    m_ControlPanel.Rotation();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_ControlPanel.rotFinish;
  }
}
