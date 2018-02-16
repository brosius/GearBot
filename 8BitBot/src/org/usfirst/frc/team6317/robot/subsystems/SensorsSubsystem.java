package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SensorsSubsystem extends Subsystem {
	public AnalogInput distanceSensorOne = new AnalogInput(RobotMap.AnalogInputs.DISTANCE_SENSOR_ONE);
	
	@Override
	protected void initDefaultCommand() {}
	
	public double getDistanceCenti() {
		double volts = distanceSensorOne.getVoltage();
		double millivolts = volts * 1000;
		double centimeters = millivolts / 4.9;
		
		return centimeters;
	}
}
