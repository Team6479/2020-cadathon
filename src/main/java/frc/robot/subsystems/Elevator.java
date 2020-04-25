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
  private final DigitalInput plateLimitSwitch = new DigitalInput(Constants.ElevatorConstants.PLATE_LIMIT_SWITCH);
  private final DigitalInput topLimitSwitch = new DigitalInput(Constants.ElevatorConstants.TOP_LIMIT_SWITCH);
  private final DigitalInput bottomLimitSwitch = new DigitalInput(Constants.ElevatorConstants.BOTTOM_LIMIT_SWITCH);

  private boolean canDescend = true;
  
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

  public void move(double speed) {
    frontMotor.set(ControlMode.PercentOutput, speed);
  }

  public void stop() { 
    frontMotor.set(ControlMode.PercentOutput, 0);
  }
  
  public boolean isPlateSwitchPressed() {
    return !plateLimitSwitch.get();
  }

  public boolean isTopSwitchPressed() {
    return !topLimitSwitch.get();
  }

  public boolean isBottomSwitchPressed() {
    return !bottomLimitSwitch.get();
  }

  public void toggleCanDescend(){
    canDescend = !canDescend;
  }

  public boolean canDescend(){
    return canDescend;
  }

  public void setCanDescend(boolean canDesc){
    canDescend = canDesc;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
