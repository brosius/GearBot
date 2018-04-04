package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAutoScale extends CommandGroup {
	public LeftAutoScale() {
		// Drive For (-110)
		//addSequential(new DriveFor(-110, -0.75, 0.825, 1));
		addSequential(new LiftTime(2.5)); //raise
		addParallel(new LiftTime(5.0, 0.1)); //hold
	}
}
