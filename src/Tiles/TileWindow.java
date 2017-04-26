package Tiles;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TileWindow {

	public TileWindow() {
		try {
			String viewFile = "TileWindow.fxml";
			String windowTitle = "Tiles";
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource(viewFile));
			Stage stage = new Stage();
			TileController controller = new TileController();
			loader.setController(controller);
			stage.setScene(new Scene(loader.load()));
			stage.setTitle(windowTitle);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}