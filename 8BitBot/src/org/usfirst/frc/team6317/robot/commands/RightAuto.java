package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAuto extends CommandGroup {
	public RightAuto() {
		// Lowers the Piston
		addSequential(new SolenoidShift(4));
		// Drives the Robot to the auto line
		addSequential(new DriveFor(110, 0.5));
		addSequential(new TurnFor(Direction.LEFT, 60));
		addSequential(new DriveUntil(30, 0.65));
		// Fires the piston if the scale is correct
		addSequential(new SolenoidShift(6));
	}
}
