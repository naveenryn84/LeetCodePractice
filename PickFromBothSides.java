public class PickFromBothSides {
        public int solve(int[] A, int B) {
            // Step 1: Initialize variables
            int n = A.length;
            int maxSum = Integer.MIN_VALUE;

            // Step 2: Calculate prefix sum for the first B elements
            int currentSum = 0;
            for (int i = 0; i < B; i++) {
                currentSum += A[i];
            }
            maxSum = currentSum;

            // Step 3: Calculate suffix sum and keep adjusting the sum
            for (int i = 0; i < B; i++) {
                currentSum = currentSum - A[B - 1 - i] + A[n - 1 - i];
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
        }

    public static void main(String[] args) {
        PickFromBothSides obj = new PickFromBothSides();
        int[] A = {5, -2, 3 , 2, 2};
    System.out.println(obj.solve(A, 3));
    }

}
