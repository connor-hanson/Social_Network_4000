/**
 * Filename: Main.java
 * 
 * Name: Daniel de Monteiro Email: demonteiro@wisc.edu Class: CS400 - Debra
 * Deppeler Lecture Number: LEC 002
 * 
 * Name: Connor Hanson Email: cbhanson2@wisc.edu Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 002
 * 
 * Name: Mitchell Alley Email: mgalley@wisc.edu Class: CS400 - Debra Deppeler
 * Lecture Number: LEC 001
 * 
 * Name: George Khankeldian Email: khankeldian@wisc.edu Class: CS400 - Debra
 * Deppeler Lecture Number: LEC 002
 * 
 * Due Date: December 3, 2019
 * 
 * Project Name: a2 ATEAM Project Milestone 2 GUI Description: Create a GUI to
 * show the social network
 */

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

<<<<<<< HEAD
	private final int WINDOW_HEIGHT = 500; // window height (pixels)
	private final int WINDOW_WIDTH = 500; // window width(pixels)
	private final String APP_NAME = "Social Network 4000"; // app title
	private Stage stage; // default primary stage
	private SocialNetwork socialNetwork; // create SocialNetwork to use

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

		Label title = new Label(APP_NAME); // creates new title
		topBox.getChildren().add(title);

		root.setTop(topBox);

		// contains the elements in the center of the page, load and create
		// files
		// make 2 boxes to separate the load and create functions
//		VBox createAndLoadNetwork = twoInputBox("Create network: ",
//				"Load network: ");
//		root.setCenter(createAndLoadNetwork); // moved the buttons so that we
//												// can add load/save
//												// functionality to them
//		Button create = new Button("Create");
//		Button load = new Button("Load");
//		createAndLoadNetwork.getChildren().add(create);
//		createAndLoadNetwork.getChildren().add(load);
//		// create a new social network
//		create.setOnAction(e -> {
//			this.socialNetwork = new SocialNetwork(); // has to have a name
//			loginScreen();
//		});
//
//		load.setOnAction(e -> socialNetwork().loadFromFile());

		VBox makeNetwork = createOrLoadNetwork();
		root.setCenter(makeNetwork);

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

	/**
	 * Loads a new or existing social network
	 * 
	 * @return
	 */
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
	 * 
	 * @param input1
	 * @param input2
	 * @return the Vbox
	 */
	public VBox twoInputBox(String input1, String input2) {
		VBox twoInputBox = setUpTwoInputBox(input1, input2);
		return twoInputBox;
	}

	/**
	 * method to create the load and create fields that the user is greeted with
	 * 
	 * @return
	 */
	private VBox createOrLoadNetwork() {
		VBox container = new VBox();
		HBox line1 = new HBox();
		HBox line2 = new HBox();

		// The whole create area
		Label createLabel = new Label("Create network: ");
		TextField createField = new TextField();
		createField.setPromptText("Enter as .txt");

		Button createButton = new Button("Create");
		createButton.setOnAction(e -> {
			// invalid input, text length = 1
			if (createField.getText().length() == 0) {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText(
						"File must have at least one character. Try again.");
				al.showAndWait();
			}

			// valid input. First block appends .txt if user didn't type it in
			else if (createField.getText().contains(".txt")) {
				this.socialNetwork = new SocialNetwork(createField.getText());
				loginScreen();
			} else {
				this.socialNetwork = new SocialNetwork(
						createField.getText() + ".txt");
				loginScreen();
			}
		}); // end of create button functionality

		// load field and associated actions
		Label loadArea = new Label("Load network: ");
		TextField loadField = new TextField();
		loadField.setPromptText("MUST enter as a .txt file");

		Button loadButton = new Button("Load");
		loadButton.setOnAction(e -> {
			// if invalid input
			if (!loadField.getText().contains(".txt")) {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText("Invalid input, must end in .txt");
				al.showAndWait();
			} else {
				try {
					this.socialNetwork = new SocialNetwork(loadField.getText());
					socialNetwork.loadFromFile();
					loginScreen();
				} catch (IOException x) {
					Alert al = new Alert(AlertType.WARNING);
					al.setContentText(x.getMessage());
					al.showAndWait();
				}
			}
		}); // end of load button functionality

		// add all the fields to the HBoxes, then the HBoxes to the VBox
		line1.getChildren().addAll(createLabel, createField, createButton);
		line2.getChildren().addAll(loadArea, loadField, loadButton);
		container.getChildren().addAll(line1, line2);

		return container;

	}

	/**
	 * Sets up a versatile two input box, with a label followed by a textfield
	 * not sure why there are two methods tho someone lmk
	 * 
	 * @param input1
	 * @param input2
	 * @return
	 */
	private VBox setUpTwoInputBox(String input1, String input2) {
		VBox twoInputBox = new VBox();

		HBox box1 = new HBox();
		// HBox box2 = new HBox();

		// add HBoxes to VBox
		twoInputBox.getChildren().add(box1);
		// twoInputBox.getChildren().add(box2);

		// add Labels and TextFields to HBoxes
		Label inputLabel1 = new Label(input1);
		TextField field1 = new TextField();
		// Button button1 = new Button("Done");
		box1.getChildren().add(inputLabel1);
		box1.getChildren().add(field1);
		// box1.getChildren().add(button1);

		Label inputLabel2 = new Label(input2);
		TextField field2 = new TextField();
		// Button button2 = new Button("Done");
		// box2.getChildren().add(inputLabel2);
		// box2.getChildren().add(field2);
		// box2.getChildren().add(button2);

//		// create or load social network
//		button1.setOnAction(e -> loginScreen());
//		button2.setOnAction(e -> loginScreen());

		return twoInputBox;
	}

	public VBox loginBox() {
		// set up the containers for the login field
		VBox loginBox = new VBox();
		HBox line1 = new HBox();

		// sets the fields
		Label userNameLabel = new Label("UserName");
		TextField userNameField = new TextField();
		Button loginButton = new Button("Login");

		// logs in if the user credential are right
		loginButton.setOnAction(e -> {
			// make sure user can't enter empty string as username
			if (userNameField.getText().length() == 0) {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText("Username can't be empty");
				al.showAndWait();
			}

			// now make sure that if they're using the login button, that they
			// exist in the network. If they don't prompt them to create an
			// account. Prevents null pointers in the user screen
			else if (!socialNetwork.isAlreadyUser(userNameField.getText())) {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText(userNameField.getText()
						+ " is not registered in the Social_Network_4000. Register below.");
				al.showAndWait();
			}

			else {
				userScreen(userNameField.getText());
			}

		});

		// add all the elements to the HBox, then the HBox to VBox
		line1.getChildren().addAll(userNameLabel, userNameField, loginButton);
		loginBox.getChildren().add(line1);

		return loginBox;
	}

	/**
	 * Method to view the login screen with all login screen elements
	 */
	public void loginScreen() {
		BorderPane pane = new BorderPane();
		Scene loginScene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);

		// refactored all of the below into the loginBox() method, has the same
		// functionality but easier to edit, - Connor
