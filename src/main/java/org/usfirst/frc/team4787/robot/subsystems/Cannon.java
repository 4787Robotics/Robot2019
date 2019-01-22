package org.usfirst.frc.team4787.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Jaguar;
import org.usfirst.frc.team4787.robot.RobotMap;

/**
 *
 */
public class Cannon extends SolenoidSubsystem {

  private Jaguar angle_motor;

  public Cannon() {
    super(RobotMap.solenoid_pin);

    angle_motor = new Jaguar(RobotMap.cannon_pin);
  }

  public void rotate(double value) {
	 angle_motor.set(value);
  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new MySpecialCommand());
    /*
     * solenoid.set(true);
    try {
			Thread.sleep(300);
		} catch (Exception e) {
		
    }
    solenoid.set(false);
    */
  }
}

