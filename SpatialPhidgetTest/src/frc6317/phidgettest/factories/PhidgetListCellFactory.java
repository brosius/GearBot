package frc6317.phidgettest.factories;

import com.phidgets.Phidget;
import com.phidgets.PhidgetException;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class PhidgetListCellFactory implements Callback<ListView<Phidget>, ListCell<Phidget>> {

	@Override
	public ListCell<Phidget> call(ListView<Phidget> param) {
		return new ListCell<Phidget>() {
			@Override
			protected void updateItem(Phidget item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText(null);
				} else {
					try {
						setText("" + item.getSerialNumber());
					} catch (PhidgetException e) {
						setText("Error");
					}
				}
			}
		};
	}

}
