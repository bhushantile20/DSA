import java.util.Scanner;

class PrimMST {
    // Number of vertices in the graph
    private int V;

    // Constructor
    PrimMST(int v) {
        V = v;
    }

    // Function to find the vertex with the minimum key value
    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }}
        return minIndex;
    }
    // Function to print the constructed MST
    private void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }
    // Function to construct and print MST for a graph represented using adjacency matrix
    void primMST(int[][] graph) {
        // Array to store constructed MST
        int[] parent = new int[V];
        // Key values used to pick the minimum weight edge
        int[] key = new int[V];
        // To represent set of vertices included in MST
        boolean[] mstSet = new boolean[V];
        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        // Always include the first vertex in MST
        key[0] = 0; // Make key 0 so that this vertex is picked first
        parent[0] = -1; // First node is always the root of MST
        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST set
            mstSet[u] = true;
            // Update key values and parent index of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non-zero only for adjacent vertices of u
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        // Print the constructed MST
        printMST(parent, graph);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take the number of vertices as input
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        // Initialize the adjacency matrix
        int[][] graph = new int[V][V];
        // Take the adjacency matrix as input
        System.out.println("Enter the adjacency matrix (enter 0 for no edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print("Enter weight for edge [" + i + "][" + j + "]: ");
                graph[i][j] = scanner.nextInt();
            }
        }
        // Create an instance of PrimMST and compute the MST
        PrimMST t = new PrimMST(V);
        t.primMST(graph);
scanner.close();
    }
}
