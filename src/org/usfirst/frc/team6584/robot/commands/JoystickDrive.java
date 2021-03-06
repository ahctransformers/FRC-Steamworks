package org.usfirst.frc.team6584.robot.commands;

import org.team708.util.Gamepad;
import org.usfirst.frc.team6584.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JoystickDrive extends Command {

    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.DRIVER_GAMEPAD.getButton(3)) {
    		Robot.drivetrain.setMax(.4);
    	} else {
    		Robot.drivetrain.setMax(1);
    	}
    	Robot.drivetrain.moveArcade(Robot.oi.DRIVER_GAMEPAD.getAxis(Gamepad.leftStick_Y), -Robot.oi.DRIVER_GAMEPAD.getAxis(Gamepad.leftStick_X));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
