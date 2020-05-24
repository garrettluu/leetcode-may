class Solution {
  public:
    bool inInterval(int x, vector<int>& I) {
      return (x >= I[0] && x <= I[1]);
    }
    vector<vector<int>> intervalIntersection(vector<vector<int>>& A, vector<vector<int>>& B) {
      int i = 0;
      int j = 0;

      vector<vector<int>> ans;

      while (i < A.size() && j < B.size()) {
        int lo = max(A[i][0], B[j][0]);
        int hi = min(A[i][1], B[j][1]);

        if (lo <= hi) {
          vector<int> interval;
          interval.push_back(lo);
          interval.push_back(hi);
          ans.push_back(interval);
        }

        if (A[i][1] < B[j][1]) {
          i++;
        } else {
          j++;
        }

      }
      return ans;
    }
};
