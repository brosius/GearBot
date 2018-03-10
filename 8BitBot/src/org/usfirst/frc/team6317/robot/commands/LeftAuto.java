package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAuto extends CommandGroup {
	public LeftAuto() {
		// Lowers the Piston
		addSequential(new SolenoidShift(4));
		// Drives the Robot to the auto line
		addSequential(new DriveFor(110, 0.5));
		addSequential(new TurnFor(Direction.RIGHT, 60));
		addSequential(new DriveUntil(30, 0.5));
		// Fires the piston if the scale is correct
		addSequential(new SolenoidShift(5));
	}
}
