/*----------------------------------------------------------------------------*/
/* CopymotorRight (c) 2019 FIRST. All Rights Reserved.                             */
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

public class Drivetrain extends SubsystemBase implements TankDrive {
  
  private TalonFX motorLeftFront;
  private TalonFX motorLeftBack;
  private TalonFX motorRightFront;
  private TalonFX motorRightBack;

  public Drivetrain() {
    // construct motors
    motorLeftFront = new TalonFX(DrivetrainConstants.MOTOR_LEFT_FRONT);
    motorLeftBack = new TalonFX(DrivetrainConstants.MOTOR_LEFT_BACK);
    motorRightFront = new TalonFX(DrivetrainConstants.MOTOR_RIGHT_FRONT);
    motorRightBack = new TalonFX(DrivetrainConstants.MOTOR_RIGHT_BACK);

    // set motors to factory defaults on startup
    motorLeftFront.configFactoryDefault();
    motorLeftBack.configFactoryDefault();
    motorRightFront.configFactoryDefault();
    motorRightBack.configFactoryDefault();

    // back motors follow front motors
    motorLeftBack.follow(motorLeftFront);
    motorRightBack.follow(motorRightFront);

    // set neutral modes
    motorLeftFront.setNeutralMode(NeutralMode.Brake);
    motorLeftBack.setNeutralMode(NeutralMode.Brake);
    motorRightFront.setNeutralMode(NeutralMode.Brake);
    motorRightBack.setNeutralMode(NeutralMode.Brake);

    // set correct motors to be inverted
    motorLeftFront.setInverted(false);
    motorLeftBack.setInverted(false);
    motorRightFront.setInverted(true);
    motorRightBack.setInverted(true);
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
    motorLeftFront.set(ControlMode.PercentOutput, 0);
    motorRightFront.set(ControlMode.PercentOutput, 0);
  }

  /**
   * Set arcade drive values to motor
   * @param forward Percent value to move forward
   * @param turn Percent value to turn
   */
  @Override
  public void arcadeDrive(double forward, double turn) {
    motorLeftFront.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, +turn);
    motorRightFront.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, -turn);
  }

  /**
   * Set tank drive values to motor
   * @param motorLeftSpeed Percent speed of the left side
   * @param motorRightSpeed Percent speed of the right side
   */
  @Override
  public void tankDrive(double leftSpeed, double rightSpeed) {
    motorLeftFront.set(ControlMode.PercentOutput, leftSpeed);
    motorRightFront.set(ControlMode.PercentOutput, rightSpeed);
  }
}
