package org.usfirst.frc.team4787.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4787.robot.RobotMap;
/**
 *
 */
public class SolenoidSubsystem extends Subsystem {

	//private Solenoid sol; 
	private Jaguar sol_controller;

	public SolenoidSubsystem(int solenoidPin) {
		super();
		
		sol_controller = new Jaguar(solenoidPin);
	}
	
	public void set(double value) {
		//System.out.println("Set solenoid");
			sol_controller.set(value);
	}

  public void stop() {
    sol_controller.set(0);
  }
	
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new MySpecialCommand());
  }
}

