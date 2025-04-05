
import java.util.Scanner;

public class Knapsack {
    // Function to solve 0/1 Knapsack and print DP table
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        // Print DP Table in tabular format
        System.out.println("\nKnapsack DP Table:");

        // Print column headers (weights)
        System.out.print("Items ↓ / Capacity → | ");
        for (int w = 0; w <= W; w++) {
            System.out.printf("%3d ", w);
        }
        System.out.println("\n" + "-".repeat(100)); // Separator line

        // Print table rows
        for (int i = 0; i <= n; i++) {
            System.out.printf("Item %d          	| ", i);
            for (int w = 0; w <= W; w++) {
                System.out.printf("%3d ", dp[i][w]);
            }
            System.out.println();
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        System.out.println("Enter values and weights of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
        }
        System.out.print("Enter the knapsack capacity: ");
        int W = scanner.nextInt();
        int maxProfit = knapsack(W, weights, values, n);
        System.out.println("\nMaximum value in Knapsack: " + maxProfit);
        scanner.close();
    }
}
