
package org.usfirst.frc.team6584.robot.subsystems;

import org.usfirst.frc.team6584.robot.RobotMap;
import org.usfirst.frc.team6584.robot.commands.GucciStick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestBoard extends Subsystem {
	
	
	VictorSP motorLeft1;
	VictorSP motorLeft2;
	VictorSP motorRight1;
	VictorSP motorRight2;
	
	RobotDrive drivetrain;
	
	public TestBoard() {
		motorLeft1 = new VictorSP(RobotMap.motorLeft1);
		motorLeft2= new VictorSP(RobotMap.motorLeft2);
		motorRight1= new VictorSP(RobotMap.motorRight1);
		motorRight2= new VictorSP(RobotMap.motorRight2);
		drivetrain= new RobotDrive(motorLeft1, motorLeft2, motorRight1, motorRight2);
		
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

