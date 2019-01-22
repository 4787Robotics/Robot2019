package org.usfirst.frc.team4787.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4787.robot.Robot;

/**
 *
 */
public class OuttakeBox extends Command {

    public OuttakeBox() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_flywheel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_flywheel.setSpeed(-1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_flywheel.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
