/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.*;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private static final WPI_TalonSRX leftmotor = new WPI_TalonSRX(1);
  private static final WPI_TalonSRX rightmotor = new WPI_TalonSRX(2);

  private static final DifferentialDrive piboticsdrive = new DifferentialDrive(leftmotor, rightmotor);

  public DriveTrain() {

  }

  public void Drive(double y, double x) {
    piboticsdrive.arcadeDrive(y, x);
  }

  public boolean isInverted(){
    return leftmotor.getInverted();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
