/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4787.robot;

import org.usfirst.frc.team4787.robot.commands.DriveTrainWithJoystick;
import org.usfirst.frc.team4787.robot.subsystems.Cannon;
import org.usfirst.frc.team4787.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4787.robot.subsystems.DriveTrainGyro;
import org.usfirst.frc.team4787.robot.subsystems.Flywheel;
import org.usfirst.frc.team4787.robot.subsystems.Forklift;
import org.usfirst.frc.team4787.robot.subsystems.SolenoidSubsystem;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	public static DriveTrain m_driveTrain;
	public static Flywheel m_flywheel;
	public static Forklift m_forklift;
	public static OI m_OI;
	public static DriveTrainWithJoystick m_joystickControl;
	public static Cannon m_Cannon = new Cannon();
	public static boolean isRunning = false;
  /**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_driveTrain = new DriveTrain();
		m_OI = new OI();
		m_joystickControl = new DriveTrainWithJoystick();
		//m_Cannon = new Cannon();
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// m_autoSelected = SmartDashboard.getString("Auto Selector",
		// 		kDefaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		//m_driveTrain.drive(-OI.getRx(),OI.getRy(),OI.getRz());
		m_driveTrain.drive(OI.getJoystick());

		if(OI.buttonDown(1) && !isRunning) {
			Thread fireThread = new Thread() {
				public void run() {
					try {
						m_Cannon.set(1);
						Thread.sleep(75);
						m_Cannon.set(0);
						Thread.sleep(150);
						m_Cannon.set(-1);
						Thread.sleep(75);
						m_Cannon.set(0);
						Thread.sleep(2000);
						isRunning = false;
					}
					catch(InterruptedException v) {
						System.out.print(v);
					}
				}
			};
			isRunning = true;
			fireThread.start();
		}
		
		m_Cannon.rotate(0);
		if(OI.buttonDown(2)) {
			m_Cannon.rotate(0.25);
		}
		if(OI.buttonDown(3)) {
			m_Cannon.rotate(-0.25);
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
