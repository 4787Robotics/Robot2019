package org.usfirst.frc.team4787.robot.commands;

import org.usfirst.frc.team4787.robot.Robot;
import org.usfirst.frc.team4787.robot.OI;
import org.usfirst.frc.team4787.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrainWithJoystick extends Command {

    public DriveTrainWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.m_driveTrain.drive(Robot.m_OI.getJoystick());
    	System.out.println("Executing");
    	Robot.m_driveTrain.drive(OI.getRy(),OI.getRx(),OI.getRz());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_driveTrain.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
