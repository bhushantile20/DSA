
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	private static long startTime;
	private static long endTime;

	public static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	// Function to perform quicksort
	public static void quicksort(int[] arr, int low, int high) {
		startTime = System.nanoTime();
		if (low < high) {
			// Partitioning index
			int pi = partition(arr, low, high);

			// Print the array after each pass
			System.out.println("\nArray after partitioning: " + Arrays.toString(arr));

			// Recursively sort elements before and after partition
			quicksort(arr, low, pi - 1);
			quicksort(arr, pi + 1, high);
		}
		endTime = System.nanoTime();
	}

	// Function to partition the array
	private static int partition(int[] arr, int low, int high) {
		// Choose pivot as the middle element
		int pivotIndex = low + (high - low) / 2;
		int pivot = arr[pivotIndex];

		// Swap pivot with the last element for convenience
		int temp = arr[pivotIndex];
		arr[pivotIndex] = arr[high];
		arr[high] = temp;

		int i = (low - 1); // Index of smaller element

		// Traverse through the array and reorder elements
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;

				// Swap arr[i] and arr[j]
				int swap = arr[i];
				arr[i] = arr[j];
				arr[j] = swap;
			}
		}

		// Swap arr[i+1] and arr[high] (pivot)
		temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1; // Return the partition index
	}

	public static void main(String[] args) {
		System.out.println("Quick Sort");
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the number of elements to be entered in array:");
		int n = in.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.printf("Enter element %d: ", (i + 1));
			int ele = in.nextInt();
			arr[i] = ele;
		}

		System.out.println("The Given Array is:");
		printArray(arr, n);

		QuickSort qs = new QuickSort();

		qs.quicksort(arr, 0, n - 1);

		System.out.println("\nThe sorted Array is:");
		printArray(arr, n);

		in.close();

		// Calculate and print time complexity
		long elapsedTime = endTime - startTime;
		System.out.println("\nTime complexity: O(n log n)");
		System.out.println("Execution time: " + elapsedTime + " nanoseconds");

		// Space complexity
		System.out.println("Space complexity: O(log n)");
	}
}
