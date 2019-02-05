package org.usfirst.frc.team4787.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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
	private Spark front_left;
	private Spark back_left;
	private Spark front_right;
	private Spark back_right;
  private SpeedControllerGroup m_left;
  private SpeedControllerGroup m_right;
	private DifferentialDrive motor_drive;
	
	public DriveTrain() {
		//sets the pid values, might need feed forward
		
		
		front_left = new Spark(RobotMap.motor_front_left);
		back_left = new Spark(RobotMap.motor_back_left);
		front_right = new Spark(RobotMap.motor_front_right);
		back_right = new Spark(RobotMap.motor_back_right);
    m_left = new SpeedControllerGroup(front_left, back_left);
    m_right = new SpeedControllerGroup(front_right, back_right);
    
    motor_drive = new DifferentialDrive(m_left, m_right);
		/*m_gyro = new AnalogGyro(RobotMap.gyro);
		
		m_gyro.calibrate();*/
	}
    
	public void initDefaultCommand() {	
	}
	
    public void stopMotors() {
    	motor_drive.stopMotor();
    }
    
    /*public void drive(double xSpeed, double ySpeed, double zRotation) {	
    	motor_drive.driveCartesian(xSpeed, ySpeed, zRotation);
    }*/
    
    public void drive(double left, double right) {
      motor_drive.tankDrive(left, right);
    }

    public void drive(Joystick joy) {
    	//fix to swap to lspeed and rspeed
      motor_drive.arcadeDrive(-joy.getY(), 0.75*joy.getZ(), true);
    }
}

