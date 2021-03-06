package org.usfirst.frc.team6584.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6584.robot.Robot;

/**
 *
 */
public class StopDrivetrain extends Command {
	

    public StopDrivetrain() {
        // Use requires() here to declare subsystem dependencies
    		requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.drivetrain.moveArcade(0.0,0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
