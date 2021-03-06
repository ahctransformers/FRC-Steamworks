package org.usfirst.frc.team6584.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ChaChaLeft extends CommandGroup {

    public ChaChaLeft() {
    	addSequential(new AutoMoveToDistance(1.0,76.0));
    	addSequential(new AutoSwerve(1.0,-45.0));
    	addSequential(new AutoMoveToDistance(1.0,42.0));
    	addSequential(new WaitCommand(1.0));
    	addSequential(new AutoMoveToDistance(-1.0,42.0));
    	addSequential(new AutoSwerve(1.0,45.0));
    	addSequential(new AutoMoveToDistance(1.0,42.0));
    	
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
