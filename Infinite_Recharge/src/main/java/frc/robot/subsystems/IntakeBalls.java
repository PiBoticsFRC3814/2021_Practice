/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.Constants;

public class IntakeBalls extends SubsystemBase {
  /**
   * Creates a new IntakeBalls.
   */
  WPI_TalonSRX frontIntake;
  WPI_TalonSRX backIntake;



  public IntakeBalls() {
    frontIntake = new WPI_TalonSRX(Constants.frontIntake);
    backIntake = new WPI_TalonSRX(Constants.backIntake);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
