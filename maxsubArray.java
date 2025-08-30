class maxsubArray {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];   // store overall maximum
        int currentSum = nums[0]; // store sum of current subarray

        for (int i = 1; i < nums.length; i++) {
            // extend current subarray OR start new from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(arr));
    }
}
