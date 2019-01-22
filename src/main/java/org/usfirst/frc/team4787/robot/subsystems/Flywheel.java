package org.usfirst.frc.team4787.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4787.robot.RobotMap;

/**
 *
 */
public class Flywheel extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Spark fly1;
	private Spark fly2;
	
	public Flywheel() {
		//fly1 = new Spark(RobotMap.motor_flywheel_left);
		//fly2 = new Spark(RobotMap.motor_flywheel_right);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(double speed) {
    	//fly1.set(speed);
    	//fly2.set(-speed);
    }
}

//add the implementation of the controller here, after figuring it out for drivetrain