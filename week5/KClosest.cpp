struct ClosestComparator {
  bool operator ()(const vector<int>& p1, const vector<int>& p2) {
    int d1 = pow(p1[0], 2) + pow(p1[1], 2);
    int d2 = pow(p2[0], 2) + pow(p2[1], 2);

    return d1 > d2;
  }
};
class Solution {
  public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
      vector<vector<int>> result;
      priority_queue<vector<int>, vector<vector<int>>, ClosestComparator> pq;

      for (int i = 0; i < points.size(); i++) {
        pq.push(points[i]);
      }

      for (int i = 0; i < K; i++) {
        result.push_back(pq.top());
        pq.pop();
      }

      return result;
    }
};
