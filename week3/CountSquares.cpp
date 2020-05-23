class Solution {
  public:
    int countSquares(vector<vector<int>>& matrix) {
      if (matrix.size() == 0) {
        return 0;
      }

      if (matrix.size() == 1) {
        int sq = 0;
        for (int i = 0; i < matrix[0].size(); i++) {
          sq += matrix[0][i];
        }
        return sq;
      }

      int length = matrix.size();
      int width = matrix[0].size();
      int squares = 0;
      int updated = 0;

      for (int i = 0; i < length; i++) {
        for (int j = 0; j < width; j++) {
          if (matrix[i][j] == 1) {
            if (i == 0 || j == 0) {
              squares++;
            } else {
              updated = min(min(matrix[i-1][j-1], matrix[i][j-1]),
                  matrix[i-1][j]) + matrix[i][j];

              squares += updated;
              matrix[i][j] = updated;
            }
          }
        }
      }

      return squares;
    }
};
