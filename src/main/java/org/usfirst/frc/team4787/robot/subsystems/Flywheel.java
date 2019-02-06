package org.usfirst.frc.team4787.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4787.robot.RobotMap;

/**
 *
 */
public class Flywheel extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private PWMVictorSPX fly;
	
	public Flywheel() {
		fly = new PWMVictorSPX(RobotMap.motor_flywheel);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(double speed) {
    	fly.set(speed);
    }
}

//add the implementation of the controller here, after figuring it out for drivetrain