package org.usfirst.frc.team6584.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ChaChaRight extends CommandGroup {

    public ChaChaRight() {
    	
    	addSequential(new AutoMoveToDistance(0.5,76.0));
    	addSequential(new AutoSwerve(-0.5,-45.0));
    	addSequential(new AutoMoveToDistance(0.5,42.0));
    	addSequential(new WaitCommand(1.0));
    	addSequential(new AutoMoveToDistance(-0.5,42.0));
    	addSequential(new AutoSwerve(0.5,45.0));
    	addSequential(new AutoMoveToDistance(0.5,42.0));
    	
//    	addSequential(new AutoMoveToDistance(0.4,58.0));
//    	addSequential(new AutoSwerve(0.4,45.0));
//    	addSequential(new AutoMoveToDistance(0.4,42.0));
//    	addSequential(new WaitCommand(1.0));
//    	addSequential(new AutoMoveToDistance(-0.4,42.0));
//    	addSequential(new AutoSwerve(0.4,-42.0));
//    	addSequential(new AutoMoveToDistance(0.4,24.0));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
