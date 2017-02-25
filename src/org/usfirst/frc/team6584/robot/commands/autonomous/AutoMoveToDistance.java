
package org.usfirst.frc.team6584.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6584.robot.Robot;

/**
 * Drives to a value set during autonomous
 * @author Yvette Kiptoo
 * @params speedforward, speedrotation
 */
public class AutoMoveToDistance extends Command {
	private static final double kAngleSetpoint = 0.0;
	private static final double kP = 0.05; // propotional turning constant
	
	double swagSpeed;
	double swagTurn;
	double swagDistance;
	
	double turningValue;

    public AutoMoveToDistance(double swagSpeed,double swagDistance) {
        // Use requires() here to declare subsystem dependencies
    		requires(Robot.drivetrain);
    		
    		this.swagSpeed = swagSpeed;
    		this.swagTurn = 0.0;
    		this.swagDistance = swagDistance;  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoder();
    	Robot.drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	turningValue = (kAngleSetpoint - Robot.drivetrain.getGucciAngle()) * kP;
    
    	Robot.drivetrain.moveArcade(swagSpeed, -turningValue);	// Negative when on actual robot
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(Robot.drivetrain.getSwagDistance()) >= Math.abs(swagDistance);
    	
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
