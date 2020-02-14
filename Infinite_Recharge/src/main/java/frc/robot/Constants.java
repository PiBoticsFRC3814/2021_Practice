/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
//talon IDs
    public static final int frontIntake = 10;
    public static final int rearIntake = 11;
    public static final int cMotor = 40;
    public static final int bMotor = 41;
    public static final int leftDrive = 1;
    public static final int blMotor = 50;
    public static final int rightDrive = 2;
    public static final int ControlPanelMotor = 30;
    public static final int shooterMotor = 20;

//pneumatic IDs
    public static final int PCM1 = 0;
    public static final int frontExtend = 0;
    public static final int frontRetract = 1;
    public static final int rearExtend = 2;
    public static final int rearRetract = 3;

//motor Speeds
    public static final double maintainSpeed = 0.0;
    public static final double ballIntakeSpeed = 0.75;
    public static final double upSpeed = 0.5;
    public static final double downSpeed = -0.5;
    public static final double leftSpeed = 1;
    public static final double rightSpeed = -1;
    public static final double gateSpeed = 0.1;
    public static final double gateReverse = -0.1;
    
// PID Shooter Values
    public static final double kP = 5e-5;
    public static final double kI = 1;
    public static final double kD = 0;
    public static final double kIz = 0;
    public static final double kFF = 0;
    public static final double kMaxOutput = 1;
    public static final double kMinOutput = -1;
    public static final double maxRPM = -5000;
//Controller IDs
    public static final int oi_Driver = 0;
    public static final int oi_Operator = 2;

}
