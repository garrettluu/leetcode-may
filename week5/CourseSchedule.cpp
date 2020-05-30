class Solution {
  public:
    bool dfs(vector<bool>& visited, vector<bool>& explored, int cls,
        vector<vector<int>>& graph) {
      if (explored[cls]) {
        return true;
      }
      if (visited[cls]) {
        return false;
      }
      visited[cls] = true;
      for (int i = 0; i < graph[cls].size(); i++) {
        if (!dfs(visited, explored, graph[cls][i], graph)) {
          return false;
        }
      }
      visited[cls] = false;
      explored[cls] = true;
      return true;
    }
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
      vector<bool> visited(numCourses, false);
      vector<bool> explored(numCourses, false);
      vector<vector<int>> graph(numCourses, vector<int>());
      vector<int> stack;
      for (int i = 0; i < numCourses; i++) {
        stack.push_back(i);
      }

      for (int i = 0; i < prerequisites.size(); i++) {
        vector<int> edge = prerequisites[i];
        graph[edge[0]].push_back(edge[1]);
      }

      for (int i = 0; i < numCourses; i++) {
        if (!dfs(visited, explored, i, graph)) {
          return false;
        }
      }

      return true;
    }
};
