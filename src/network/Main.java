package network;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	private final int WINDOW_HEIGHT = 500;
	private final int WINDOW_WIDTH = 500;
	private final String APP_NAME = "Social Network 4000";
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		// starts with the load/create file scene
		// user can load, create, save, or exit program
		Scene loadScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// contains the elements at the top of the page: title, save button
		HBox topBox = new HBox();
		Button saveButton = new Button("Save");
		topBox.getChildren().add(saveButton);
		saveButton.setOnAction(e -> Platform.exit());
		
		Label title = new Label(APP_NAME);
		topBox.getChildren().add(title);
		
		root.setTop(topBox);
		
		// contains the elements in the center of the page, load and create files
		// make 2 boxes to separate the load and create functions
		VBox centerBox = new VBox();
		HBox createBox = new HBox();
		HBox loadBox = new HBox();
		centerBox.getChildren().add(createBox);
		centerBox.getChildren().add(loadBox);
		
		Label createFile = new Label("Create file: ");
		TextField createField = new TextField();
		createBox.getChildren().add(createFile);
		createBox.getChildren().add(createField);
		
		Label loadFile = new Label("Load file: ");
		TextField loadField = new TextField();
		loadBox.getChildren().add(loadFile);
		loadBox.getChildren().add(loadField);
		
		root.setCenter(centerBox);
		
		// create exit option, should create a popup if exit is clicked
		HBox exitBox = new HBox();
		Button exitButton = new Button("EXIT");
		exitButton.setOnAction(e -> {
			Alert alert = new Alert(AlertType.WARNING, "Save?");
			alert.showAndWait().filter(response -> response == ButtonType.OK);
			alert.show();
		});
		exitBox.getChildren().add(exitButton);
		root.setBottom(exitBox);
		
		
		primaryStage.setScene(loadScene);
		primaryStage.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	

}
