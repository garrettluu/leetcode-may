class Solution {
  public:
    unordered_map<int, bool> color;
    unordered_map<int, vector<int>> adjacencyList;
    bool possibleBipartition(int N, vector<vector<int>>& dislikes) {
      // color
      // true = white
      // false = black


      for (int i = 1; i <= N; i++) {
        adjacencyList[i] = vector<int>();
      }

      for (int i = 0; i < dislikes.size(); i++) {
        adjacencyList[dislikes[i][0]].push_back(dislikes[i][1]);
        adjacencyList[dislikes[i][1]].push_back(dislikes[i][0]);
      }

      for (int i = 1; i <= N; i++) {
        if ((color.find(i) == color.end()) && !dfs(i, false)) {
          return false;
        }
      }

      return true;
    }

    bool dfs(int v, bool c) {
      if (color.find(v) != color.end()) {
        return color[v] == c;
      }

      color[v] = c;

      for (int i = 0; i < adjacencyList[v].size(); i++) {
        if (!dfs(adjacencyList[v][i], !c)) {
          return false;
        }
      }
      return true;
      
    }

};
