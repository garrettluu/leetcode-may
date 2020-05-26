class Solution {
  public:
    int findMaxLength(vector<int>& nums) {
      unordered_map<int, int> map;
      int maxL = 0;
      int count = 0;
      map[0] = -1;
      for (int i = 0; i < nums.size(); i++) {
        if (nums[i] == 0) {
          count--;
        } else {
          count++;
        }

        if (map.find(count) != map.end()) {
          maxL = max(maxL, i - map[count]);
        } else {
          map[count] = i;
        }
      }

      return maxL;
    }
};
