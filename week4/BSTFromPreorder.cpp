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
    TreeNode* bstFromPreorder(vector<int>& preorder) {
      if (preorder.size() == 0) {
        return nullptr;
      }
      TreeNode* result = new TreeNode(preorder[0]);

      if (preorder.size() > 1) {
        int leftStart = 1;

        int i = leftStart;
        vector<int> leftSubtree;
        while (i < preorder.size() && preorder[i] < preorder[0]) {
          leftSubtree.push_back(preorder[i]);
          i++;
        }

        vector<int> rightSubtree;
        while (i < preorder.size()) {
          rightSubtree.push_back(preorder[i]);
          i++;
        }

        if (leftSubtree.size() > 0) {
          result->left = bstFromPreorder(leftSubtree);
        }

        if (rightSubtree.size() > 0) {
          result->right = bstFromPreorder(rightSubtree);
        }
      }

      return result;
    }
};
