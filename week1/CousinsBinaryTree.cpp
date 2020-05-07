/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
  public:
    void dfs(TreeNode* root, unordered_map<int, pair<int, int>>& dist, int parent,
        int currDist) {
      dist[root->val] = make_pair(currDist, parent);
      if (root->left != nullptr) {
        dfs(root->left, dist, root->val, currDist + 1);
      }

      if (root->right != nullptr) {
        dfs(root->right, dist, root->val, currDist + 1);
      }
    }
    bool isCousins(TreeNode* root, int x, int y) {
      //(val, dist, parent)
      unordered_map<int, pair<int, int>> dist;

      dfs(root, dist, 37237, 0);

      if (dist[x].first != dist[y].first) {
        return false;
      }

      if (dist[x].second == dist[y].second) {
        return false;
      }

      return true;
    }
};
