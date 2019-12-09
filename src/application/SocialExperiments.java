package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SocialExperiments {

	private SocialNetwork network; // social experiment GONE WRONG

	@BeforeEach
	void setUp() throws Exception {
		network = new SocialNetwork("Test");
	}

	@AfterEach
	void tearDown() throws Exception {
		network = null;
	}

	@Test
	void test000_writeToLogAndSave() {
		
		// perform each of the operations
		for (int i = 0; i < 20; ++i) {
			network.addUser("" + i);
		}
		
		for (int i = 0; i < 10; ++i) {
			network.addFriends("" + i, "" + i + 1);
		}
		
		for (int i = 0; i < 10; ++i) {
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

}
