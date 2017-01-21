
package org.usfirst.frc.team6584.robot.subsystems;

import org.usfirst.frc.team6584.robot.RobotMap;
import org.usfirst.frc.team6584.robot.commands.GucciStick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	
	VictorSP motorLeft;
	VictorSP motorRight;
	
	RobotDrive drivetrain;
	
	public DriveTrain() {
		motorLeft = new VictorSP(RobotMap.motorLeft);
		motorRight= new VictorSP(RobotMap.motorRight);
		drivetrain= new RobotDrive(motorLeft, motorRight);
		
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void moveTank(double motorLeft,double motorRight) {
		drivetrain.tankDrive(motorLeft, motorRight);
	}
	
	public void moveArcade(double throttle, double rotate) {
		drivetrain.arcadeDrive(throttle, rotate);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GucciStick());
    }
}

