
import java.util.Scanner;
public class FloydWarshall {
   // Method to implement Floyd-Warshall Algorithm
   public static void floydWarshall(int[][] graph, int V) {
       // dist[][] will hold the shortest distance between every pair of vertices
       int[][] dist = new int[V][V];
       // Initialize the solution matrix to the graph's adjacency matrix
       for (int i = 0; i < V; i++) {
           for (int j = 0; j < V; j++) {
               if (i == j) {
                   dist[i][j] = 0; // Distance to itself is 0
               } else if (graph[i][j] != 0) {
                   dist[i][j] = graph[i][j]; // Use given weight if available
               } else {
                   dist[i][j] = Integer.MAX_VALUE; // No path between vertices
               }
           }
       }
       // Floyd-Warshall algorithm
       for (int k = 0; k < V; k++) {
           for (int i = 0; i < V; i++) {
               for (int j = 0; j < V; j++) {
                   if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                       dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                   }
               }
           }
       }
       // Print the shortest distance matrix
       System.out.println("Shortest distance matrix:");
       for (int i = 0; i < V; i++) {
           for (int j = 0; j < V; j++) {
               if (dist[i][j] == Integer.MAX_VALUE) {
                   System.out.print("INF ");
               } else {
                   System.out.print(dist[i][j] + " ");
               }
           }
           System.out.println();
       }
   }
   // Main method to take input from the user and run the algorithm
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the number of vertices: ");
       int V = scanner.nextInt();
       int[][] graph = new int[V][V];
       System.out.println("Enter the adjacency matrix (use 0 for no direct edge and other numbers for weights):");
       for (int i = 0; i < V; i++) {
           for (int j = 0; j < V; j++) {
               graph[i][j] = scanner.nextInt();
           }
       }
       long startTime = System.nanoTime();
       floydWarshall(graph, V);
       long endTime = System.nanoTime();
       // Calculate the time taken for the algorithm
       long duration = endTime - startTime;
       System.out.println("Time taken to execute Floyd-Warshall algorithm: " + duration + " nanoseconds");
       // Space complexity is O(V^2) since we store the distance matrix
       System.out.println("Space complexity: O(V^2)");
       System.out.println("Time complexity: O(V^3) due to the three nested loops.");
   }
}
