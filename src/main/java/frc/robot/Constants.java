/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class ElevatorConstants {
        public static final int MOTOR_FRONT = 0;
        public static final int MOTOR_BACK = 1;
        public static final int CARRIAGE_MOTOR = 2;
        public static final int PLATE_LIMIT_SWITCH = 0;
        public static final int TOP_LIMIT_SWITCH = 1;
        public static final int BOTTOM_LIMIT_SWITCH = 2;
    }
    public static final class DrivetrainConstants {
        public final static int MOTOR_LEFT_FRONT = 0;
        public final static int MOTOR_LEFT_BACK = 0;
        public final static int MOTOR_RIGHT_FRONT = 0;
        public final static int MOTOR_RIGHT_BACK = 0;
    }
    public static final class EndgameActuatorConstants {
        public static final int ACTUATOR_SOLENOID = 0;
    }

    public static final class IntakeConstants {
        public static final int INTAKE_ARM_LEFT_1 = 0;
        public static final int INTAKE_ARM_LEFT_2 = 0;
        public static final int INTAKE_ARM_RIGHT_1 = 0;
        public static final int INTAKE_ARM_RIGHT_2 = 0;

        public static final int INTAKE_ROLLERS_LEFT = 0;
        public static final int INTAKE_ROLLERS_RIGHT = 0;

        public static final int PLATE_SENSOR = 0;
    }

    public static final class IntakePivotConstants {
        public static final int MOTOR_RIGHT = 0;
        public static final int MOTOR_LEFT = 1;

        public static final int SENSOR_IN = 0;
        public static final int SENSOR_OUT = 1;
    }
}
