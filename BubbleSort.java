public class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }

    public static void main(String args[]){
                BubbleSort ob=new BubbleSort();
                int a[]={64,55,35,76};
                ob.bubbleSort(a);

                int n=a.length;
                for(int i=0;i<n;++i)
                    System.out.println(a[i]+" ");

                    System.out.println();
                
                
            }
        }
        
