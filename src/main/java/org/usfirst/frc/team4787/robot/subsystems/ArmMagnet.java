/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4787.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class ArmMagnet extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static Relay m_magnet;

  public ArmMagnet(int pin) {
    m_magnet = new Relay(pin);
  }

  // Relay.Value is an enum, we pass one of the values of the Relay.Value enum (i.e. kOn, kOff)
  // This value then sets the position of the electromagnet
  public void setMagnet(Relay.Value position) {
    m_magnet.set(position);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
