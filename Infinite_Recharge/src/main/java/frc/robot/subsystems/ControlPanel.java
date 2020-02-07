/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.ColorSensorV3;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.DriverStation;
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

  public static final WPI_TalonSRX ControlPanelMotor = new WPI_TalonSRX(Constants.ControlPanelMotor);

  public static String colorCode = "N";
  public static String fmsData = "N";
  public static String initialColor = "N";
  public static int counter = 0;
  public static boolean posFinish = false;
  public static boolean rotFinish = false;
  public static boolean r = false;
  public static boolean g = false;
  public static boolean b = false;
  public static boolean y = false;

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
      colorCode = "B";
    }
    else if (match.color == kGreen)
    {
      colorCode = "G";
    }
    else if (match.color == kRed)
    {
      colorCode = "R";
    }
    else if (match.color == kYellow)
    {
      colorCode = "Y";
    }
    else
    {
      colorCode = "N";
    }
    SmartDashboard.putNumber("R", detectedColor.red);
    SmartDashboard.putNumber("G", detectedColor.green);
    SmartDashboard.putNumber("B", detectedColor.blue);
    SmartDashboard.putString("Detected Color", colorCode);
  }

  public void GetFMS() {
    fmsData = DriverStation.getInstance().getGameSpecificMessage();
  }

  public void Position() {
    PutColorValue();
    if (fmsData == colorCode)
    {
      ControlPanelMotor.set(0.0);
      posFinish = true;
    }
    else
    {
      ControlPanelMotor.set(1.0);
    }
  }


  public void Rotation() {
    PutColorValue();
    if (colorCode == "R")
    {
      r = true;
    }
    else if (colorCode == "G")
    {
      g = true;
    }
    else if (colorCode == "B")
    {
      b = true;
    }
    else if (colorCode == "Y")
    {
      y = true;
    }
    else
    {
      //do nothing
    }

    if (r && g && b && y)
    {
      r = false;
      g = false;
      b = false;
      y = false;
      counter++;
    }

    if (counter < 6)
    {
      ControlPanelMotor.set(1.0);
    }
    else 
    {
      ControlPanelMotor.set(0.0);
      rotFinish = true;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
