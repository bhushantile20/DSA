import java.util.Scanner;
 
public class BST {
	private static long startTime;
	private static long endTime;
	public static void printArray(int[] arr, int n) {
    	for (int i = 0; i < n; i++) {
        	System.out.print(arr[i] + " ");
    	}
	}
	public int search(int[] arr, int low, int high, int key) {
        startTime = System.nanoTime();
 
    	if (high >= low) {
            int mid = low + (high - low) / 2;
 
        	// If the element is present at the middle itself
        	if (arr[mid] == key) {
                endTime = System.nanoTime();
                return mid;
        	}

        	// If element is smaller than mid, then it can only be present in left subarray
        	if (arr[mid] > key) {
                return search(arr, low, mid - 1, key);
        	}

        	// Else the element can only be present in right subarray
            return search(arr, mid + 1, high, key);
    	}
    	// We reach here when element is not present in array
        endTime = System.nanoTime();
    	return -1;
	}
	public static void main(String[] args) {
    	// TODO Auto-generated method stub
        System.out.println("Binary Search");
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
 
        System.out.println("\nEnter key to be searched:");
    	int key = in.nextInt();
 
    	BST bst = new BST();
    	int res = bst.search(arr, 0, n - 1, key);
        System.out.println("The index of key in array is: " + res);
 
        in.close();
 
    	// Calculate and print time complexity
    	long elapsedTime = endTime - startTime;
        System.out.println("\nTime complexity: O(log n)");
        System.out.println("Execution time: " + elapsedTime + " nanoseconds");
 
    	// Space complexity
        System.out.println("Space complexity: O(log n)");
	}
}

 
