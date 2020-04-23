/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.EndgameActuatorConstants;

public class EndgameActuator extends SubsystemBase {

  private Solenoid actuator;

  public EndgameActuator() {
    actuator = new Solenoid(EndgameActuatorConstants.ACTUATOR_SOLENOID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void toggle() {
    if (actuator.get()) {
      actuator.set(false);
    } else {
      actuator.set(true);
    }
  }
}
