package org.usfirst.frc.team4787.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;

import org.usfirst.frc.team4787.robot.RobotMap;

/**
 *
 */
public class DriveTrainGyro extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon front_left;
	private Talon back_left;
	private Talon front_right;
	private Talon back_right;

	//private AnalogGyro m_gyro;
	private ADXRS450_Gyro m_gyro;
	
	public DriveTrainGyro(double kp, double ki, double kd, double f) {
		//sets the pid values, might need feed forward
		super(kp, ki, kd, f);
		
		
		front_left = new Talon(RobotMap.motor_front_left);
		back_left = new Talon(RobotMap.motor_back_left);
		front_right = new Talon(RobotMap.motor_front_right);
		back_right = new Talon(RobotMap.motor_back_right);
		//motor_drive = new TankDrive(front_left, back_left, front_right, back_right);
		/*m_gyro = new AnalogGyro(RobotMap.gyro);
		
		m_gyro.calibrate();*/
	
		
		m_gyro = new ADXRS450_Gyro();
		
		m_gyro.calibrate();
		
		this.enable();
	}
    
	public void initDefaultCommand() {	
	}
	
    public void stopMotors() {
    	//motor_drive.stopMotor();
    }
    
    public void drive(double xSpeed, double ySpeed, double zRotation) {	
    	//motor_drive.driveCartesian(xSpeed, ySpeed, 0.4*zRotation, m_gyro.getAngle());
    	//System.out.println(m_gyro.getAngle());
    }
    
    //for auto
    public void setAngle(double angle) {
    	setSetpoint(angle);
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return m_gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		System.out.println(output);
		//motor_drive.driveCartesian(0, 0, 5*output, m_gyro.getAngle());
	}

	public double getAngle() {
		return m_gyro.getAngle();
	}
	
    //public void drive(Joystick joy) {
    //	this.drive(-joy.getY(), -joy.getThrottle());
    //}
    

    ///umm this would not work??? 
}

