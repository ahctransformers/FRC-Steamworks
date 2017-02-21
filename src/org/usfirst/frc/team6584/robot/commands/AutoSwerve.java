package org.usfirst.frc.team6584.robot.commands;

import org.usfirst.frc.team6584.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSwerve extends Command {
	double swagTurnSpeed;
	double swAngle;
	
    public AutoSwerve(double swagTurnSpeed, double swAngle) {
    	this.swagTurnSpeed = swagTurnSpeed;
		this.swAngle = swAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetGyro();
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.moveArcade(swagTurnSpeed, swAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.drivetrain.getGucciAngle() >= swAngle;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.moveTank(0.0,0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
