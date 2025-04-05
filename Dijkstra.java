
import java.util.*;
 
class Dijkstra {
	private static final int INF = Integer.MAX_VALUE;
	public static int[] dijkstra(int[][] graph, int start) {
    	int n = graph.length;
    	int[] distances = new int[n];
    	boolean[] visited = new boolean[n];
    	Arrays.fill(distances, INF);
    	distances[start] = 0;
    	for (int i = 0; i < n - 1; i++) {
        	int minDist = INF, minIndex = -1;
        	for (int j = 0; j < n; j++) {
            	if (!visited[j] && distances[j] < minDist) {
                	minDist = distances[j];
                	minIndex = j;
           	}
        	}
        	if (minIndex == -1) break;
        	visited[minIndex] = true;	
        	for (int j = 0; j < n; j++) {
            	if (!visited[j] && graph[minIndex][j] != 0 && distances[minIndex] + graph[minIndex][j] < distances[j]) {
                	distances[j] = distances[minIndex] + graph[minIndex][j];
            	}
        	}
    	}
    	return distances;
	}
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter number of nodes: ");
    	int n = scanner.nextInt();
    	int[][] graph = new int[n][n];
   	
    	System.out.println("Enter adjacency matrix: ");
    	for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
            	graph[i][j] = scanner.nextInt();
        	}
    	}
    	System.out.print("Enter start node (0-based index): ");
    	int startNode = scanner.nextInt();
    	int[] shortestPaths = dijkstra(graph, startNode);
    	System.out.println("Shortest distances from node " + startNode + ":");
    	for (int i = 0; i < shortestPaths.length; i++) {
        	System.out.println("To node " + i + " -> " + (shortestPaths[i] == INF ? "INF" : shortestPaths[i]));
    	}
   	
    	scanner.close();
    	System.out.println("Time Complexity: O(n^2)");
	}
}

 
 
