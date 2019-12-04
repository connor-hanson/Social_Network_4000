/**
 * Filename:   Main.java
 * 
 * Name: Daniel de Monteiro
 * Email: demonteiro@wisc.edu
 * Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 002
 * 
 * Name: Connor Hanson
 * Email: cbhanson2@wisc.edu
 * Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 002
 * 
 * Name: Mitchell Alley
 * Email: mgalley@wisc.edu
 * Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 001
 * 
 * Name: George Khankeldian
 * Email: khankeldian@wisc.edu
 * Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 002
 * 
 * Due Date: December 3, 2019
 * 
 * Project Name: a2 ATEAM Project Milestone 2 GUI
 * Description: Create a GUI to show the social network
 */

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Stack;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class that creates GUI for aTeam Project, creating a Social Network
 * 
 * @author Daniel de Monteiro, Connor Hanson, Mitchell Alley, George Khankeldian
 *
 */
public class Main extends Application {

	private final int WINDOW_HEIGHT = 500; // window height (pixels)
	private final int WINDOW_WIDTH = 500; // window width(pixels)
	private final String APP_NAME = "Social Network 4000"; // app title
	private Stage stage; // default primary stage
	private Stack<EventHandler<ActionEvent>> actionHistory;

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

		VBox topBox = new VBox();
		topBox.getChildren().add(menuBar());

		Label title = new Label(APP_NAME);
		topBox.getChildren().add(title);

		root.setTop(topBox);

		// contains the elements in the center of the page, load and create
		// files
		// make 2 boxes to separate the load and create functions
		VBox createAndLoadNetwork = twoInputBox("Create network: ",
				"Load network: ");
		root.setCenter(createAndLoadNetwork);

		// create exit option, should create a popup if exit is clicked
		HBox exitBox = new HBox();
		Button exitButton = new Button("EXIT");
		exitBox.getChildren().add(exitButton);
		root.setBottom(exitBox);

