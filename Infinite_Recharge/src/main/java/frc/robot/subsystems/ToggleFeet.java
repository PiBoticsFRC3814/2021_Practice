/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

public class ToggleFeet extends SubsystemBase {
  /**
   * Creates a new ToggleFeet.
   */
  DoubleSolenoid front;
  DoubleSolenoid rear;
  public Boolean frontDirection = true;
  public Boolean rearDirection = true;

  
  public ToggleFeet() {
    front = new DoubleSolenoid(Constants.PCM1, Constants.frontExtend, Constants.frontRetract);
    rear = new DoubleSolenoid(Constants.PCM1, Constants.rearExtend, Constants.rearRetract);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void FrontExtend(){
    front.set(Value.kForward);

    frontDirection = false;
  }

  public void FrontRetract(){
    front.set(Value.kReverse);

    frontDirection = true;
  }

  public void RearExtend(){
    rear.set(Value.kForward);

    rearDirection = false;
  }

  public void RearRetract(){
    rear.set(Value.kReverse);

    rearDirection = true;
  }

}
