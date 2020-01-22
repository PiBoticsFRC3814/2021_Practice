/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */

  private CANSparkMax m_motor;
  private CANPIDController m_pidController;
  private CANEncoder m_encoder;

  public Shooter() {
     // initialize motor
     m_motor = new CANSparkMax(Constants.shooterMotor, MotorType.kBrushless);

     /**
      * The RestoreFactoryDefaults method can be used to reset the configuration parameters
      * in the SPARK MAX to their factory default state. If no argument is passed, these
      * parameters will not persist between power cycles
      */
     m_motor.restoreFactoryDefaults();
     m_motor.getEncoder();
 
     /**
      * In order to use PID functionality for a controller, a CANPIDController object
      * is constructed by calling the getPIDController() method on an existing
      * CANSparkMax object
      */
     m_pidController = m_motor.getPIDController();
 
     // Encoder object created to display position values
     m_encoder = m_motor.getEncoder();
 
 
     // set PID coefficients
     m_pidController.setP(Constants.kP);
     m_pidController.setI(Constants.kI);
     m_pidController.setD(Constants.kD);
     m_pidController.setIZone(Constants.kIz);
     m_pidController.setFF(Constants.kFF);
     m_pidController.setOutputRange(Constants.kMinOutput, Constants.kMaxOutput);
 
     // display PID coefficients on SmartDashboard
     SmartDashboard.putNumber("P Gain", Constants.kP);
     SmartDashboard.putNumber("I Gain", Constants.kI);
     SmartDashboard.putNumber("D Gain", Constants.kD);
     SmartDashboard.putNumber("I Zone", Constants.kIz);
     SmartDashboard.putNumber("Feed Forward", Constants.kFF);
     SmartDashboard.putNumber("Max Output", Constants.kMaxOutput);
     SmartDashboard.putNumber("Min Output", Constants.kMinOutput);
   }
  public void WheelsOn() {

    m_pidController.setReference(Constants.maxRPM, ControlType.kVelocity);
    SmartDashboard.putNumber("SetPoint", Constants.maxRPM);
    SmartDashboard.putNumber("ProcessVariable", m_encoder.getVelocity());
    
    if (m_encoder.getVelocity() + 5 >= Constants.maxRPM && m_encoder.getVelocity() - 5 <= Constants.maxRPM) {
      Constants.shootable = true;
    }
    else {
      Constants.shootable = false;
    }
  }
  public void WheelsOff() {
    m_motor.set(0.0);
  }
  public boolean maxRPM() {
    return Constants.shootable;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
