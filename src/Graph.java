import java.util.LinkedList;

public class Graph {
    int vertices;
    LinkedList<Edge>[] adjacencyList;
    public static class Edge{
        int source;
        int dest;
        int weight;

        public Edge(int source,int dest,int weight){
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i=0;i<vertices;i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source,int dest, int weight){
        Edge newEdge = new Edge(source,dest,weight);
        adjacencyList[source].addFirst(newEdge);
    }
}
