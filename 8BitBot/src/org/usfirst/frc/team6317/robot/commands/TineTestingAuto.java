package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TineTestingAuto extends CommandGroup {
	public TineTestingAuto() {
		
	}
	
	@Override
	protected void initialize() {
		addSequential(new MoveTines(true));
	}
}
