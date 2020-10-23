/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//the purpose of the constance file is so certain variable that are not expected to change can be setup and cahgned here in ONE location so we do not need to change it all over.
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
    public static final int leftDrive = 1;
    public static final int rightDrive = 2;

//pneumatic IDs
    public static final int PCM1 = 0;
    public static final int Sol1 = 0;
    public static final int Sol2 = 1;

//Controller (joystick) IDs
    public static final int oi_Driver = 0;
}
