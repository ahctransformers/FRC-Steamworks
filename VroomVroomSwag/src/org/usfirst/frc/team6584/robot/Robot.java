
package org.usfirst.frc.team6584.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team6584.robot.commands.autonomous.AutoMove;
import org.usfirst.frc.team6584.robot.commands.autonomous.AutoMoveToDistance;
import org.usfirst.frc.team6584.robot.commands.autonomous.AutoSwerve;
import org.usfirst.frc.team6584.robot.commands.autonomous.ChaChaLeft;
import org.usfirst.frc.team6584.robot.commands.autonomous.ChaChaRight;
import org.usfirst.frc.team6584.robot.commands.autonomous.PegAndStop;
import org.usfirst.frc.team6584.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6584.robot.subsystems.RollyPolly;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain drivetrain = new DriveTrain();
	public static OI oi;
	public static final RollyPolly winch =new RollyPolly();
	
	// RollyPolly is the command for the spinning winch. Goes back and forth. That's literally it. There's literally a command for it if you look hard enough//

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        createAutoChooser();
        
        SmartDashboard.putData("Auto mode", chooser);
        SmartDashboard.putData(drivetrain);
        
        CameraServer.getInstance().startAutomaticCapture(0);
        CameraServer.getInstance().startAutomaticCapture(1);
        //we have 2 cameras. I guess you could call us...BICAMERAL(government joke)//
    }
    
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
	 drivetrain.SendToDashboard();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        drivetrain.SendToDashboard();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drivetrain.SendToDashboard();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void createAutoChooser() {
    	chooser.addDefault("Do Nothing", new AutoMove(0.0, 0.0));
        chooser.addObject("Move 2 Peg", new AutoMoveToDistance(1.0, 108.0));
        chooser.addObject("2016memes", new AutoSwerve(1.0,90.0));
        chooser.addObject("Move 2 Base", new AutoMoveToDistance(1.0,117.6));
        chooser.addObject("ChaChaLeft", new ChaChaLeft());
        chooser.addObject("ChaChaRight", new ChaChaRight());
        chooser.addObject("Peg and Stop", new PegAndStop());
        // smartdashboard has a chooser thingy so you can choose which commands you want for autonomous//
    }
}
