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
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;

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
 
     // PID coefficients
     kP = 5e-5; 
     kI = 1e-6;
     kD = 0; 
     kIz = 0; 
     kFF = 0; 
     kMaxOutput = 1; 
     kMinOutput = -1;
     maxRPM = 3814;
 
     // set PID coefficients
     m_pidController.setP(kP);
     m_pidController.setI(kI);
     m_pidController.setD(kD);
     m_pidController.setIZone(kIz);
     m_pidController.setFF(kFF);
     m_pidController.setOutputRange(kMinOutput, kMaxOutput);
 
     // display PID coefficients on SmartDashboard
     SmartDashboard.putNumber("P Gain", kP);
     SmartDashboard.putNumber("I Gain", kI);
     SmartDashboard.putNumber("D Gain", kD);
     SmartDashboard.putNumber("I Zone", kIz);
     SmartDashboard.putNumber("Feed Forward", kFF);
     SmartDashboard.putNumber("Max Output", kMaxOutput);
     SmartDashboard.putNumber("Min Output", kMinOutput);
   }
  public void WheelsOn() {

    m_pidController.setReference(maxRPM, ControlType.kVelocity);
    SmartDashboard.putNumber("SetPoint", maxRPM);
    SmartDashboard.putNumber("ProcessVariable", m_encoder.getVelocity());
    
  }
  public void WheelsOff() {
    m_motor.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
