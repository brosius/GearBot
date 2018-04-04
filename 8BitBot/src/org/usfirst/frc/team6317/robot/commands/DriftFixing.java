package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriftFixing extends Command {
	public DriftFixing() {
		this.requires(Robot.DriveSubsystem);
		this.requires(Robot.SensorSubsystem);
	}
	
	@Override
	protected void initialize() {
		Robot.SensorSubsystem.resetEncoders();
		Robot.DriveSubsystem.drive(-0.75);
	}
	
	@Override
	protected boolean isFinished() {
		Encoder left = Robot.SensorSubsystem.leftEncoder;
		Encoder right = Robot.SensorSubsystem.rightEncoder;
		SmartDashboard.putNumber("Left Encoder", left.getDistance());
		SmartDashboard.putNumber("Right Encoder", right.getDistance());
		return Robot.SensorSubsystem.encoderDistanceDone(left, -170) || 
				Robot.SensorSubsystem.encoderDistanceDone(right, -170);
	}
	
	@Override
	protected void end() {
		Robot.DriveSubsystem.stop();
	}
}
