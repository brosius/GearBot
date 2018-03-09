package org.usfirst.frc.team6317.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team6317.robot.Direction;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleAutonomous extends CommandGroup {
	public MiddleAutonomous() {
			addSequential(new SolenoidShift(1));
			addSequential(new DriveFor(50, 0.4, 0.87));//last number is right speed modifier
			addSequential(new DriveFor(17, 0.4, 0.87));
			if (Robot.gameData.length() > 0) {
				addSequential(new TurnFor(() -> Direction.fromChar(Robot.gameData.charAt(0)).opposite(), 24));
				addSequential(new TurnFor(() -> Direction.fromChar(Robot.gameData.charAt(0)).opposite(), 24));
			}
			addSequential(new DriveFor(35, 0.2, 0.87));
			addSequential(new SolenoidShift(0));
			
			//addSequential(new DriveUntil(30, 0.2));
	}
}
