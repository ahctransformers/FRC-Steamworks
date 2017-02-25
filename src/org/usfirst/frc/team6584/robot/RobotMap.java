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
    public static final int motorLeft1 = 0;
    public static final int motorRight1 = 2;
	public static final int motorLeft2 = 1;
	public static final int motorRight2 = 3;
	public static final int motor1=4;
	//motor1 is for the winch system mentioned in the RollyPolly command//
	
	// DIO Ports
	public static final int encoderA=0;
	public static final int encoderB=1;
	
	// 0 and 1 is right encoder
	// 2 and 3 is left encoder
	
	// two encoders that someone decided to take off, *throws some salt*//

	
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
