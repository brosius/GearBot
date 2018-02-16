package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6317.robot.Robot;

/**
 *
 */
public class DriveUntil extends Command {
	private final double centimetersToTravelTo;
	
	public DriveUntil(double centimeters) {
		requires(Robot.DriveSubsystem);
		requires(Robot.SensorSubsystem);
		centimetersToTravelTo = centimeters;
	}

	@Override
	protected void initialize() {
		if (!isFinished()) Robot.DriveSubsystem.drive(0.5);
	}

	@Override
	protected boolean isFinished() {
		return Robot.SensorSubsystem.getDistanceCenti() <= centimetersToTravelTo;
	}

	@Override
	protected void end() {
		Robot.DriveSubsystem.stop();
	}
}
