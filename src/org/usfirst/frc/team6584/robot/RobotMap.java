package org.usfirst.frc.team6584.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
    public static final int driverGamepad = 0;
    public static final int operatorGamepad = 1;
    
	// For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    public static final int motorLeft1 = 1;
    public static final int motorLeft2 = 2;
    public static final int motorRight1 = 3;
    public static final int motorRight2 = 4;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
