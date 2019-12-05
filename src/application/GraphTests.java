package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTests {

	private static Graph graph;

	@BeforeEach
	void setUp() throws Exception {
		graph = new Graph();
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void test000_add_5_nodes() {
		for (int i = 0; i < 5; ++i) {
			Person p = new Person("" + i, "" + i);
			if (!graph.addNode(p)) {
				fail("Graph failed to add a person named " + i);
			}
		}
	}

	@Test
	void test001_add_5_nodes_with_edges() {
		for (int i = 0; i < 5; ++i) {
			Person p = new Person("" + i, "" + i);
			graph.addNode(p);
		}

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				Person p1 = new Person("" + i, "" + i);
				Person p2 = new Person("" + j, "" + j);

				if (!graph.addEdge(p1, p2)) {
					fail("Failed to add an edge between person " + i + " and "
							+ j);
				}
			}
		}
	}

}
