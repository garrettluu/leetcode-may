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
    int kthSmallestHelper(TreeNode* root, int& k) {
      int left = 0;
      int right = 0;
      if (root->left != NULL) {
        left = kthSmallestHelper(root->left, k);
      }

      if (k == 0) {
        return left;
      }

      k--;
      if (k == 0) {
        return root->val;
      }

      if (root->right != NULL) {
        right = kthSmallestHelper(root->right, k);
      }

      if (k == 0) {
        return right;
      }

      return 0;
    }
    int kthSmallest(TreeNode* root, int k) {
      return kthSmallestHelper(root, k);
    }
};
