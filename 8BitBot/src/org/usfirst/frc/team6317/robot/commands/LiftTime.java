package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LiftTime extends Command {
	private double seconds, startTime, power;
	private Timer timing;
	
	public LiftTime(double seconds, double power) {
		this.requires(Robot.LiftSubsystem);
		this.seconds = seconds;
		timing = new Timer();
		this.power = Math.abs(power);
	}
	
	public LiftTime(double seconds) {
		this(seconds, 1.0);
	}
	
	@Override
	protected void initialize() {
		startTime = Timer.getFPGATimestamp();
		Robot.LiftSubsystem.setLift(-1.0 * this.power);
	}
	
	@Override
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() - startTime >= this.seconds;
	}
	
	@Override
	protected void end() {
		Robot.LiftSubsystem.setLift(0);
	}
}
