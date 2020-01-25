/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  public double yaw, z, target;

  public Limelight() {
  }

  public void getData() {
    z = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0.0);
    yaw = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0);
    target = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0.0);
  }

  public boolean isValidTarget() {
    if (target == 0.0)
    {
       return false;
    }
   else
    {
      return true;
    }
  }

  public void displayOutput() {
    getData();
    SmartDashboard.putNumber("Target Area", z);
    SmartDashboard.putNumber("Yaw", yaw);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
