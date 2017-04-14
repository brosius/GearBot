package org.usfirst.frc.team6317.robot.sensors;
import edu.wpi.first.wpilibj.SampleRobot;


public class Ultrasonic extends SampleRobot 
{

	Ultrasonic ultra = new Ultrasonic(1,1); // creates the ultra object and assigns ultra to be an ultrasonic sensor which uses DigitalOutput 1 for 
        public Ultrasonic(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	// the echo pulse and DigitalInput 1 for the trigger pulse
    public void robotInit() {
    	//((Object) ultra).setAutomaticMode(true); // turns on automatic mode
    }

    public void ultrasonicSample()
    {
    	//double range = ultra.getRangeInches(); // reads the range on the ultrasonic sensor
    }
}