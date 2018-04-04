package org.usfirst.frc.team6317.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class WaitTimer extends Command {
	
	double seconds;
	double startTime;
	Timer timing = new Timer();
	
	public WaitTimer(double seconds) {
		this.seconds = seconds;
	}
	
	@Override
	protected void initialize() {
		startTime = timing.getFPGATimestamp();
//		timing.delay(this.seconds);
	}
	
	@Override
	protected boolean isFinished() {
		return timing.getFPGATimestamp() - startTime > this.seconds;
	}

	@Override
	protected void end() {
		
	}
}
