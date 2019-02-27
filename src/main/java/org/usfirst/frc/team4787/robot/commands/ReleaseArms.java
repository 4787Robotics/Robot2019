/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4787.robot.commands;

import org.usfirst.frc.team4787.robot.Robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

public class ReleaseArms extends Command {
  public ReleaseArms() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_armball);
    requires(Robot.m_armflywheel);
    requires(Robot.m_armhatch);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_armball.setMagnet(Relay.Value.kOn);
    Robot.m_armhatch.setMagnet(Relay.Value.kOn);
    Robot.m_armflywheel.setMagnet(Relay.Value.kOn);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_OI.getJoystick().getRawButtonPressed(8)){
      Robot.m_armhatch.setMagnet(Relay.Value.kOff);
      Robot.m_armflywheel.setMagnet(Relay.Value.kOff);
      Thread magnetThread = new Thread() {
        public void run() {
          try {
            // 3 second wait
            Thread.sleep(3000);
            Robot.m_armball.setMagnet(Relay.Value.kOff);
          }
          catch(InterruptedException v) {
            System.out.print(v);
          }
        }
      };
      magnetThread.start();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
