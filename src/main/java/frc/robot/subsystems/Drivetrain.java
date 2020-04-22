/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.team6479.lib.subsystems.TankDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase implements TankDrive{
  
  private TalonFX leftFront;
  private TalonFX leftBack;
  private TalonFX rightFront;
  private TalonFX rightBack;

  public Drivetrain() {
    // construct motors
    leftFront = new TalonFX(DrivetrainConstants.LEFT_FRONT);
    leftBack = new TalonFX(DrivetrainConstants.LEFT_BACK);
    rightFront = new TalonFX(DrivetrainConstants.RIGHT_FRONT);
    rightBack = new TalonFX(DrivetrainConstants.RIGHT_BACK);

    // set motors to factory defaults on startup
    leftFront.configFactoryDefault();
    leftBack.configFactoryDefault();
    rightFront.configFactoryDefault();
    rightBack.configFactoryDefault();

    // back motors follow front motors
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

    // set neutral modes
    leftFront.setNeutralMode(NeutralMode.Brake);
    leftBack.setNeutralMode(NeutralMode.Brake);
    rightFront.setNeutralMode(NeutralMode.Brake);
    rightBack.setNeutralMode(NeutralMode.Brake);

    // set correct motors to be inverted
    leftFront.setInverted(false);
    leftBack.setInverted(false);
    rightFront.setInverted(true);
    rightBack.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Stops the drivetrain
   */
  @Override
  public void stop() {
    leftFront.set(ControlMode.PercentOutput, 0);
    rightFront.set(ControlMode.PercentOutput, 0);
  }

  /**
   * Set arcade drive values to motor
   * @param forward Percent value to move forward
   * @param turn Percent value to turn
   */
  @Override
  public void arcadeDrive(double forward, double turn) {
    leftFront.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, +turn);
    rightFront.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, -turn);
  }

  /**
   * Set tank drive values to motor
   * @param leftSpeed Percent speed of the left side
   * @param rightSpeed Percent speed of the right side
   */
  @Override
  public void tankDrive(double leftSpeed, double rightSpeed) {
    leftFront.set(ControlMode.PercentOutput, leftSpeed);
    rightFront.set(ControlMode.PercentOutput, rightSpeed);
  }
}
