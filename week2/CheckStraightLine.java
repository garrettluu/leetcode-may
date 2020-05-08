class Solution {
  public boolean isParallel(int[] v1, int[] v2) {
    // computes the determinant
    // if 0 -> vectors are colinear/parallel
    return ((v1[0] * v2[1]) - (v2[0] * v1[1]) == 0);
  }
  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates.length == 2) {
      return true;
    }

    int[] slopeVector = {coordinates[1][0] - coordinates[0][0],
        coordinates[1][1] - coordinates[0][1]};

    for (int i = 2; i < coordinates.length; i++) {
      int[] currSlope = {coordinates[i][0] - coordinates[0][0],
        coordinates[i][1] - coordinates[0][1]};

      if (!isParallel(slopeVector, currSlope)) {
        return false;
      }
    }

    return true;
  }
}
