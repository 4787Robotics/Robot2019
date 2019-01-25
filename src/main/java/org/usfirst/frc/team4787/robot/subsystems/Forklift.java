package org.usfirst.frc.team4787.robot.subsystems;

import org.usfirst.frc.team4787.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Forklift extends Subsystem {
	
	private Spark forkliftMech1;
	private Spark forkliftMech2;
	
	public Forklift() {
		
		forkliftMech1 = new Spark(RobotMap.forklift_mech1);
		forkliftMech2 = new Spark(RobotMap.forklift_mech2);
	}
	
	public void setSpeed(double speed) {
		forkliftMech1.set(speed);
		forkliftMech2.set(speed);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

//add the implementation of the controller here, after figuring it out for drivetrain