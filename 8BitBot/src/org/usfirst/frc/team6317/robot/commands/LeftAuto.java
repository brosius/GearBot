package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAuto extends CommandGroup {
	// Autonomous for the left starting zone for the left switch
	public LeftAuto() {
		// Lowers the piston at the start of the autonomous period
		addSequential(new SolenoidShift(4));
		// Drives the robot forward to the auto line
		addSequential(new DriveFor(110, 0.5));
		// Turns the robot to be parallel with the switch
		addSequential(new TurnFor(Direction.RIGHT, 60));
		// Drives the robot to flush with the switch
		addSequential(new DriveUntil(30, 0.5));
		// Fires the piston if the scale is correct
		addSequential(new SolenoidShift(() -> Direction.fromChar(Robot.gameData.charAt(0)), 5));
	}
}
