package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6317.robot.Robot;

/**
 *
 */
public class DriveUntil extends Command {
	private final double centimetersToTravelTo, speed;
	
	public DriveUntil(double centimeters) {
		requires(Robot.DriveSubsystem);
		requires(Robot.SensorSubsystem);
		centimetersToTravelTo = centimeters;
		this.speed = 0.5;
	}
	
	public DriveUntil(double centimeters, double speed) {
		requires(Robot.DriveSubsystem);
		requires(Robot.SensorSubsystem);
		centimetersToTravelTo = centimeters;
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		if (!isFinished()) Robot.DriveSubsystem.backDrive(this.speed, 0.87);
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
