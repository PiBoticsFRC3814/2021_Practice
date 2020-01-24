/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.DriveLimelight;
import frc.robot.commands.PiboticsDrive;
import frc.robot.commands.Shoot;
import frc.robot.commands.StopShoot;
import frc.robot.commands.RIntakeToggle;
import frc.robot.commands.FIntakeToggle;
import frc.robot.commands.GetLimelight;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.IntakeMaintain;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrain m_piboticsdrive = new DriveTrain();
  private final Shooter m_shooter = new Shooter();
  private final IntakeMaintain m_IntakeMaintain = new IntakeMaintain();
  private final Joystick m_joystick = new Joystick(0);
  private final Limelight m_LimeLight = new Limelight();


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    m_piboticsdrive.setDefaultCommand(new PiboticsDrive(() -> m_joystick.getY(), () -> m_joystick.getX(), m_piboticsdrive));
    m_LimeLight.setDefaultCommand(new GetLimelight(m_LimeLight));


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton FIntakeToggle = new JoystickButton(m_joystick, 5);
    final JoystickButton RIntakeToggle = new JoystickButton(m_joystick, 3);
    final JoystickButton shooter = new JoystickButton(m_joystick, 2);
    final JoystickButton LimelightMove =  new JoystickButton(m_joystick, 1);

    shooter.whenPressed(new Shoot(m_shooter));
    shooter.whenReleased(new StopShoot(m_shooter));

    FIntakeToggle.whenPressed(new FIntakeToggle(m_IntakeMaintain));
    RIntakeToggle.whenPressed(new RIntakeToggle(m_IntakeMaintain));
    LimelightMove.whileHeld(new DriveLimelight(m_piboticsdrive,m_LimeLight));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
