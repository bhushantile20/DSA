class Insertion {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("Before sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int low = 0;
        int high = n - 1;
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("After sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
