package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightAutoScale extends CommandGroup {
	public RightAutoScale() {
		// Drive For (-110)
		addSequential(new DriveFor(-110, 0.65));
		// If R -75 else 0
		addSequential(new TurnFor(() -> Direction.fromChar(Robot.gameData.charAt(0)), (dir) -> dir == Direction.RIGHT ? -75 : 0));
		// If R lift and drop and such
//		if(direction.right)
//		addSequential(new DriveUntil(30, 0.25);
		addSequential(new TurnFor(() -> Direction.fromChar(Robot.gameData.charAt(0)) , (dir) -> dir == Direction.RIGHT ? 75 : 0));
		addSequential(new DriveFor(-110, 0.65));
	}
}