//		VBox loginBox = twoInputBox("Username: ", "Password: ");
//		Button logonButton = new Button("Login");
//		loginBox.getChildren().add(logonButton);
//		logonButton.setOnAction(e -> userScreen("USER"));

		VBox loginBox = loginBox();
		pane.setCenter(loginBox);

		// Create account button, and set to userScreen
		Button createAccount = new Button("Create Account");

		// add functionality to button
		createAccount.setOnAction(e -> {
			TextInputDialog createDialog = new TextInputDialog();
			createDialog.setHeaderText(
					"Enter your name. Must have at least one character");

			GridPane dialogPane = new GridPane(); // pane to add the textfields
													// to
			VBox vbox = new VBox(20);

			TextField userName = new TextField(); // make textfields and add
													// prompt text
			userName.setPromptText("Enter your name here!");

			vbox.getChildren().add(userName);

			dialogPane.getChildren().add(vbox);
			createDialog.getDialogPane().setContent(dialogPane);

			// wait for user response and then input it
			Optional<String> result = createDialog.showAndWait();

			// add user to the network and bring them to the user page
			if (result.isPresent() && userName.getText().length() != 0) {
				// so that no duplicates occur
				if (socialNetwork.isAlreadyUser(userName.getText())) {
					Alert al = new Alert(AlertType.WARNING);
					al.setContentText(
							userName.getText() + " is already a user");
					al.showAndWait();
				}

				socialNetwork.addUser(userName.getText());
				userScreen(userName.getText());
			}

//			// cant figure out how to get the text input
//			// maybe move this stuff to signup box
//			result.ifPresent(name -> {
//				this.socialNetwork.addUser(name);
//				this.userScreen(name);
//			});

		});
		// end of create account button actions

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

		// Create text field to add a friend
		HBox friendRequestBox = new HBox();
		friendRequestBox.getChildren().add(new Label("Add Friend: "));
		TextField friendRequestText = new TextField();
		friendRequestBox.getChildren().add(friendRequestText);
		Button sendButton = new Button("Add");
		friendRequestBox.getChildren().add(sendButton);

		// send request button functionality
		sendButton.setOnAction(e -> { // button action to retrieve inputed text
			String text = friendRequestText.getText();
			//adds friend to network
			addFriend(username, text);
			addFriend(text, username);

			// confirmation so user knows request sent
			if (this.socialNetwork.isAlreadyUser(text) == true) {
				Alert al = new Alert(AlertType.CONFIRMATION);
				al.setContentText("You are now friends with " + text);
				al.showAndWait();
				friendRequestText.setText(""); // resets the send request box
			}
		});

		vBox.getChildren().add(friendRequestBox);

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

			// ensures that user can't create null pointer here
			if (text.length() == 0) {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText("Must enter a name to view mutual friends");
				al.showAndWait();
			} else {
				mutualFriend(username, text);
			}
		}); // end of mutual friends button functionality

		vBox.getChildren().add(mutualBox);

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
	// TODO add type args to friendView, view
	private void viewFriendsList(String username) {
		// create label to display username at top
		Label userLabel = new Label("Friends of: " + username + 
				"\nDouble Click Friend to View Their Friends");
		
		// Create a TableView to view friends
		TableView friendView = new TableView();
		TableColumn<String, Person> nameColumn = new TableColumn<>(
				"Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		friendView.setPlaceholder(new Label("No friends to display"));

		friendView.getColumns().add(nameColumn);

		// Get Set of user friends from SocialNetwork
		Set<Person> friends = this.socialNetwork.getFriends(username);
		// iterate through set and add friends to TableView
		for (Person p : friends) {
			System.out.println(p.getName());
			friendView.getItems().add(new Person(p.getName()));
		}
		
		//Double clicking name will list friends of friend
		friendView.setRowFactory(tv -> {
		    TableRow row = new TableRow<>();
		    row.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		            if (event.getClickCount() == 2 && (!row.isEmpty())) {
		            	Person friend = (Person) row.getItem();
		            	String friendName = friend.getName();
		                viewFriendsList(friendName);
		            }
		        }
		    });
		    return row;
		});

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
	private void addFriend(String username, String friendName) {
		//makes sure friend exists in network
		if (this.socialNetwork.isAlreadyUser(friendName) == false) {
			Alert al = new Alert(AlertType.WARNING);
			al.setContentText(
					friendName + " is not a user in the network.");
			al.showAndWait();
			return;
		}
		// create an edge between user and friend
		this.socialNetwork.addFriends(username, friendName);
	}

	/**
	 * Private helper method to remove a friend
	 * 
	 * @param username   is the user who's friend will be removed
	 * @param friendName is the name of the friend to remove
	 */
	private void removeFriend(String username, String friendName) {
		// remove edge from graph
		this.socialNetwork.removeFriends(username, friendName);
		this.socialNetwork.removeFriends(friendName, username);
	}

	/**
	 * Private helper method to view mutual friends
	 * 
	 * @param username   of the user
	 * @param friendName of the user to see which mutual friends are shared
	 */
	private void mutualFriend(String username, String friendName) {
		// create label to display username at top
		Label userLabel = new Label(
				"Mutual Friends of: " + username + " and " + friendName);

		// Create a TableView to view mutual friends
		TableView friendView = new TableView();
		TableColumn<String, Person> nameColumn = new TableColumn<>(
				"First Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		friendView.setPlaceholder(new Label("No rows to display"));

		friendView.getColumns().add(nameColumn);

		// Get Set of mutual friends from SocialNetwork
		Set<Person> friends = this.socialNetwork.getMutualFriends(username,
				friendName);
		// iterate through set and add friends to TableView
		for (Person p : friends) {
			friendView.getItems().add(new Person(p.getName()));
		}

		// Adding elements to borderpane
		BorderPane bp = new BorderPane();
		bp.setTop(menuBar());
		bp.setBottom(userLabel);
		bp.setCenter(friendView);
		// Create scene, and set scene
		Scene userScreen = new Scene(bp, WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setScene(userScreen);
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
		// delete user from socialnetwork
		this.socialNetwork.removeUser(username);
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
	 * 
	 * @return the MenuBar with all its elements
	 */
	private MenuBar setUpMenuBar() {
		MenuBar menuBar = new MenuBar();

		Menu menu = new Menu("Options");

		// save actions, need to implement the save feature
		MenuItem save = new MenuItem("Save");
		save.setOnAction(e -> {
			try {
				//Closes if there has been network created
				if (this.socialNetwork == null) {
					Platform.exit();
					System.exit(0);
				}
				socialNetwork.saveToFile();
			} catch (IOException x) {
				System.err.println("Error saving to file.");
			}
			// Just save, don't prompt or anything

		});

		MenuItem load = new MenuItem("Load");
		load.setOnAction(e -> {
			TextInputDialog loadFile = new TextInputDialog();
			loadFile.setHeaderText("Type in file to load!");

			// user input for the file to be loaded
			Optional<String> resp = loadFile.showAndWait();

			// ensure text input has at least one character
			if (resp.get().length() == 0) {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText(
						"File to load must have at least one character");
				al.showAndWait();
			}

			// append .txt to the end of string if the user didn't
			else if (!resp.get().contains(".txt")) {
				this.socialNetwork = new SocialNetwork(resp.get() + ".txt");
				try {
					socialNetwork.loadFromFile();
				} catch (IOException x) {
					System.err.println(x.getMessage());
				}
			}

			// nothing needs to be done to modify the string
			else {
				this.socialNetwork = new SocialNetwork(resp.get());
				try {
					socialNetwork.loadFromFile();
				} catch (IOException x) {
					System.err.println(x.getMessage());
				}
			}

		});

		// exit button prompts user to save
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(e -> {
			Alert al = new Alert(AlertType.NONE, "Save? ", ButtonType.YES,
					ButtonType.NO, ButtonType.CANCEL);
			Optional<ButtonType> result = al.showAndWait();
			if (result.get() == ButtonType.YES) {
				save.fire(); // calls save.getOnAction
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
=======
    private final int WINDOW_HEIGHT = 500; // window height (pixels)
    private final int WINDOW_WIDTH = 500; // window width(pixels)
    private final String APP_NAME = "Social Network 4000"; // app title
    private Stage stage; // default primary stage
    private SocialNetwork socialNetwork; // create SocialNetwork to use

    /**
     * Default start window when GUI is first run Contains saving, creating a
     * network, and loading a network
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

        Label title = new Label(APP_NAME); // creates new title
        topBox.getChildren().add(title);

        root.setTop(topBox);

        // contains the elements in the center of the page, load and create
        // files
        // make 2 boxes to separate the load and create functions
        // VBox createAndLoadNetwork = twoInputBox("Create network: ",
        // "Load network: ");
        // root.setCenter(createAndLoadNetwork); // moved the buttons so that we
        // // can add load/save
        // // functionality to them
        // Button create = new Button("Create");
        // Button load = new Button("Load");
        // createAndLoadNetwork.getChildren().add(create);
        // createAndLoadNetwork.getChildren().add(load);
        // // create a new social network
        // create.setOnAction(e -> {
        // this.socialNetwork = new SocialNetwork(); // has to have a name
        // loginScreen();
        // });
        //
        // load.setOnAction(e -> socialNetwork().loadFromFile());

        VBox makeNetwork = createOrLoadNetwork();
        root.setCenter(makeNetwork);

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

    /**
     * Loads a new or existing social network
     * 
     * @return
     */
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
     * 
     * @param input1
     * @param input2
     * @return the Vbox
     */
    public VBox twoInputBox(String input1, String input2) {
        VBox twoInputBox = setUpTwoInputBox(input1, input2);
        return twoInputBox;
    }

    /**
     * method to create the load and create fields that the user is greeted with
     * 
     * @return
     */
    private VBox createOrLoadNetwork() {
        VBox container = new VBox();
        HBox line1 = new HBox();
        HBox line2 = new HBox();

        // The whole create area
        Label createLabel = new Label("Create network: ");
        TextField createField = new TextField();
        createField.setPromptText("Enter as .txt");

        Button createButton = new Button("Create");
        createButton.setOnAction(e -> {
            // invalid input, text length = 1
            if (createField.getText().length() == 0) {
                Alert al = new Alert(AlertType.WARNING);
                al.setContentText(
                        "File must have at least one character. Try again.");
                al.showAndWait();
            }

            // valid input. First block appends .txt if user didn't type it in
            else if (createField.getText().contains(".txt")) {
                this.socialNetwork = new SocialNetwork(createField.getText());
                loginScreen();
            } else {
                this.socialNetwork =
                        new SocialNetwork(createField.getText() + ".txt");
                loginScreen();
            }
        }); // end of create button functionality

        // load field and associated actions
        Label loadArea = new Label("Load network: ");
        TextField loadField = new TextField();
        loadField.setPromptText("MUST enter as a .txt file");

        Button loadButton = new Button("Load");
        loadButton.setOnAction(e -> {
            // if invalid input
            if (!loadField.getText().contains(".txt")) {
                Alert al = new Alert(AlertType.WARNING);
                al.setContentText("Invalid input, must end in .txt");
                al.showAndWait();
            } else {
                try {
                    this.socialNetwork = new SocialNetwork(loadField.getText());
                    socialNetwork.loadFromFile();
                    loginScreen();
                } catch (IOException x) {
                    Alert al = new Alert(AlertType.WARNING);
                    al.setContentText(x.getMessage());
                    al.showAndWait();
                }
            }
        }); // end of load button functionality

        // add all the fields to the HBoxes, then the HBoxes to the VBox
        line1.getChildren().addAll(createLabel, createField, createButton);
        line2.getChildren().addAll(loadArea, loadField, loadButton);
        container.getChildren().addAll(line1, line2);

        return container;

    }

    /**
     * Sets up a versatile two input box, with a label followed by a textfield
     * not sure why there are two methods tho someone lmk
     * 
     * @param input1
     * @param input2
     * @return
     */
    private VBox setUpTwoInputBox(String input1, String input2) {
        VBox twoInputBox = new VBox();

        HBox box1 = new HBox();
        // HBox box2 = new HBox();

        // add HBoxes to VBox
        twoInputBox.getChildren().add(box1);
        // twoInputBox.getChildren().add(box2);

        // add Labels and TextFields to HBoxes
        Label inputLabel1 = new Label(input1);
        TextField field1 = new TextField();
        // Button button1 = new Button("Done");
        box1.getChildren().add(inputLabel1);
        box1.getChildren().add(field1);
        // box1.getChildren().add(button1);

        Label inputLabel2 = new Label(input2);
        TextField field2 = new TextField();
        // Button button2 = new Button("Done");
        // box2.getChildren().add(inputLabel2);
        // box2.getChildren().add(field2);
        // box2.getChildren().add(button2);

        // // create or load social network
        // button1.setOnAction(e -> loginScreen());
        // button2.setOnAction(e -> loginScreen());

        return twoInputBox;
    }

    public VBox loginBox() {
        // set up the containers for the login field
        VBox loginBox = new VBox();
        HBox line1 = new HBox();

        // sets the fields
        Label userNameLabel = new Label("UserName");
        TextField userNameField = new TextField();
        Button loginButton = new Button("Login");

        // logs in if the user credential are right
        loginButton.setOnAction(e -> {
            // make sure user can't enter empty string as username
            if (userNameField.getText().length() == 0) {
                Alert al = new Alert(AlertType.WARNING);
                al.setContentText("Username can't be empty");
                al.showAndWait();
            }

            // now make sure that if they're using the login button, that they
            // exist in the network. If they don't prompt them to create an
            // account. Prevents null pointers in the user screen
            else if (!socialNetwork.isAlreadyUser(userNameField.getText())) {
                Alert al = new Alert(AlertType.WARNING);
                al.setContentText(userNameField.getText()
                        + " is not registered in the Social_Network_4000. Register below.");
                al.showAndWait();
            }

            else {
                userScreen(userNameField.getText());
            }

        });

        // add all the elements to the HBox, then the HBox to VBox
        line1.getChildren().addAll(userNameLabel, userNameField, loginButton);
        loginBox.getChildren().add(line1);

        return loginBox;
    }

    /**
     * Method to view the login screen with all login screen elements
     */
    public void loginScreen() {
        BorderPane pane = new BorderPane();
        Scene loginScene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);

        // refactored all of the below into the loginBox() method, has the same
        // functionality but easier to edit, - Connor
        // VBox loginBox = twoInputBox("Username: ", "Password: ");
        // Button logonButton = new Button("Login");
        // loginBox.getChildren().add(logonButton);
        // logonButton.setOnAction(e -> userScreen("USER"));

        VBox loginBox = loginBox();
        pane.setCenter(loginBox);

        // Create account button, and set to userScreen
        Button createAccount = new Button("Create Account");

        // add functionality to button
        createAccount.setOnAction(e -> {
            TextInputDialog createDialog = new TextInputDialog();
            createDialog.setHeaderText(
                    "Enter your name. Must have at least one character");

            GridPane dialogPane = new GridPane(); // pane to add the textfields
                                                  // to
            VBox vbox = new VBox(20);

            TextField userName = new TextField(); // make textfields and add
                                                  // prompt text
            userName.setPromptText("Enter your name here!");

            vbox.getChildren().add(userName);

            dialogPane.getChildren().add(vbox);
            createDialog.getDialogPane().setContent(dialogPane);

            // wait for user response and then input it
            Optional<String> result = createDialog.showAndWait();

            // add user to the network and bring them to the user page
            if (result.isPresent() && userName.getText().length() != 0) {
                // so that no duplicates occur
                if (socialNetwork.isAlreadyUser(userName.getText())) {
                    Alert al = new Alert(AlertType.WARNING);
                    al.setContentText(
                            userName.getText() + " is already a user");
                    al.showAndWait();
                }

                socialNetwork.addUser(userName.getText());
                userScreen(userName.getText());
            }

            // // cant figure out how to get the text input
            // // maybe move this stuff to signup box
            // result.ifPresent(name -> {
            // this.socialNetwork.addUser(name);
            // this.userScreen(name);
            // });

        });
        // end of create account button actions

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

        // Create text field to add a friend
        HBox friendRequestBox = new HBox();
        friendRequestBox.getChildren().add(new Label("Add Friend: "));
        TextField friendRequestText = new TextField();
        friendRequestBox.getChildren().add(friendRequestText);
        Button sendButton = new Button("Add");
        friendRequestBox.getChildren().add(sendButton);

        // send request button functionality
        sendButton.setOnAction(e -> { // button action to retrieve inputed text
            Set<Person> userFriends = socialNetwork.getFriends(username);
            String text = friendRequestText.getText();
            boolean hasFriend = false;
            // adds friend to network

            for (Person currentFriend : userFriends) {
                if (currentFriend.getName().equals(text)) {
                    hasFriend = true;
                }
            }

            if (!hasFriend) {
                addFriend(username, text);
                addFriend(text, username);

                // confirmation so user knows request sent
                if (this.socialNetwork.isAlreadyUser(text) == true) {
                    Alert al = new Alert(AlertType.CONFIRMATION);
                    al.setContentText("You are now friends with " + text);
                    al.showAndWait();
                    friendRequestText.setText(""); // resets the send request
                                                   // box
                }
            } else {
                Alert oldFriend = new Alert(AlertType.WARNING);
                oldFriend.setContentText(
                        "You are already friends with " + text + "!");
                oldFriend.showAndWait();
            }
        });

        vBox.getChildren().add(friendRequestBox);

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

            // ensures that user can't create null pointer here
            if (text.length() == 0) {
                Alert al = new Alert(AlertType.WARNING);
                al.setContentText("Must enter a name to view mutual friends");
                al.showAndWait();
            } else {
                mutualFriend(username, text);
            }
        }); // end of mutual friends button functionality

        vBox.getChildren().add(mutualBox);

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
    // TODO add type args to friendView, view
    private void viewFriendsList(String username) {
        // create label to display username at top
        Label userLabel = new Label("Friends of: " + username
                + "\nDouble Click Friend to View Their Friends");

        // Create a TableView to view friends
        TableView friendView = new TableView();
        TableColumn<String, Person> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        friendView.setPlaceholder(new Label("No friends to display"));

        friendView.getColumns().add(nameColumn);

        // Get Set of user friends from SocialNetwork
        Set<Person> friends = this.socialNetwork.getFriends(username);
        // iterate through set and add friends to TableView
        for (Person p : friends) {
            System.out.println(p.getName());
            friendView.getItems().add(new Person(p.getName()));
        }

        // Double clicking name will list friends of friend
        friendView.setRowFactory(tv -> {
            TableRow row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        Person friend = (Person) row.getItem();
                        String friendName = friend.getName();
                        viewFriendsList(friendName);
                    }
                }
            });
            return row;
        });

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
    private void addFriend(String username, String friendName) {
        // makes sure friend exists in network
        if (this.socialNetwork.isAlreadyUser(friendName) == false) {
            Alert al = new Alert(AlertType.WARNING);
            al.setContentText(friendName + " is not a user in the network.");
            al.showAndWait();
            return;
        }
        // create an edge between user and friend
        this.socialNetwork.addFriends(username, friendName);
    }

    /**
     * Private helper method to remove a friend
     * 
     * @param username   is the user who's friend will be removed
     * @param friendName is the name of the friend to remove
     */
    private void removeFriend(String username, String friendName) {
        // remove edge from graph
        this.socialNetwork.removeFriends(username, friendName);
    }

    /**
     * Private helper method to view mutual friends
     * 
     * @param username   of the user
     * @param friendName of the user to see which mutual friends are shared
     */
    private void mutualFriend(String username, String friendName) {
        // create label to display username at top
        Label userLabel = new Label(
                "Mutual Friends of: " + username + " and " + friendName);

        // Create a TableView to view mutual friends
        TableView friendView = new TableView();
        TableColumn<String, Person> nameColumn =
                new TableColumn<>("First Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        friendView.setPlaceholder(new Label("No rows to display"));

        friendView.getColumns().add(nameColumn);

        // Get Set of mutual friends from SocialNetwork
        Set<Person> friends =
                this.socialNetwork.getMutualFriends(username, friendName);
        // iterate through set and add friends to TableView
        for (Person p : friends) {
            friendView.getItems().add(new Person(p.getName()));
        }

        // Adding elements to borderpane
        BorderPane bp = new BorderPane();
        bp.setTop(menuBar());
        bp.setBottom(userLabel);
        bp.setCenter(friendView);
        // Create scene, and set scene
        Scene userScreen = new Scene(bp, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(userScreen);
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
        // delete user from socialnetwork
        this.socialNetwork.removeUser(username);
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
     * 
     * @return the MenuBar with all its elements
     */
    private MenuBar setUpMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Options");

        // save actions, need to implement the save feature
        MenuItem save = new MenuItem("Save");
        save.setOnAction(e -> {
            try {
                // Closes if there has been network created
                if (this.socialNetwork == null) {
                    Platform.exit();
                    System.exit(0);
                }
                socialNetwork.saveToFile();
            } catch (IOException x) {
                System.err.println("Error saving to file.");
            }
            // Just save, don't prompt or anything

        });

        MenuItem load = new MenuItem("Load");
        load.setOnAction(e -> {
            TextInputDialog loadFile = new TextInputDialog();
            loadFile.setHeaderText("Type in file to load!");

            // user input for the file to be loaded
            Optional<String> resp = loadFile.showAndWait();

            // ensure text input has at least one character
            if (resp.get().length() == 0) {
                Alert al = new Alert(AlertType.WARNING);
                al.setContentText(
                        "File to load must have at least one character");
                al.showAndWait();
            }

            // append .txt to the end of string if the user didn't
            else if (!resp.get().contains(".txt")) {
                this.socialNetwork = new SocialNetwork(resp.get() + ".txt");
                try {
                    socialNetwork.loadFromFile();
                } catch (IOException x) {
                    System.err.println(x.getMessage());
                }
            }

            // nothing needs to be done to modify the string
            else {
                this.socialNetwork = new SocialNetwork(resp.get());
                try {
                    socialNetwork.loadFromFile();
                } catch (IOException x) {
                    System.err.println(x.getMessage());
                }
            }

        });

        // exit button prompts user to save
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> {
            Alert al = new Alert(AlertType.NONE, "Save? ", ButtonType.YES,
                    ButtonType.NO, ButtonType.CANCEL);
            Optional<ButtonType> result = al.showAndWait();
            if (result.get() == ButtonType.YES) {
                save.fire(); // calls save.getOnAction
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
>>>>>>> 23d3c9eabaa387255781a3e7da0be78a66e7869f

    private void setSelectedUser(String name) {

    }

    public static void main(String[] args) {
        launch(args);
    }

}
