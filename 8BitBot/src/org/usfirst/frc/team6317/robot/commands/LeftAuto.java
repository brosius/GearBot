package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftAuto extends CommandGroup {
	public LeftAuto() {
		// Initializes the needed Subsystems
		this.requires(Robot.DriveSubsystem);
		this.requires(Robot.SensorSubsystem);
		this.requires(Robot.Shifter);
		
		// Lowers the Piston
		addSequential(new SolenoidShift(4));
		// Drives the Robot to the auto line
		addSequential(new DriveUntil(30, 0.65));
		// Fires the piston if the scale is correct
		if (Robot.gameData.charAt(0) == 'L')
			addSequential(new SolenoidShift(5));
	}
}
