/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;

public class PiboticsDrive extends CommandBase {
  /**
   * Creates a new PiboticsDrive.
   */
  private final DriveTrain m_drivetrain;
  private final DoubleSupplier m_x;
  private final DoubleSupplier m_y;

  public PiboticsDrive(DoubleSupplier x, DoubleSupplier y, DriveTrain piboticsdrive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = piboticsdrive;
    m_x = x;
    m_y = y;
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.Drive(m_x.getAsDouble(), m_y.getAsDouble(), true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_drivetrain.Drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
