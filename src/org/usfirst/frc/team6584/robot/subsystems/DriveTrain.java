
package org.usfirst.frc.team6584.robot.subsystems;

import org.usfirst.frc.team6584.robot.RobotMap;
import org.usfirst.frc.team6584.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	Encoder encoder;
	double distancePerPulse;
	
	ADXRS450_Gyro gyro;
	
	SpeedController motorLeft1;
	SpeedController motorRight1;
	SpeedController motorLeft2;
	SpeedController motorRight2;
	
	RobotDrive drivetrain;
	
	public DriveTrain() {
		motorLeft1 = new Spark(RobotMap.motorLeft1);
		motorRight1= new Spark(RobotMap.motorRight1);
		motorLeft2 = new Spark(RobotMap.motorLeft2);
		motorRight2= new Spark(RobotMap.motorRight2);
		
		drivetrain= new RobotDrive(motorLeft1, motorLeft2, motorRight1, motorRight2);
		drivetrain.setSafetyEnabled(false);
		
		encoder=new Encoder(RobotMap.encoderA,RobotMap.encoderB);
	    //encoder.setReverseDirection(true);
		distancePerPulse= (0.0527777778);
		encoder.setDistancePerPulse(distancePerPulse);
		
		gyro=new ADXRS450_Gyro();
	}
	
	public void SendToDashboard() {
		SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
		SmartDashboard.putNumber("Gyro angle",getGucciAngle());
		SmartDashboard.putNumber("Encoder distance", getSwagDistance());
		SmartDashboard.putNumber("Encoder rate", getWheelRate());
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void moveTank(double motorLeft,double motorRight) {
		drivetrain.tankDrive(motorLeft, motorRight);
	}
	
	public void moveArcade(double throttle, double rotate) {
		drivetrain.arcadeDrive(throttle, rotate);
		
	}
	
	public void setMax(double max) {
		drivetrain.setMaxOutput(max);
	}

	public double getWheelRate() {
		return encoder.getRate();
	}
	
	public double getSwagDistance(){
		return encoder.getDistance();
	}
	
	public void resetEncoder() {
		encoder.reset();
	}
	
	public double getGucciAngle (){
		return gyro.getAngle();
	}
	
	public void resetGyro (){
		gyro.reset();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickDrive());
    }
}

