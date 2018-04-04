package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class TurnFor extends Command {
	private final String direction;
	private final int inches;

	public TurnFor(String turnDirection , int turning) {
		this.direction = turnDirection;
		this.inches = turning;
	}
	
	@Override
	protected void initialize() {
		if (!isFinished() && this.direction.equalsIgnoreCase("R")) {
			Robot.DriveSubsystem.drive(0, 0.2);
		} else if (!isFinished() && this.direction.equalsIgnoreCase("L")) {
			Robot.DriveSubsystem.drive(0.2, 0);
		}
	}

	@Override
	protected boolean isFinished() {
		Encoder leftEnc = Robot.SensorSubsystem.leftEncoder;
		Encoder rightEnc = Robot.SensorSubsystem.rightEncoder;
		if (this.direction == "L") {
			return Robot.SensorSubsystem.encoderDistanceDone(leftEnc, this.inches);
		} else if (this.direction == "R") {
			return Robot.SensorSubsystem.encoderDistanceDone(rightEnc, this.inches);
		} else {
			return false;
		}
	}

	@Override
	protected void end() {
		Robot.DriveSubsystem.stop();
	}
}
