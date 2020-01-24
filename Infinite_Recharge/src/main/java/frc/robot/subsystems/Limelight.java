/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  public double[] data = {0,0,0,0,0,0};
  public double x, yaw, z;
  public Limelight() {

  }

  public void getData() {
    data = NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran").getDoubleArray(data);
    x = data[0];
    yaw = data[4];
    z = data[2];
  }

  public boolean isValidTarget() {
    if (x == 0.0 && yaw == 0.0 && z == 0.0)
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
    SmartDashboard.putNumberArray("Camtran1", data);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
