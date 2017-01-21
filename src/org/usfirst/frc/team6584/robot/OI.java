package org.usfirst.frc.team6584.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.team708.util.Gamepad;
import org.usfirst.frc.team6584.robot.commands.SwagMove;
import org.usfirst.frc.team6584.robot.commands.VeganWater;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public final static Gamepad DRIVER_GAMEPAD = new Gamepad(RobotMap.driverGamepad);
	
	private static final int FORWARD_BUTTON = Gamepad.button_Y;
	private static final int BACKWARD_BUTTON = Gamepad.button_A;
	private static final int STOP_MOVING_BUTTON = Gamepad.button_B;
	
	private static final Button FORWARD = new JoystickButton(DRIVER_GAMEPAD, FORWARD_BUTTON);
	private static final Button BACKWARD = new JoystickButton(DRIVER_GAMEPAD, BACKWARD_BUTTON);
	private static final Button STOP_MOVING = new JoystickButton(DRIVER_GAMEPAD, STOP_MOVING_BUTTON);
	
	public OI() {
		FORWARD.whenPressed(new SwagMove(1.0));
		BACKWARD.whenPressed(new SwagMove(-1.0));
		STOP_MOVING.whenPressed(new VeganWater());
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

