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
 * This class implements the competition using Floyd-Warshall algorithm
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CompetitionFloydWarshall {

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     * @author Efeosa Louis Eguavoen
     */
    private double[][] adjacencyMatrix = null;
     private int noOfIntersections = 0;
    private int noOfStreets;
    private int p1,p2,p3;
    CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
        p1 = sA;
        p2 = sB;
        p3 = sC;

        if(filename != null){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                int lineNum = 1;
                while ((line = reader.readLine()) != null) {
                    if(lineNum ==1 ){
                        String[] values = line.split(" ");
                        this.noOfIntersections = Integer.parseInt(values[0]);
                        this.adjacencyMatrix = new double[noOfIntersections][noOfIntersections];
                        for(int count =0;count<noOfIntersections;count++){
                            for(int count2 =0;count2<noOfIntersections;count2++){
                                if(count == count2){
                                    this.adjacencyMatrix[count][count2]=0;
                                }else
                                    this.adjacencyMatrix[count][count2] = Double.POSITIVE_INFINITY;
                            }
                        }
                    }
                    else if(lineNum ==2){
                        String [] values = line.split(" ");
                        this.noOfStreets = Integer.parseInt(values[0]);
                    }
                    else{
                        String[] values = line.trim().split("\\s+");
                        if(line.length()>0) {
                            if (values.length > 1) {
                                int source = Integer.parseInt(values[0]);
                                int dest = Integer.parseInt(values[1]);
                                double weight = Double.parseDouble(values[2]);
                                this.adjacencyMatrix[source][dest] = weight;
                            }
                        }
                    }
                    lineNum++;


                }
            }
            catch (FileNotFoundException e) {
                adjacencyMatrix = null;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            adjacencyMatrix = null;
        }

    }


    /**
     * @return int: minimum minutes that will pass before  the three contestants can meet
     */
    public int timeRequiredforCompetition(){
        if(adjacencyMatrix == null){
            return -1;
        }
        int inf = 0;
        for(int count =0;count<noOfIntersections;count++){
            if(adjacencyMatrix[count][noOfIntersections-1] == Double.POSITIVE_INFINITY){
                inf++;
            }
        }
        if(inf == noOfIntersections-1){
            return -1;
        }
        for (int k = 0; k < noOfIntersections; k++)
        {
            for (int i = 0; i < noOfIntersections; i++)
            {
                for (int j = 0; j < noOfIntersections; j++)
                {
                    if (adjacencyMatrix[i][k] + adjacencyMatrix[k][j] < adjacencyMatrix[i][j])
                        adjacencyMatrix[i][j] = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
                }
            }
        }
        double max =0;
        for(int i =0;i<noOfIntersections;i++){
            for(int j=0;j<noOfIntersections;j++){
                if(adjacencyMatrix[i][j]> max && adjacencyMatrix[i][j] != Double.POSITIVE_INFINITY){
                    max = adjacencyMatrix[i][j];
                }
            }
        }

        int[] speeds = {p1,p2,p3};
        Arrays.sort(speeds);
        max = max*1000;
        double total = max/(double) speeds[0];
        int rounded = (int)Math.ceil(total);
        return rounded;
        }
}