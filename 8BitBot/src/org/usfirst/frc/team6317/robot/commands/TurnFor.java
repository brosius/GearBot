package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnFor extends Command {//TODO
	@Override
	protected void initialize() {
		if (!isFinished()) Robot.DriveSubsystem.drive(-0.2, 0.2);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.DriveSubsystem.stop();
	}
}
