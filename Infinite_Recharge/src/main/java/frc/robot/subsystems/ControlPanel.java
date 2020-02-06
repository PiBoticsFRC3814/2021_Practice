/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

public class ControlPanel extends SubsystemBase {
  /**
   * Creates a new ControlPanel.
   */
  private static final I2C.Port i2cPort = I2C.Port.kOnboard;

  private static final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

  private static final ColorMatch m_colorMatcher = new ColorMatch();

  private static final Color kCyan = ColorMatch.makeColor(.11, .43, .43);
  private static final Color kGreen = ColorMatch.makeColor(.15, .58, .25);
  private static final Color kRed = ColorMatch.makeColor(.53, .34, .125);
  private static final Color kYellow = ColorMatch.makeColor(.31, .56, .12);

  Color detectedColor = colorSensor.getColor();
  ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

  public static String colorString = "";

  public static int[] colors = {0,0,0,0};

  public ControlPanel() {
    m_colorMatcher.addColorMatch(kCyan);
    m_colorMatcher.addColorMatch(kGreen);
    m_colorMatcher.addColorMatch(kRed);
    m_colorMatcher.addColorMatch(kYellow);
  }

  public void PutColorValue() {
    detectedColor = colorSensor.getColor();
    match = m_colorMatcher.matchClosestColor(detectedColor);
    if (match.color == kCyan)
    {
      colorString = "Cyan";
    }
    else if (match.color == kGreen)
    {
      colorString = "Green";
    }
    else if (match.color == kRed)
    {
      colorString = "Red";
    }
    else if (match.color == kYellow)
    {
      colorString = "Yellow";
    }
    else
    {
      colorString = "No Data";
    }
    SmartDashboard.putNumber("R", detectedColor.red);
    SmartDashboard.putNumber("G", detectedColor.green);
    SmartDashboard.putNumber("B", detectedColor.blue);
    SmartDashboard.putString("Detected Color", colorString);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
