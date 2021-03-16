/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Piston extends SubsystemBase {

  DoubleSolenoid pist;
  public Boolean direction = true;
  
  public Piston() {
    pist = new DoubleSolenoid(0, Constants.Sol1, Constants.Sol2);
  }
  
   public void PistonOut()
  {
    pist.set(Value.kForward);
    direction = false;
  }

  public void PistonIn()
  {
    pist.set(Value.kReverse);
    direction = true;
  } 
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
