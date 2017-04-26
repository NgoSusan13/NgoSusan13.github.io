package Tiles;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Tile {

	private int _x;
	private int _y;
	private boolean _selected;
	private Button _button;
	private Media sound;

	public Tile(int y, int x, Button button) {
		_x = x;
		_y = y;
		_selected = false;
		_button = button;
	}

	public void setSound(String c) {
		String sounds = c + (Integer.toString(_y + 1)) + ".mp3";
		sound = new Media(new File(sounds).toURI().toString());
	}

	public void play() {
		if (_selected == true) {
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		}
	}

	public void toggle() {
		_selected = !_selected;
		if (_selected == true) {
			_button.setStyle("-fx-base: #2AD5FF;");
		} else {
			_button.setStyle("");
		}
	}

	public Button getButton() {
		return _button;
	}

}
