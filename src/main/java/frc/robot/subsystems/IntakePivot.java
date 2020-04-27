/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakePivot extends SubsystemBase {
  
  private TalonFX motorLeft;
  private TalonFX motorRight;

  private DigitalInput sensorIn;
  private DigitalInput sensorOut;

  private Position position;

  public enum Position {
    IN, OUT;
    
  }
  
  /**
   * Creates a new IntakePivot.
   */
  public IntakePivot() {

    motorLeft = new TalonFX(Constants.IntakePivotConstants.MOTOR_LEFT);
    motorRight = new TalonFX(Constants.IntakePivotConstants.MOTOR_RIGHT);

    motorLeft.configFactoryDefault();
    motorRight.configFactoryDefault();

    motorLeft.setNeutralMode(NeutralMode.Brake);
    motorRight.setNeutralMode(NeutralMode.Brake);

    motorLeft.follow(motorRight);

    sensorIn = new DigitalInput(Constants.IntakePivotConstants.SENSOR_IN);
    sensorOut = new DigitalInput(Constants.IntakePivotConstants.SENSOR_OUT);

    position = Position.IN;

  }

  public void flipOut() {
    motorRight.set(ControlMode.PercentOutput, 0.5);
  }

  public void flipIn() {
    motorRight.set(ControlMode.PercentOutput, -0.5);
  }

  public void stop() {
    motorRight.set(ControlMode.PercentOutput, 0);
  }

  public Position getPosition() { 
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public boolean getSensorIn() { 
    return sensorIn.get();
  }

  public boolean getSensorOut() {
    return sensorOut.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
