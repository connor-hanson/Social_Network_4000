package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SocialExperiments {

	private SocialNetwork network; // social experiment GONE WRONG

	@BeforeEach
	void setUp() throws Exception {
		// network = new SocialNetwork("Test");
	}

	@AfterEach
	void tearDown() throws Exception {
		network = null;
	}

	@Test
	void test000_writeToLogAndSave() {
		network = new SocialNetwork("Test.txt");

		// perform each of the operations
		for (int i = 0; i < 20; ++i) {
			network.addUser("" + i);
		}

		for (int i = 0; i < 10; ++i) {
			network.addFriends("" + i, "" + i + 1);
		}

		for (int i = 0; i < 10; ++i) {
			network.addFriends("" + 1, "" + i);
		}

		for (int i = 5; i < 10; ++i) {
			network.removeFriends("" + i, "" + i + 1);
		}

		for (int i = 10; i < 20; ++i) {
			network.removeUser("" + i);
		}

		try {
			network.saveToFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			fail("Encountered IOException while saving to file");
		}
	}

	@Test
	void test001_loadToLog() {
		try {
			network = new SocialNetwork("Test.txt");
			network.loadFromFile();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			fail("Encountered IOException while loading from file");
		}
	}

	@Test
	void test002_Connected_Components() {
		network = new SocialNetwork("Test2.txt");

		// users 1-10
		for (int i = 0; i < 10; ++i) {
			network.addUser("" + i);
		}

		// 1 -> 5-9
		for (int i = 5; i < 10; ++i) {
			network.addFriends("" + 1, "" + i);
		}

		network.addFriends("0", "2");
		network.addFriends("2", "3");
		network.addFriends("3", "4");

		Set<Graph> connectedComponents = network.getConnectedComponents();

		if (connectedComponents.size() != 2) {
			fail("There should be two connected components, but there are "
					+ connectedComponents.size());
		}
	}
	
	@Test
	void test003_shortest_path() {
		network = new SocialNetwork("Test2.txt");

		network.addUser("1");
		network.addUser("2");
		network.addUser("3");
		
		network.addFriends("1", "2");
		network.addFriends("2", "3");
		
		List<Person> list = network.getShortestPath("1", "3");
		for (Person p : list)
			System.out.println(p.getName());
		
		if (list.size() != 3)
			fail("List size should be 3");
	}

}
