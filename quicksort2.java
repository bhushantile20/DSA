import java.util.Arrays;
import java.util.Scanner;

public class quicksort2
{
    private static long startTime;
     private static long endTime;

     public static void printArray(int[] arr, int n)
     {
         for(int i=0; i<n; i++)
         {
             System.out.println(arr[i]+" ");
         }
     }


     public static void quicksort(int[] arr, int low , int high)
     {
         startTime= System.nanoTime();
         if (low < high)
         {
             int pi=partition(arr, low,high);


             System.out.println("\n Array after partitioning: ");

             quicksort(arr, low ,pi-1);
             quicksort(arr, pi+1 ,high);

         }
         endTime=System.nanoTime();       
}

private static int partition(int[] arr, int low, int high)
{ 
    int pivotIndex=low+(high-low)/2;
    int pivot=arr[pivotIndex];

    int temp=arr[pivotIndex];

    int temp=arr[pivoteIndex];
    arr[pivotIndex]=arr[high];
    arr[high]=temp;


    int i=(low-1);


    for(int j=low; j<high; j++)
    {
         if(arr[j]<=pivot)

         {
             i++;

             int swap=arr[i];
             arr[i]=arr[j];
             arr[j]=swap;

         }
    }
    temp=arr[i+1];
    arr[i+1]=arr[high];
    arr[high]=temp;

    return i+1;

}

public static void main(String args[])
{
     System.out.println("Quick Sort");
     Scanner in =new Scanner(System.in);

     System.out.println("Enter the number of elements to sort");
     int n=in.nextInt();

     int[] arr=new int[n];
     
     for(int i=0; i<n; i++)
     {
         System.out.println("Enter eleent %d",(i+1));
         int ele=in.nextInt();
         arr[i]=ele;


     }
     System.out.println("The sorted array is");
     printArray(arr, n);

     in.close();


     long elapsedTime=endTime-startTime;
     System.out.println("Time complexity :o(n log n)");
     System.out.println("Execution time:"+elapsedTime+"nanaSeconds");

     System.out.println("Space complexity : o(log n)");

}


}