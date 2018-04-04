package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidShift extends Command {

	public int state;
	
	public SolenoidShift(int stateIn) {
		this.requires(Robot.IntakeSystem);
		state = stateIn;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if(state == 0)
			Robot.Shifter.openArm();		
		if(state == 1)
			Robot.Shifter.closeArm();
		if(state == 2)
			Robot.Shifter.stopShift();
		if(state == 3)
			Robot.Shifter.firePiston();
		if(state == 4)
			Robot.Shifter.lowerPiston();
			

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
