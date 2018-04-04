package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.commands.DefaultDriveCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	// Initializes speed controllers for the motors
	public SpeedController leftDriveOne = new Victor(RobotMap.Motors.LEFT_DRIVE_ONE);
	public SpeedController leftDriveTwo = new Victor(RobotMap.Motors.LEFT_DRIVE_TWO);
	public SpeedController rightDriveOne = new Victor(RobotMap.Motors.RIGHT_DRIVE_ONE);
	public SpeedController rightDriveTwo = new Victor(RobotMap.Motors.RIGHT_DRIVE_TWO);
	
	{
		// Inverts the left motors
		// Allows for all motors to drive in the same direction
		leftDriveOne.setInverted(true);
		leftDriveTwo.setInverted(true);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DefaultDriveCommand());
	}
	
	/**
	 * Allows for driving forward during TeleOp
	 * @param speed The speed applied to both the left and the right motors
	 */
	public void drive(double speed) {
		drive(speed, speed);
	}
	
	/**
	 * Allows for normal driving during TeleOp
	 * @param leftSpeed The power applied to the left motors
	 * @param rightSpeed The power applied to the right motors
	 */
	public void drive(double leftSpeed, double rightSpeed) {
		leftDriveOne.set(leftSpeed * 0.825);
		leftDriveTwo.set(leftSpeed * 0.825);
		rightDriveOne.set(rightSpeed);
		rightDriveTwo.set(rightSpeed);
	}
	
//	public void backDrive(double leftSpeed, double rightSpeed, double rightModifier) {
//		leftDriveOne.set(leftSpeed);
//		leftDriveTwo.set(leftSpeed);
//		rightDriveOne.set(rightSpeed * rightModifier);
//		rightDriveTwo.set(rightSpeed * rightModifier);
//	}
	
	/**
	 * Allows for driving backwards during autonomous
	 * @param leftSpeed The power applied to the left motors
	 * @param rightSpeed The power applied to the right motors
	 */
	public void backDrive(double leftSpeed, double rightSpeed) {
		leftDriveOne.set(leftSpeed);
		leftDriveTwo.set(leftSpeed);
		rightDriveOne.set(rightSpeed);
		rightDriveTwo.set(rightSpeed);
	}
	
	/**
	 * Stops the robot
	 */
	public void stop() {
		drive(0);
	}
}
