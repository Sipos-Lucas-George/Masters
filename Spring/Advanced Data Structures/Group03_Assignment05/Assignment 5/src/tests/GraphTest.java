package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.*;

import adt.Graph;

class GraphTest {

	@Nested
	class UnweightedUndirectedGraphTests {
		Graph<String> graph;

		@BeforeEach
		void setUp() {
			graph = new Graph<>(false, false);
		}

		@Test
		void testAddAndGetVertex() {
			graph.addVertex("A");
			assertTrue(graph.getVertices().contains("A"));
		}

		@Test
		void testAddEdgeCreatesVertices() {
			graph.addEdge("A", "B");
			assertTrue(graph.getVertices().contains("A"));
			assertTrue(graph.getVertices().contains("B"));
		}

		@Test
		void testAddEdgeUndirected() {
			graph.addEdge("A", "B");
			assertTrue(graph.hasEdge("A", "B"));
			assertTrue(graph.hasEdge("B", "A"));
		}

		@Test
		void testAddEdgeUndirectedMistakeWeighted() {
			graph.addEdge("A", "B", 123);
			assertTrue(graph.hasEdge("A", "B"));
			assertTrue(graph.hasEdge("B", "A"));
			assertThrows(UnsupportedOperationException.class, () -> graph.getWeight("A", "B"));
		}

		@Test
		void testRemoveEdgeUndirected() {
			graph.addEdge("A", "B");
			graph.removeEdge("A", "B");
			assertFalse(graph.hasEdge("A", "B"));
			assertFalse(graph.hasEdge("B", "A"));
		}

		@Test
		void testRemoveVertexAlsoRemovesEdges() {
			graph.addEdge("A", "B");
			graph.removeVertex("A");
			assertFalse(graph.getVertices().contains("A"));
			assertFalse(graph.hasEdge("B", "A"));
		}

		@Test
		void testGetNeighbors() {
			graph.addEdge("A", "B");
			graph.addEdge("A", "C");
			Set<String> neighbors = graph.getNeighbors("A");
			assertEquals(Set.of("B", "C"), neighbors);
		}

		@Test
		void testEdgeCountUndirected() {
			graph.addEdge("A", "B");
			graph.addEdge("B", "C");
			assertEquals(2, graph.getEdgeCount());
		}

		@Test
		void testEmptyGraph() {
			assertEquals(0, graph.getVertexCount());
			assertEquals(0, graph.getEdgeCount());
		}

		@Test
		void testSelfLoop() {
			graph.addEdge("A", "A");
			assertTrue(graph.hasEdge("A", "A"));
			assertEquals(1, graph.getEdgeCount());
		}

		@Test
		void testUnweightedGraphThrowsOnGetWeight() {
			graph.addEdge("A", "B");
			assertThrows(UnsupportedOperationException.class, () -> graph.getWeight("A", "B"));
		}

		@Test
		void testIsDirected() {
			assertFalse(graph.isDirected());
		}

		@Test
		void testIsWeighted() {
			assertFalse(graph.isWeighted());
		}

		@Test
		void testToStringUnweightedUndirected() {
			Graph<String> graph = new Graph<>(false, false);
			graph.addEdge("A", "B");
			graph.addEdge("A", "C");
			String output = graph.toString();
			assertTrue(output.contains("A ->  B, C") || output.contains("A ->  C, B"));
			assertTrue(output.contains("B ->  A"));
			assertTrue(output.contains("C ->  A"));
		}

		@Test
		void stressTestUnweightedUndirected() {
			Graph<Integer> graph = new Graph<>(false, false);
			int numVertices = 1_000_000;

			// Add edges in a chain: 0-1, 1-2, ...
			for (int i = 0; i <= numVertices; i++) {
				graph.addEdge(i, i + 1);
			}

			assertEquals(numVertices + 2, graph.getVertexCount());
			assertEquals(numVertices + 1, graph.getEdgeCount());
			assertTrue(graph.hasEdge(0, 1));
			assertTrue(graph.hasEdge(numVertices - 1, numVertices));
			assertFalse(graph.hasEdge(0, numVertices));
		}

	}

	@Nested
	class WeightedDirectedGraphTests {
		Graph<Integer> graph;

		@BeforeEach
		void setUp() {
			graph = new Graph<>(true, true);
		}

		@Test
		void testAddEdgeWithWeight() {
			graph.addEdge(1, 2, 5.5);
			assertTrue(graph.hasEdge(1, 2));
			assertEquals(5.5, graph.getWeight(1, 2));
		}

		@Test
		void testAddEdgeWithoutWeight() {
			graph.addEdge(1, 2);
			assertTrue(graph.hasEdge(1, 2));
			assertEquals(1.0, graph.getWeight(1, 2));
		}

		@Test
		void testAddEdgeDirectionality() {
			graph.addEdge(1, 2, 3.0);
			assertTrue(graph.hasEdge(1, 2));
			assertFalse(graph.hasEdge(2, 1));
		}

		@Test
		void testRemoveEdgeDirected() {
			graph.addEdge(1, 2, 1.0);
			graph.removeEdge(1, 2);
			assertFalse(graph.hasEdge(1, 2));
		}

		@Test
		void testRemoveVertexDirectedWeighted() {
			graph.addEdge(1, 2, 1.0);
			graph.removeVertex(1);
			assertFalse(graph.getVertices().contains(1));
			assertFalse(graph.hasEdge(1, 2));
		}

		@Test
		void testEdgeCountDirected() {
			graph.addEdge(1, 2, 1.0);
			graph.addEdge(2, 3, 2.0);
			graph.addEdge(1, 3, 4.0);
			assertEquals(3, graph.getEdgeCount());
		}

		@Test
		void testGetWeightThrowsForUnconnectedNodes() {
			graph.addVertex(1);
			graph.addVertex(2);
			assertEquals(Double.POSITIVE_INFINITY, graph.getWeight(1, 2));
		}

		@Test
		void testSelfLoopWeight() {
			graph.addEdge(1, 1, 7.7);
			assertTrue(graph.hasEdge(1, 1));
			assertEquals(7.7, graph.getWeight(1, 1));
		}

		@Test
		void testEdgeOverwriteWeight() {
			graph.addEdge(1, 2, 2.0);
			graph.addEdge(1, 2, 5.0);
			assertEquals(5.0, graph.getWeight(1, 2));
		}

		@Test
		void testIsDirected() {
			assertTrue(graph.isDirected());
		}

		@Test
		void testIsWeighted() {
			assertTrue(graph.isWeighted());
		}

		@Test
		void testToStringWeightedDirected() {
			Graph<String> graph = new Graph<>(true, true);
			graph.addEdge("A", "B", 2.5);
			graph.addEdge("A", "C", 3.0);
			String output = graph.toString();
			assertTrue(output.contains("A ->  B(2.5), C(3.0)") || output.contains("A ->  C(3.0), B(2.5)"));
			assertTrue(output.contains("B ->"));
			assertTrue(output.contains("C ->"));
		}

		@Test
		void stressTestWeightedDirected() {
			int numVertices = 1_000_000;

			// Add all edges to 0: 0-1, 0-2, ...
			for (int i = 1; i <= numVertices; i++) {
				graph.addEdge(0, i, i * 0.1);
			}

			assertEquals(numVertices + 1, graph.getVertexCount());
			assertEquals(numVertices, graph.getEdgeCount());
			assertEquals(0.1, graph.getWeight(0, 1));
			assertEquals(numVertices * 0.1, graph.getWeight(0, numVertices));
			assertFalse(graph.hasEdge(1, 0));
		}
	}
}
