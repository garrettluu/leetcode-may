class Solution {
  public:
    int minDistance(string word1, string word2) {
      //dp is hard :(
      int n = word1.size();
      int m = word2.size();
      int dp[n + 1][m + 1];
      if (word1 == word2) {
        return 0;
      }

      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
          if (i == 0 && j == 0) {
            dp[i][j] = 0;
          } else if (i == 0) {
            dp[i][j] = j;
          } else if (j == 0) {
            dp[i][j] = i;
          } else {
            if (word1[i-1] == word2[j-1]) {
              dp[i][j] = dp[i - 1][j - 1];
            } else {
              dp[i][j] = 1 + min(dp[i - 1][j], min(dp[i][j - 1],
                    dp[i - 1][j - 1]));
            }
          }
        }
      }

      return dp[n][m];
    }
};
