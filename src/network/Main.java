package network;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
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
		VBox createAndLoadNetwork = twoInputBox("Create network: ", "Load network: ");
		root.setCenter(createAndLoadNetwork);
		
		// create exit option, should create a popup if exit is clicked
		HBox exitBox = new HBox();
		Button exitButton = new Button("EXIT");
		exitBox.getChildren().add(exitButton);
		root.setBottom(exitBox);
		
		// FIXME Button creates a second popup when alert is interacted with/closed
		exitButton.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Save?");
			alert.showAndWait().filter(resp -> resp == ButtonType.OK || resp == ButtonType.NO);
			alert.show();
		});
		
		// add components to the GUI
		primaryStage.setScene(loadScene);
		primaryStage.show();
	}
	
	public SocialNetwork socialNetwork() {
		
		return null;
	}
	
	public VBox signUpBox() {
		
		return null;
	}
	
	private VBox setUpSignUpBox() {

		return null;
	}
	
	// idk why we need two methods tbh
	public VBox twoInputBox(String input1, String input2) {
		VBox twoInputBox = setUpTwoInputBox(input1, input2);
		return twoInputBox;
	}
	
	// sets up a versatile two input box, with a label followed by a textfield
	// not sure why there are two methods tho someone lmk
	private VBox setUpTwoInputBox(String input1, String input2) {
		VBox twoInputBox = new VBox();
		HBox box1 = new HBox();
		HBox box2 = new HBox();
		
		// add HBoxes to VBox
		twoInputBox.getChildren().add(box1);
		twoInputBox.getChildren().add(box2);
		
		// add Labels and TextFields to HBoxes
		Label inputLabel1 = new Label(input1);
		TextField field1 = new TextField();
		Button button1 = new Button("Done");
		box1.getChildren().add(inputLabel1);
		box1.getChildren().add(field1);
		box1.getChildren().add(button1);
		
		Label inputLabel2 = new Label(input2);
		TextField field2 = new TextField();
		Button button2 = new Button("Done");
		box2.getChildren().add(inputLabel2);
		box2.getChildren().add(field2);
		box2.getChildren().add(button2);
		
		// create or load social network
		button1.setOnAction(e -> socialNetwork());
		button2.setOnAction(e -> socialNetwork());
		
		return twoInputBox;
	}
	
	public VBox centerBox() {
		return null;
	}
	
	private VBox setUpCenterBox() {
		return null;
	}
	
	public VBox bottomBox() {
		return null;
	}
	
	private VBox setUpBottomBox() {
		return null;
	}
	
	public MenuBar menuBar() {
		return null;
	}
	
	private MenuBar setUpMenuBar() {
		return null;
	}
	
	// not sure what +field : type is
	
	private void drawGraph(GraphicsContext gc) {
		
	}
	
	private void drawNode(GraphicsContext gc, String name, double x, double y) {
		
	}
	
	private void drawEdge(GraphicsContext gc, double x1, double y1, double x2, double y2) {
		
	}
	
	private String getNameFromCoordinates(double x, double y) {
		return null;
	}
	
	private void setSelectedUser(String name) {
		
	}
	
	
	
	
	public static void main (String[] args) {
		launch(args);
	}
	

}
