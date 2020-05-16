class Solution {
  public int maxSubarraySumCircular(int[] A) {
    int localMax = A[0];
    int localMin = A[0];
    int globalMax = Integer.MIN_VALUE;
    int globalMin = Integer.MAX_VALUE;

    int totalSum = A[0];

    if (A.length == 1) {
      return A[0];
    }

    for (int i = 1; i < A.length; i++) {
      totalSum+=A[i];
      localMax = Math.max(A[i], A[i] + localMax);
      localMin = Math.min(A[i], A[i] + localMin);
      if (localMax > globalMax) {
        globalMax = localMax;
      }

      if (localMin < globalMin) {
        globalMin = localMin;
      }
    }

    if (globalMin == totalSum) {
      return globalMax;
    }

    return Math.max(globalMax, totalSum - globalMin);
  }
};
