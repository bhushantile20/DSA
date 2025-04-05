
import java.util.Scanner;

public class MergeSort {

    private static long startTime; // To calculate the execution time
    private static long endTime;

    public static void divide(int[] arr) {
        startTime = System.nanoTime();

        int len = arr.length;

        if (len < 2) {
            return;
        }

        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, len - mid);

        divide(left);
        divide(right);

        sort(arr, left, right);

        // Print the array after merging (pass)
        System.out.println("\nPasses: ");
        printArray(arr, len);

        endTime = System.nanoTime();
    }

    public static void sort(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of left[]
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy any remaining elements of right[]
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Merge Sort");

        System.out.println("Enter Array Length:");
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + i);
            arr[i] = in.nextInt();
        }

        System.out.println("The Given Array is:");
        printArray(arr, n);
        System.out.println("\n");

        divide(arr);

        System.out.println("\nSorted Array:");
        printArray(arr, n);

        // Calculate and print time complexity
        long elapsedTime = endTime - startTime;
        System.out.println("\nTime complexity: O(n log n)");
        System.out.println("Execution time: " + elapsedTime + " nanoseconds");

        // Space complexity
        System.out.println("Space complexity: O(n)");

        in.close();
    }
}