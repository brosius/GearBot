package frc6317.phidgettest;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.phidgets.Manager;
import com.phidgets.Phidget;
import com.phidgets.PhidgetException;
import com.phidgets.SpatialEventData;
import com.phidgets.SpatialPhidget;
import com.phidgets.event.AttachEvent;
import com.phidgets.event.AttachListener;
import com.phidgets.event.DetachEvent;
import com.phidgets.event.DetachListener;
import com.phidgets.event.SpatialDataEvent;
import com.phidgets.event.SpatialDataListener;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Main implements AttachListener, DetachListener, SpatialDataListener {
	@FXML private ListView<Integer> lvPhidgets;
	@FXML private ComboBox<Integer> cbAxes;
	@FXML private Label lblAngularRate;
	@FXML private Label lblIntegrated;
	@FXML private Label lblHeading;
	
	private Manager manager;
	private SpatialPhidget spatialPhidget;
	private int gyroAxisCount;
	private double[] integratedAxes;
	private double lastTime;
	private SpatialEventData lastData;
	
	@FXML private void initialize() throws PhidgetException {
		lvPhidgets.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			try {
				if (spatialPhidget.isAttached())
					spatialPhidget.close();
				if (newValue != null)
					spatialPhidget.open(newValue);
			} catch (PhidgetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		cbAxes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			Platform.runLater(this::updateData);
		});
		
		spatialPhidget = new SpatialPhidget();
		spatialPhidget.addAttachListener(this);
		spatialPhidget.addDetachListener(this);
		spatialPhidget.addSpatialDataListener(this);
		
		manager = new Manager();
		manager.addAttachListener(e -> {
			Platform.runLater(() -> {
				try {
					if ("PhidgetSpatial".equals(e.getSource().getDeviceType()))
						lvPhidgets.getItems().add(e.getSource().getSerialNumber());
				} catch (PhidgetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		});
		manager.addDetachListener(e -> {
			Platform.runLater(() -> {
				try {
					lvPhidgets.getItems().remove(new Integer(e.getSource().getSerialNumber()));
				} catch (PhidgetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		});
		manager.open();
	}
	
	void shutdown() {
		try {
			if (manager != null)
				manager.close();
			if (spatialPhidget != null)
				spatialPhidget.close();
		} catch (PhidgetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML private void zeroGyro() {
		try {
			spatialPhidget.removeSpatialDataListener(this);
			spatialPhidget.zeroGyro();
			integratedAxes = new double[gyroAxisCount];
			spatialPhidget.addSpatialDataListener(this);
		} catch (PhidgetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Platform.runLater(this::updateData);
	}

	@Override
	public void data(SpatialDataEvent event) {
		SpatialEventData[] eventData = event.getData();
		//System.out.println("Event data: "  + eventData.length);
		for (SpatialEventData data : eventData) {
			double time = data.getTime();
			if (lastTime == 0) {
				lastTime = time;
				continue;
			}
			double deltaTime = time - lastTime;
			assert deltaTime > 0;
			for (int i = 0; i < gyroAxisCount; ++i)
				integratedAxes[i] += data.getAngularRate()[i] * deltaTime;
			lastTime = time;
		}
		lastData = eventData[eventData.length - 1];
		Platform.runLater(this::updateData);
	}
	
	private void updateData() {
		if (lastData != null && !cbAxes.getSelectionModel().isEmpty()) {
			lblAngularRate.setText("" + lastData.getAngularRate()[cbAxes.getValue()]);
			lblIntegrated.setText("" + integratedAxes[cbAxes.getValue()]);
			double heading = integratedAxes[cbAxes.getValue()] % 360;
			if (heading < 0) heading += 360;
			lblHeading.setText("" + heading);
		}
	}

	@Override
	public void attached(AttachEvent event) {
		try {
			gyroAxisCount = spatialPhidget.getGyroAxisCount();
			cbAxes.getItems().setAll(IntStream.range(0, gyroAxisCount).boxed().collect(Collectors.toList()));
			integratedAxes = new double[gyroAxisCount];
			lastTime = 0;
		} catch (PhidgetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void detached(DetachEvent e) {
		lastData = null;
		cbAxes.getItems().clear();
	}
}
