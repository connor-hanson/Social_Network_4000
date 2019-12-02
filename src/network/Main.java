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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class that creates GUI for aTeam Project, creating a Social Network
 * @author Daniel de Monteiro, Connor Hanson, Mitchell Alley, George Khankeldian
 *
 */
public class Main extends Application {
	
	private final int WINDOW_HEIGHT = 500; //window height (pixels)
	private final int WINDOW_WIDTH = 500; //window width(pixels)
	private final String APP_NAME = "Social Network 4000"; //app title
	private Stage stage; //default primary stage
	

	/**
	 * Default start window when GUI is first run
	 * Contains saving, creating a network, and loading a network
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		this.stage = primaryStage;
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
		primaryStage.setTitle(APP_NAME);
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
		button1.setOnAction(e -> loginScreen());
		button2.setOnAction(e -> loginScreen());
		
		return twoInputBox;
	}
	
	public void loginScreen() {
		BorderPane pane = new BorderPane();
		Scene loginScene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		VBox loginBox = twoInputBox("Username: ", "Password: ");
		pane.setCenter(loginBox);
		
		//Create account button, and set to userScreen
		Button createAccount = new Button("Create Account");
		createAccount.setOnAction(e -> userScreen("USER")); //FIXME so USER is actual username
		loginBox.getChildren().add(createAccount);
		
		HBox adminBox = new HBox();
		adminBox.getChildren().add(new Label ("Admin"));
		adminBox.getChildren().add(new TextField());
		Button adminButt = new Button("Login");
		adminBox.getChildren().add(adminButt);
		loginBox.getChildren().add(adminBox);
		
		adminButt.setOnAction(e -> adminScreen());
		
		pane.setTop(menuBar());
		
		
		
		stage.setScene(loginScene);
		
	}
	
	private void adminScreen() {
		BorderPane bp = new BorderPane();
		Scene adminScreen = new Scene(bp, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		bp.setTop(menuBar());
		VBox options = new VBox();
		bp.setCenter(options);
		
		HBox box1 = new HBox();
		Button shortestFriendPath = new Button("Find Shortest Path");
		box1.getChildren().add(shortestFriendPath);
		VBox insideBox1 = new VBox();
		TextField user1 = new TextField("Username 1");
		insideBox1.getChildren().add(user1);
		TextField user2 = new TextField("Username 2");
		insideBox1.getChildren().add(user2);
		box1.getChildren().add(insideBox1);
		options.getChildren().add(box1);
		
		HBox box2 = new HBox();
		Button listMutualFriends = new Button("Mutual Friends");
		box2.getChildren().add(listMutualFriends);
		VBox insideBox2 = new VBox();
		TextField userUno = new TextField("Username 1");
		insideBox2.getChildren().add(userUno);
		TextField userDos = new TextField("Username 2");
		insideBox2.getChildren().add(userDos);
		box2.getChildren().add(insideBox2);
		options.getChildren().add(box2);
		
		Button totalConnections = new Button("View Total Connections");
		options.getChildren().add(totalConnections);
		
		HBox box3 = new HBox();
		Button search = new Button("Search");
		box3.getChildren().add(search);
		TextField user = new TextField("Username");
		box3.getChildren().add(user);
		options.getChildren().add(box3);
		
		Button reset = new Button("Reset Network");
		options.getChildren().add(reset);
		
		
		
		
		stage.setScene(adminScreen);
	}
	
	/**
	 * Screen each user see's when they login (correctly)
	 * @param username of the user
	 */
	private void userScreen(String username) {
		//create label to display username at top
		Label userLabel = new Label("User: " + username);
		
		//Create button to view friends
		Button viewFriends = new Button("View Friends");
		
		//Adding elements to borderpane
		BorderPane bp = new BorderPane();
		bp.setTop(userLabel);
		bp.setCenter(viewFriends);
		//Create scene, and set scene
		Scene userScreen = new Scene(bp, WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setScene(userScreen);
		
		//TODO Finish adding all other elements of user screen 
	}
	
	/**
	 * Private helper method to view friends of a certain user
	 * @param username of the user who's friends will be shown
	 */
	private void viewFriendsList(String username) {
		//TODO Implement how to view friend list
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
	
	/*
	 * Contains save, exit network, sign out
	 */
	public MenuBar menuBar() {
		return setUpMenuBar();
	}
	
	private MenuBar setUpMenuBar() {
		MenuBar menu = new MenuBar();
		
		Menu save = new Menu("Save");
		
		Menu exit = new Menu("Exit");
		exit.setOnAction(e -> Platform.exit());
		
		Menu signOut = new Menu("Sign out");
		signOut.setOnAction(e -> loginScreen()); // test l8ter
		
		menu.getMenus().addAll(save, exit, signOut);
		return menu;
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
