/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

  private DoubleSolenoid armLeft;
  private DoubleSolenoid armRight;

  private TalonSRX rollersLeft;
  private TalonSRX rollersRight;

  private DigitalInput plateSensor;
  
  public Intake() {
    armLeft = new DoubleSolenoid(IntakeConstants.INTAKE_ARM_LEFT_1, IntakeConstants.INTAKE_ARM_LEFT_2);
    armRight = new DoubleSolenoid(IntakeConstants.INTAKE_ARM_RIGHT_1, IntakeConstants.INTAKE_ARM_RIGHT_2);

    rollersLeft = new TalonSRX(IntakeConstants.INTAKE_ROLLERS_LEFT);
    rollersRight = new TalonSRX(IntakeConstants.INTAKE_ROLLERS_RIGHT);

    plateSensor = new DigitalInput(IntakeConstants.PLATE_SENSOR);

    rollersLeft.configFactoryDefault();
    rollersRight.configFactoryDefault();

    rollersLeft.setNeutralMode(NeutralMode.Brake);
    rollersRight.setNeutralMode(NeutralMode.Brake);
    
    // Guesses at correct direction of motors, one should be inverted
    rollersLeft.setInverted(true);
    rollersRight.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void openArms() {
    armLeft.set(Value.kForward);
    armRight.set(Value.kForward);
  }

  public void closeArms() {
    armLeft.set(Value.kReverse);
    armRight.set(Value.kReverse);
  }

  public void rollersForward() {
    rollersLeft.set(ControlMode.PercentOutput, 1.0);
    rollersRight.set(ControlMode.PercentOutput, 1.0);
  }

  public void rollersReverse() {
    rollersLeft.set(ControlMode.PercentOutput, -1.0);
    rollersRight.set(ControlMode.PercentOutput, -1.0);
  }

  public void rollersOff() {
    rollersLeft.set(ControlMode.PercentOutput, 0.0);
    rollersRight.set(ControlMode.PercentOutput, 0.0);
  }

  public boolean hasPlate() {
    return plateSensor.get();
  }
}
