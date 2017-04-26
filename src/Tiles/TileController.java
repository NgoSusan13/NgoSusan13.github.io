package Tiles;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TileController {

	@FXML
	Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11,
			beat0, beat1, beat2, beat3;
	@FXML
	Label _loopnumber;
	@FXML
	Label _selection;
	private Map<Button, Tile> _map;
	private BeatKeeper[] _beats;
	private Timeline _timeline;
	private Button[] _buttons;
	private Tile[][] _tiles;
	private int _beat;
	private int _loop;
	private int _loops;

	public void initialize() {
		_beat = 0;
		_loops = 16;
		_tiles = new Tile[3][4];
		_loopnumber.setText("4");
		_selection.setText("Synth");
		_map = new HashMap<Button, Tile>();
		_timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), this::play));
		_timeline.setCycleCount(_loops);
		_beats = new BeatKeeper[] { new BeatKeeper(beat0), new BeatKeeper(beat1), new BeatKeeper(beat2),
				new BeatKeeper(beat3) };
		_buttons = new Button[] { button0, button1, button2, button3, button4, button5, button6, button7, button8,
				button9, button10, button11, beat0, beat1, beat2, beat3 };
		for (int i = 0, k = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++, k++) {
				_tiles[i][j] = new Tile(i, j, _buttons[k]);
				_tiles[i][j].setSound(_selection.getText());
				_map.put(_buttons[k], _tiles[i][j]);
			}
		}
		_tiles[2][0].toggle();
		_tiles[1][1].toggle();
		_tiles[0][2].toggle();
		_tiles[1][3].toggle();
	}

	// Options

	public void setSounds(Event e) {
		_selection.setText(((Button) e.getSource()).getText());
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				_tiles[i][j].setSound(_selection.getText());
			}
		}
	}

	public void setLoop(Event e) {
		_loops = Integer.parseInt(((Button) e.getSource()).getText()) * 4;
		_timeline.setCycleCount(_loops);
		_loopnumber.setText(((Button) e.getSource()).getText());
	}

	public void setSpeed(Event e) {
	}

	// Button toggle

	public void toggle(Event e) {
		_map.get(((Button) e.getSource())).toggle();
	}

	// Play code

	public void playButton() {
		_loop = 0;
		_beat = 0;
		if (_beats[3].getSelection()) {
			_beats[3].toggle();
		}
		_timeline.play();
	}

	public void play(ActionEvent e) {
		this.indicateBeat();
		for (int y = 0; y < 3; y++) {
			_tiles[y][_beat].play();
		}
		this.increment();
	}

	public void indicateBeat() {
		_beats[_beat].toggle();
		if (_loop != 0) {
			if (_beat > 0) {
				_beats[_beat - 1].toggle();
			} else {
				_beats[3].toggle();
			}
		}
	}

	public void increment() {
		if (_beat < 3) {
			_beat++;
		} else {
			_beat = 0;
		}
		_loop++;
	}

}
