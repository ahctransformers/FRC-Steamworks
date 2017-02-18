package org.usfirst.frc.team6584.robot.subsystems;

import org.usfirst.frc.team6584.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RollyPolly extends Subsystem {

	
	public SpeedController motor1;
	
	public RollyPolly() {
		motor1= new Spark(RobotMap.motor1);
	}
	
	public void climbRope() {
		motor1.set(1.0);
	}
	public void stopRope()  {
		motor1.set(0.0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

