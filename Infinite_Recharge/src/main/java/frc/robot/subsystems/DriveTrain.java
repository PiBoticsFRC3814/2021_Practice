/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; //this is a special library that hte mfg of the talon motor control creates that we need to add to our libraries
import edu.wpi.first.wpilibj.drive.*; //this included ALL (*) of the associated drive libraries (arcade, curvature, mechanum, etc.)
import frc.robot.Constants; //(this included a file that we store all of our constant (unchanging) values (usefull to avoind changes to several files)

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private static final WPI_TalonSRX leftmotor = new WPI_TalonSRX(Constants.leftDrive); //creating and defining instances of the two motor controlers
  private static final WPI_TalonSRX rightmotor = new WPI_TalonSRX(Constants.rightDrive);

  private static final DifferentialDrive piboticsdrive = new DifferentialDrive(leftmotor, rightmotor); // creating and defining the type of drive trian and motors ivolved in it

  public DriveTrain() {

  }

  public void Drive(double y, double x, boolean stick) {
    piboticsdrive.arcadeDrive(-y, x, stick); // this will make the robot drive based on the double variables given to it
  }

  public boolean isInverted(){
    return leftmotor.getInverted();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
