class Solution {
  public int findJudge(int N, int[][] trust) {
    int[] inDegrees = new int[N];
    int[] outDegrees = new int[N];

    //compute in and out degrees
    for (int i = 0; i < trust.length; i++) {
      inDegrees[trust[i][1] - 1]++;
      outDegrees[trust[i][0] - 1]++;
    }

    //find judge based on degrees
    for (int i = 0; i < N; i++) {
      if ((inDegrees[i] == N - 1) && (outDegrees[i] == 0)) {
        return i + 1;
      }
    }

    return -1;


  }
}
