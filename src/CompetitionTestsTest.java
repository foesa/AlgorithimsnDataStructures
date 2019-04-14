import org.junit.Test;

import static org.junit.Assert.assertEquals;


/*
  For Dijkstra's I used an adjacency list to represent the graph as it has better space performance,
  but checking if a vertice has an edge to another vertice isn't as efficent as an adjacency matrix.
  For FloydWarshall, I used an adjacency matrix which uses(O(V^2)) space but it requires more array access' in total,
  so being able to check if a edge exists between 2 vertices can be done in (O(1)) time.

  For checking for the shortest path in Dijkstra's I also used a Priority Queue to store the shortest path for each node to every other node.

  In terms of performance, Djikstra's is a single source shortest path algorithm (O(E log V)) but since we want to find the shortest path for every node to every
  other node, the worst case performance becomes (O(V^3 log V)).
  As for Floyd Warshall, it's all pairs shortest algorithm which means it computes the shortest path for every node to every other node, giving us a constant time complexity of
  O(V^3). If we only want the shortest path for a specific node to any other node djikstras is better but if we want all paths, Floyd Warshall works better.

  The density of the graph if sparsely populated works in the favour of Dijkstra's as the total amount of relaxes needed is reduced in a sparsely populated graph,
  as well as the space usage is reduced due to using an adjacency list being used.
  As for Floyd Warshall, A sparsely populated graph works against it as the total complexity is the same regardless of the number of vertices, but as a result of this,
  densely populated graphs take the same amount of time to compute the paths as a sparsely populated one.
 */
public class CompetitionTestsTest {

    @Test
    public void testDijkstraConstructor() {
        int minTime = new CompetitionDijkstra("/home/foesa/Downloads/1000EWD.txt", 75, 56, 87).timeRequiredforCompetition();
        assertEquals("1000 input returns 25", 25, minTime);

        minTime = new CompetitionDijkstra("/home/foesa/Downloads/tinyEWD.txt", 75, 56, 87).timeRequiredforCompetition();
        assertEquals("Tiny input returns 34", 34, minTime);

        minTime = new CompetitionDijkstra("/home/foesa/Downloads/custom.txt", 75, 56, 87).timeRequiredforCompetition();
        assertEquals("Custom input with no path returns -1", -1, minTime);

        minTime = new CompetitionDijkstra("sdfsdfasdfas", 56, 78, 57).timeRequiredforCompetition();
        assertEquals("Invalid name returns -1", minTime, -1);

        minTime = new CompetitionDijkstra(null, 56, 78, 57).timeRequiredforCompetition();
        assertEquals("Null name returns -1", minTime, -1);
    }

    @Test
    public void testFWConstructor() {
        int minTime = new CompetitionFloydWarshall("/home/foesa/Downloads/1000EWD.txt", 75, 56, 87).timeRequiredforCompetition();
        assertEquals("1000 input returns 25", minTime, 25);

        minTime = new CompetitionFloydWarshall("/home/foesa/Downloads/tinyEWD.txt", 75, 56, 87).timeRequiredforCompetition();
        assertEquals("Tiny input returns 34", minTime, 34);

        minTime = new CompetitionFloydWarshall("/home/foesa/Downloads/custom.txt", 75, 56, 87).timeRequiredforCompetition();
        assertEquals("Custom input with no path returns -1", minTime, -1);

        minTime = new CompetitionFloydWarshall("sdfsdfasdfas", 56, 78, 57).timeRequiredforCompetition();
        assertEquals("Invalid name returns -1", minTime, -1);

        minTime = new CompetitionFloydWarshall(null, 56, 78, 57).timeRequiredforCompetition();
        assertEquals("Null name returns -1", minTime, -1);
    }

}