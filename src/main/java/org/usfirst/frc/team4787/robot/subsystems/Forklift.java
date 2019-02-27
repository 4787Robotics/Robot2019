package org.usfirst.frc.team4787.robot.subsystems;

import org.usfirst.frc.team4787.robot.RobotMap;

//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {
	
	private PWMVictorSPX forklift_motor;
	
	public Forklift() {
		
		forklift_motor = new PWMVictorSPX(RobotMap.forklift_pin);
	}
	
	public void setSpeed(double speed) {
		forklift_motor.set(speed);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

//add the implementation of the controller here, after figuring it out for drivetrain