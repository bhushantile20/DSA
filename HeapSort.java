import java.util.Scanner;

public class HeapSort {
    static int comparisons = 0;
    static int swaps = 0;

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparisons++;
            if (arr[left] > arr[largest])
                largest = left;
        }
        if (right < n) {
            comparisons++;
            if (arr[right] > arr[largest])
                largest = right;
        }
        if (largest != i) {
            swaps++;
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void heapSort(int arr[], int n) {
        long startTime = System.nanoTime();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        System.out.println("\nHeap Constructed:");

        printArray(arr);
        for (int i = n - 1; i > 0; i--) {
            swaps++;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println("\nAfter pass " + (n - i) + ":");
            printArray(arr);
            heapify(arr, i, 0);
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("\nTotal Comparisons: " + comparisons);
        System.out.println("Total Swaps: " + swaps);
        System.out.println("Execution Time: " + executionTime + " nanoseconds");
    }

    static void printArray(int arr[]) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        heapSort(arr, n);
        System.out.println("\nSorted array:");
        printArray(arr);
        scanner.close();
    }
}
