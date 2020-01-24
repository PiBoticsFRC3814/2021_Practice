/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class IntakeMaintain extends SubsystemBase {
  /**
   * Creates a new IntakeBalls.
   */
  WPI_TalonSRX frontIntake;
  WPI_TalonSRX rearIntake;
  public boolean FToggle = false;
  public boolean RToggle = false;

  public IntakeMaintain() {
    frontIntake = new WPI_TalonSRX(Constants.frontIntake);
    rearIntake = new WPI_TalonSRX(Constants.rearIntake);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void maintainIntakeFront(){
    frontIntake.set(Constants.maintainSpeed);
    FToggle = false;
  }

  public void ballIntakeFront(){
    frontIntake.set(Constants.ballIntakeSpeed);
    FToggle = true;
  }

  public void maintainIntakeRear(){
    rearIntake.set(-Constants.maintainSpeed);
    RToggle = false;
  }

  public void ballIntakeRear(){
    rearIntake.set(-Constants.ballIntakeSpeed);
    RToggle = true;
  }
}
