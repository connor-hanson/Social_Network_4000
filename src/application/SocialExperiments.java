package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SocialExperiments {

	private SocialNetwork network; // social experiment GONE WRONG

	@BeforeEach
	void setUp() throws Exception {
		network = new SocialNetwork();
	}

	@AfterEach
	void tearDown() throws Exception {
		network = null;
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
