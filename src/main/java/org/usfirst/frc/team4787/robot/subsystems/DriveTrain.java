package org.usfirst.frc.team4787.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;

import org.usfirst.frc.team4787.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon front_left;
	private Talon back_left;
	private Talon front_right;
	private Talon back_right;
	//private TankDrive motor_drive;
	private MecanumDrive motor_drive;
	
	public DriveTrain() {
		//sets the pid values, might need feed forward
		
		
		front_left = new Talon(RobotMap.motor_front_left);
		back_left = new Talon(RobotMap.motor_back_left);
		front_right = new Talon(RobotMap.motor_front_right);
		back_right = new Talon(RobotMap.motor_back_right);
		motor_drive = new MecanumDrive(front_left, back_left, front_right, back_right);
		/*m_gyro = new AnalogGyro(RobotMap.gyro);
		
		m_gyro.calibrate();*/
	}
    
	public void initDefaultCommand() {	
	}
	
    public void stopMotors() {
    	motor_drive.stopMotor();
    }
    
    public void drive(double xSpeed, double ySpeed, double zRotation) {	
    	motor_drive.driveCartesian(xSpeed, ySpeed, zRotation);
    }
    
    //public void drive(Joystick joy) {
    //	this.drive(-joy.getY(), -joy.getThrottle());
    //}
    

    ///umm this would not work??? 
}

