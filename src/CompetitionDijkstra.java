/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class CompetitionDijkstra {

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    int noOfIntersections;
    int noOfStreets;
    Graph graph = null;
    int p1,p2,p3;
    private  double[] distTo;
    private Graph.Edge[] edges;
    private PriorityQueue<Double> pq;
    int source;
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
        this.p1 = sA;
        this.p2 = sB;
        this.p3 = sC;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("/home/foesa/Documents/numbersSorted1000.txt"));
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                if(lineNum ==1 ){
                    String[] values = line.split(" ");
                    this.noOfIntersections = Integer.parseInt(values[0]);
                    this.graph = new Graph(noOfIntersections);
                }
                else if(lineNum ==2){
                    String [] values = line.split(" ");
                    this.noOfStreets = Integer.parseInt(values[0]);
                }
                else{
                    String[] values = line.split(" ");
                    int source = Integer.parseInt(values[0]);
                    int dest = Integer.parseInt(values[1]);
                    double weight = Double.parseDouble(values[3]);
                    this.graph.addEdge(source,dest,weight);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        for(int count =0;count<graph.adjacencyList.length;count++){
            for(Graph.Edge e: graph.adjacencyList[count]){
                if(e.weight < 0){
                    throw new IllegalArgumentException("edge " + e + " has negative weight");
                }
            }
        }
        distTo = new double[graph.vertices];
        edges = new Graph.Edge[graph.vertices];



    }
    private void relax(Graph.Edge e) {
        int v = e.source, w = e.dest;
        if (distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight;
            edges[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }
    }

    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<Graph.Edge> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Graph.Edge> path = new Stack<Graph.Edge>();
        for (Graph.Edge e = edges[v]; e != null; e = edges[e.source]) {
            path.push(e);
        }
        return path;
    }

    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    

    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
        double slowest = -1;
        int curAvg = 0;
        for(int s =0;s<graph.vertices+1;s++){
            source = s;
            for (int v = 0; v < graph.vertices; v++)
                distTo[v] = Double.POSITIVE_INFINITY;
            distTo[source] = 0.0;

            pq = new PriorityQueue<Double>(graph.vertices);
            pq.insert(source, distTo[source]);
            while (!pq.isEmpty()) {
                int v = pq.delMin();
                for (Graph.Edge e : graph.adjacencyList[v])
                    relax(e);
            }

            Arrays.sort(distTo);

            if(distTo[distTo.length-1] > slowest) slowest = distTo[distTo.length-1];
        }

        int[] speeds = {p1,p2,p3};
        Arrays.sort(speeds);
        slowest = slowest*100;
         double total = slowest/(double) speeds[0];
         int rounded = (int)Math.ceil(total);
         return rounded;
    }

}