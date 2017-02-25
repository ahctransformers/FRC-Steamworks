package org.usfirst.frc.team6584.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.team708.util.Gamepad;
import org.usfirst.frc.team6584.robot.commands.StopDrivetrain;
import org.usfirst.frc.team6584.robot.commands.rollypolly.RollyUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//this assigns the buttons lol//
	public final static Gamepad DRIVER_GAMEPAD = new Gamepad(RobotMap.driverGamepad);
	
	// bUTTON aSSIGNMENTS
	private static final int ROLLYPOLLY_ON_BUTTON = 6;
	private static final int ROLLYPOLLY_STOP_BUTTON = 4;
	private static final int STOP_MOVING_BUTTON = 2;
	
	
	private static final Button STOP_MOVING = new JoystickButton(DRIVER_GAMEPAD, STOP_MOVING_BUTTON);
	private static final Button ROLLYPOLLY_ON = new JoystickButton(DRIVER_GAMEPAD, ROLLYPOLLY_ON_BUTTON);
	private static final Button ROLLYPOLLY_STOP = new JoystickButton(DRIVER_GAMEPAD,ROLLYPOLLY_STOP_BUTTON);
	
	public OI() {
		STOP_MOVING.whenPressed(new StopDrivetrain());
		ROLLYPOLLY_ON.whenPressed(new RollyUp());
		
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