		exitButton.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Save?");
			alert.showAndWait().filter(
					resp -> resp == ButtonType.OK || resp == ButtonType.NO);
			// alert.show();
		});

		// add components to the GUI
		primaryStage.setTitle(APP_NAME);
		primaryStage.setScene(loadScene);
		primaryStage.show();
	}

	/**
	 * used this method so we can recall the first page, without needing try
	 * catch blocks everywhere
	 */
	private void firstPage() {
		try {
			start(stage);
		} catch (Exception e) {
			System.err.println("ya dunn fucked up");
		}
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

	/**
	 * Methdo to make a two input VBox
	 * @param input1
	 * @param input2
	 * @return the Vbox
	 */
	public VBox twoInputBox(String input1, String input2) {
		VBox twoInputBox = setUpTwoInputBox(input1, input2);
		return twoInputBox;
	}

	/**
	 * Sets up a versatile two input box, with a label followed by a textfield
	 * not sure why there are two methods tho someone lmk
	 * @param input1
	 * @param input2
	 * @return
	 */
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

	/**
	 * Method to view the login screen with all login screen elements
	 */
	public void loginScreen() {
		BorderPane pane = new BorderPane();
		Scene loginScene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);

		VBox loginBox = twoInputBox("Username: ", "Password: ");
		pane.setCenter(loginBox);

		// Create account button, and set to userScreen
		Button createAccount = new Button("Create Account");
		createAccount.setOnAction(e -> userScreen("USER")); // FIXME so USER is
															// actual username
		loginBox.getChildren().add(createAccount);

		HBox adminBox = new HBox();
		adminBox.getChildren().add(new Label("Admin"));
		adminBox.getChildren().add(new TextField());
		Button adminButt = new Button("Login");
		adminBox.getChildren().add(adminButt);
		loginBox.getChildren().add(adminBox);

		adminButt.setOnAction(e -> adminScreen());

		pane.setTop(menuBar());

		stage.setScene(loginScene);

	}

	/**
	 * Methdo to view admin screen with all admin screen elements
	 */
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
	 * 
	 * @param username of the user
	 */
	private void userScreen(String username) {
		// create label to display username at top
		Label userLabel = new Label("User: " + username);

		// Create VBox to store elements for userScreen
		VBox vBox = new VBox();
		vBox.getChildren().add(userLabel);

		// Create button to view friends
		Button viewFriends = new Button("View Friends");
		viewFriends.setOnAction(e -> viewFriendsList(username)); // implement
		vBox.getChildren().add(viewFriends);

		// Create text field to send friend request
		HBox friendRequestBox = new HBox();
		friendRequestBox.getChildren().add(new Label("Send Friend Request: "));
		TextField friendRequestText = new TextField();
		friendRequestBox.getChildren().add(friendRequestText);
		Button sendButton = new Button("Send");
		friendRequestBox.getChildren().add(sendButton);
		sendButton.setOnAction(e -> { // button action to retrieve inputed text
			String text = friendRequestText.getText();
			sendFriendRequest(username, text);
		});
		vBox.getChildren().add(friendRequestBox);

		// Create button to view friend requests
		Button viewFriendRequests = new Button("View Friend Requests");
		viewFriendRequests.setOnAction(e -> viewFriendRequests(username)); // implement
		vBox.getChildren().add(viewFriendRequests);

		// Create text field to remove a friend
		HBox removeBox = new HBox();
		removeBox.getChildren().add(new Label("Remove Friend: "));
		TextField removeText = new TextField();
		removeBox.getChildren().add(removeText);
		Button removeButton = new Button("Remove");
		removeBox.getChildren().add(removeButton);
		removeButton.setOnAction(e -> { // button action to retrieve inputed
										// text
			String text = removeText.getText();
			removeFriend(username, text);
		});
		vBox.getChildren().add(removeBox);

		// Create text field to get mutual friends
		HBox mutualBox = new HBox();
		mutualBox.getChildren().add(new Label("Mutual Friends: "));
		TextField mutualText = new TextField();
		mutualBox.getChildren().add(mutualText);
		Button mutualButton = new Button("View");
		mutualBox.getChildren().add(mutualButton);
		mutualButton.setOnAction(e -> { // button action to retrieve inputed
										// text
			String text = mutualText.getText();
			mutualFriend(username, text);
		});
		vBox.getChildren().add(mutualBox);

		// Text field to search if a user exists or not
		HBox serachBox = new HBox();
		serachBox.getChildren().add(new Label("Search: "));
		TextField serachText = new TextField("Username");
		serachBox.getChildren().add(serachText);
		Button serachButton = new Button("View");
		serachBox.getChildren().add(serachButton);
		serachButton.setOnAction(e -> { // button action to retrieve inputed
										// text
			String text = serachText.getText();
			search(text);
		});
		vBox.getChildren().add(serachBox);

		// Button to delete acount
		Button deleteAccount = new Button("DELETE ACCOUNT");
		deleteAccount.setOnAction(e -> deleteAccount(username)); // implement
		vBox.getChildren().add(deleteAccount);

		// Adding elements to borderpane
		BorderPane bp = new BorderPane();
		// bp.setTop(userLabel);
		bp.setTop(menuBar());
		bp.setCenter(vBox);
		// Create scene, and set scene
		Scene userScreen = new Scene(bp, WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setScene(userScreen);
	}

	/**
	 * Private helper method to view friends of a certain user
	 * 
	 * @param username of the user who's friends will be shown
	 */
	private void viewFriendsList(String username) {
		// create label to display username at top
		Label userLabel = new Label("Friends of: " + username);
		
		//Create a TableView to view friends
		TableView friendView = new TableView();
		TableColumn<String, Person> firstNameColumn = new TableColumn<>("First Name");
		firstNameColumn.setCellValueFactory(new 
				PropertyValueFactory<>("firstName"));
		TableColumn<String, Person> lastNameColumn = new TableColumn<>("Last Name");
		lastNameColumn.setCellValueFactory(new 
				PropertyValueFactory<>("lastName"));
		friendView.setPlaceholder(new Label("No rows to display"));
		
		friendView.getColumns().add(firstNameColumn);
		friendView.getColumns().add(lastNameColumn);
		
		//Add an example friend to TableView
		friendView.getItems().add(new Person("Daniel", "de Monteiro"));
		friendView.getItems().add(new Person("Sicko", "Bamba"));
		
		// Adding elements to borderpane
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar());
		bp.setBottom(userLabel);
		bp.setCenter(friendView);
		// Create scene, and set scene
		Scene userScreen = new Scene(bp, WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setScene(userScreen);
		
		// TODO Correctly implement how to view friend list
	}

	/**
	 * Private helper method to send friend request
	 * 
	 * @param username   of the user who wants to send the friend request
	 * @param friendName is the name of the user to send the request to
	 */
	private void sendFriendRequest(String username, String friendName) {
		// TODO Implement how to send friend request
	}

	/**
	 * Private helper method to view friends requests of a user
	 * 
	 * @param username of the user who's friend requests will be shown
	 */
	private void viewFriendRequests(String username) {
		// create label to display username at top
		Label userLabel = new Label("Friends Requests for: " + username);
		
		//Create a TableView to view friends
		TableView friendRequestView = new TableView();
		TableColumn<String, Person> firstNameColumn = new TableColumn<>("First Name");
		firstNameColumn.setCellValueFactory(new 
				PropertyValueFactory<>("firstName"));
		TableColumn<String, Person> lastNameColumn = new TableColumn<>("Last Name");
		lastNameColumn.setCellValueFactory(new 
				PropertyValueFactory<>("lastName"));
		friendRequestView.setPlaceholder(new Label("No rows to display"));
		
		friendRequestView.getColumns().add(firstNameColumn);
		friendRequestView.getColumns().add(lastNameColumn);
		
		//Add an example friend to TableView
		friendRequestView.getItems().add(new Person("Connor", "Hanson"));
		friendRequestView.getItems().add(new Person("Mitch", "Alley"));
		friendRequestView.getItems().add(new Person("George", "Khankeldian"));

		// Adding elements to borderpane
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar());
		bp.setBottom(userLabel);
		bp.setCenter(friendRequestView);
		// Create scene, and set scene
		Scene userScreen = new Scene(bp, WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setScene(userScreen);
		
		// TODO Correctly implement how to view friend requests
	}

	/**
	 * Private helper method to remove a friend
	 * 
	 * @param username   is the user who's friend will be removed
	 * @param friendName is the name of the friend to remove
	 */
	private void removeFriend(String username, String friendName) {
		// TODO Implement how to remove a friend/
	}

	/**
	 * Private helper method to view mutual friends
	 * 
	 * @param username   of the user
	 * @param friendName of the user to see which mutual friends are shared
	 */
	private void mutualFriend(String username, String friendName) {
		// TODO Implement viewing mutual friends
	}

	/**
	 * Private helper method to see if a user exists
	 * 
	 * @param username
	 */
	private boolean search(String username) {
		// TODO Implement if a user exists or not in the network
		return false;
	}

	/**
	 * Private helper method to delete an account
	 * 
	 * @param username of the account to delete
	 */
	private void deleteAccount(String username) {
		// TODO Implement deleting an account
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

	/**
	 * Private helper method to save, exit network, and sign out for menuBar
	 * @return the MenuBar with all its elements
	 */
	private MenuBar setUpMenuBar() {
		MenuBar menuBar = new MenuBar();

		Menu menu = new Menu("Options");

		// save actions, need to implement the save feature
		MenuItem save = new MenuItem("Save");
		save.setOnAction(e -> {

			// Just save, don't prompt or anything

		});

		MenuItem load = new MenuItem("Load");
		load.setOnAction(e -> {
			TextInputDialog loadFile = new TextInputDialog();
			loadFile.setHeaderText("Type in file to load!");
			Optional<String> input = loadFile.showAndWait();
			
			
		});

		// exit button prompts user to save
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(e -> {
			Alert al = new Alert(AlertType.NONE, "Save? ", ButtonType.YES,
					ButtonType.NO, ButtonType.CANCEL);
			Optional<ButtonType> result = al.showAndWait();
			if (result.get() == ButtonType.YES) {
				Platform.exit();
			} else if (result.get() == ButtonType.NO) {
				Platform.exit();
			} else if (result.get() == ButtonType.CANCEL) {
				al.close();
			}

		});

		MenuItem signOut = new MenuItem("Sign out");
		signOut.setOnAction(e -> loginScreen()); // test l8ter

		menu.getItems().addAll(save, load, exit, signOut);

		Menu pages = new Menu("Pages");

		MenuItem origPage = new MenuItem("Create/Load Screen");
		origPage.setOnAction(e -> firstPage());

		MenuItem loginScreen = new MenuItem("Login Screen");
		loginScreen.setOnAction(e -> loginScreen());

		pages.getItems().addAll(origPage, loginScreen);

		menuBar.getMenus().add(menu);
		menuBar.getMenus().add(pages);
		return menuBar;
	}

	// not sure what +field : type is

	private void drawGraph(GraphicsContext gc) {

	}

	private void drawNode(GraphicsContext gc, String name, double x, double y) {

	}

	private void drawEdge(GraphicsContext gc, double x1, double y1, double x2,
			double y2) {

	}

	private String getNameFromCoordinates(double x, double y) {
		return null;
	}

	private void setSelectedUser(String name) {

	}

	public static void main(String[] args) {
		launch(args);
	}

}
