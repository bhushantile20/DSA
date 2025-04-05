class KruskalMST {
    // Class to represent an edge in the graph
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Comparator function to sort edges by weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // Class to represent a subset for Union-Find
    class Subset {
        int parent, rank;
    }

    private int V; // Number of vertices
    private int E; // Number of edges
    private Edge[] edges; // Array to store all edges

    // Constructor
    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    // Function to find the root of a subset
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent); // Path compression
        return subsets[i].parent;
    }

    // Function to perform union of two subsets
    private void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Union by rank
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // Function to construct and print the MST
    void kruskalMST() {
        Edge[] result = new Edge[V - 1]; // Array to store the MST
        int e = 0; // Index for result[]
        int i = 0; // Index for sorted edges

        // Sort all edges in non-decreasing order of weight
        Arrays.sort(edges);

        // Allocate memory for subsets
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        // Process all edges
        while (e < V - 1) {
            Edge nextEdge = edges[i++]; // Pick the smallest edge
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // If including this edge doesn't form a cycle, add it to the result
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        // Print the MST
        System.out.println("Kruskal's MST:");
        System.out.println("Edge \tWeight");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + "\t" + result[i].weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        KruskalMST graph = new KruskalMST(V, E);

        System.out.println("Enter the edges (source, destination, weight):");
        for (int i = 0; i < E; i++) {
            System.out.print("Edge " + (i + 1) + ": ");
            graph.edges[i].src = scanner.nextInt();
            graph.edges[i].dest = scanner.nextInt();
            graph.edges[i].weight = scanner.nextInt();
        }

        // Run Kruskal's algorithm
        graph.kruskalMST();

        scanner.close();
    }
}
