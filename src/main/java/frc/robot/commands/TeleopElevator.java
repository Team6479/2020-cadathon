/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.team6479.lib.wpioverride.XboxController;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class TeleopElevator extends CommandBase {
  private Elevator elevator;
  private final DoubleSupplier speed;
  private boolean switchPressed;
  
  /**
   * Creates a new TeleopElevator.
   */
  public TeleopElevator(Elevator elevator, DoubleSupplier speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.elevator = elevator;
    addRequirements(elevator);

    this.speed = speed;
    switchPressed = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //do we have to reset the limit switches here?
    elevator.setCanDescend(true);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(speed.getAsDouble() < 0) {

      if(!elevator.isBottomSwitchPressed() && elevator.canDescend()) {
        
        if(!switchPressed && elevator.isPlateSwitchPressed()){
          elevator.stop();
          elevator.setCanDescend(false);
          switchPressed = true;
        } else {
          elevator.move(speed.getAsDouble());
          switchPressed = elevator.isPlateSwitchPressed();
        }

      } else {
        elevator.stop();
      }
      

    } else {

      elevator.setCanDescend(true);
      if(!elevator.isTopSwitchPressed()) {
        elevator.move(speed.getAsDouble());
      } else {
        elevator.stop();
      }

    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
