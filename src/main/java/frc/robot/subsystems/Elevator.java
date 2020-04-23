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

public class Elevator extends SubsystemBase {
  
  private TalonFX frontMotor;
  private TalonFX backMotor;
  private final DigitalInput limitSwitch = new DigitalInput(Constants.ElevatorConstants.LIMIT_SWITCH);
  
  /**
   * Creates a new Elevator.
   */
  public Elevator() {

    frontMotor = new TalonFX(Constants.ElevatorConstants.MOTOR_FRONT);
    backMotor = new TalonFX(Constants.ElevatorConstants.MOTOR_BACK);

    frontMotor.configFactoryDefault();
    backMotor.configFactoryDefault();

    frontMotor.setNeutralMode(NeutralMode.Brake);
    backMotor.setNeutralMode(NeutralMode.Brake);

    frontMotor.setInverted(false);
    backMotor.setInverted(false);

    backMotor.follow(frontMotor);

  }

  public void ascend(){
    frontMotor.set(ControlMode.PercentOutput, 0.5);
  }

  public void descend(){
    frontMotor.set(ControlMode.PercentOutput, -0.5);
  }

  public void stop(){
    frontMotor.set(ControlMode.PercentOutput, 0);
  }
  
  public boolean isSwitchPressed(){
    return !limitSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
