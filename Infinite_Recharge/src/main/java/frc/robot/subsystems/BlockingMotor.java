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

public class BlockingMotor extends SubsystemBase {
  private static final WPI_TalonSRX blockingMotor = new WPI_TalonSRX(Constants.blMotor);
  /**
   * Creates a new BlockingMotor.
   */
  public BlockingMotor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void fire() { 
    blockingMotor.set(Constants.gateSpeed);

  }
  //^^^ is what it would do to shoot ^^^
  public void safety(){
    blockingMotor.set(Constants.gateReverse);
  }
  public void halt(){
    blockingMotor.set(0.0);
  }
}
