package Tiles;

import javafx.scene.control.Button;

public class BeatKeeper {

	private boolean _selected;
	private Button _button;

	public BeatKeeper(Button button) {
		_selected = false;
		_button = button;
	}

	public void toggle() {
		_selected = !_selected;
		if (_selected == true) {
			_button.setStyle("-fx-base: #900000;");
		} else {
			_button.setStyle("");
		}
	}

	public Button getButton() {
		return _button;
	}

	public boolean getSelection() {
		return _selected;
	}

}
