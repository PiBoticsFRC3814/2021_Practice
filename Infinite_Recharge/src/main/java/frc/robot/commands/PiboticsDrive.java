/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase; //wpi library based inclusion for all command based programs
import frc.robot.subsystems.DriveTrain; //include all subsystems that this command needs to access
import java.util.function.DoubleSupplier; //java based include files taht may not be needed for all programs

public class PiboticsDrive extends CommandBase {
  /**
   * Creates a new PiboticsDrive.
   */
  private final DriveTrain m_drivetrain; // this creates the instance of the subsytem for this command
  private final DoubleSupplier m_x; // double suppiers used specifically when a double variable is being given to the command
  private final DoubleSupplier m_y;

  public PiboticsDrive(DoubleSupplier x, DoubleSupplier y, DriveTrain piboticsdrive) {
    //the above code is the basica comand requirements it is expecting to see two doubles and a drivetrain subsystem every time it is called    
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = piboticsdrive; //this takes the given drive train from teh called command and set is to the variable name were are locally using
    m_x = x; // takes the suplied double and names it to the local variable name
    m_y = y;
    addRequirements(m_drivetrain); //this is a subsystem that is required for this command to work the drive train command would obviously need the drive subsystem.
    //more requriements can be added as needed ie a gyro subsytem ffor better contrrols if it is not iuncluded in the drive subsystem.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { //the initialize will run one time the first time the comamnd is run and then never run again
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { //this is run everytime the connand is called
    m_drivetrain.Drive(m_x.getAsDouble(), m_y.getAsDouble(), true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { //this is run everytime another commend requres use of the subsytem that is required by hte addRequirements()
    //m_drivetrain.Drive(0, 0); // this line is commented because on interupt we do not need to stop the robot, the code that can interup would properly handle the motors
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() { // this i used to create conditions to make the command no longe3r execute every loop of the program.
    return false; // since drive is allways needed we never need to stop this command once it starts.
  }
}
