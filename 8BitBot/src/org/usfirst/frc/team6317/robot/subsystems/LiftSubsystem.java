package org.usfirst.frc.team6317.robot.subsystems;

import org.usfirst.frc.team6317.robot.RobotMap;
import org.usfirst.frc.team6317.robot.commands.DefaultLiftCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {
	// Initializes the lift motors
	public SpeedController liftMotor = new Victor(RobotMap.Motors.LIFT_MOTOR);
	public SpeedController pivotArm = new Victor(RobotMap.Motors.PIVOT_ARM_MOTOR);

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DefaultLiftCommand());
	}
	
	/**
	 * Allows for lifting of the lift during TeleOp
	 * @param speed The power applied to the lift motor
	 */
	public void setLift(double speed) {
		liftMotor.set(speed);
	}
	
	/**
	 * Allows for the retraction and extending of the clamp
	 * @param speed The power applied to the clamp motor
	 */
	public void setPivot(double speed) {
		pivotArm.set(speed);
	}
}
