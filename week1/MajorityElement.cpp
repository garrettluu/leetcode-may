class Solution {
  public:
    int majorityElement(vector<int>& nums) {
      unsigned int n = nums.size();
      unordered_map<int, int> map;

      for (int i = 0; i < n; i++) {
        if (map.find(nums[i]) != map.end()) {
          map[nums[i]] = map[nums[i]] + 1;
        } else {
          map[nums[i]] = 1;
        }
      }

      for (auto i = map.begin(); i != map.end(); i++) {
        cout << i->second;
        if (i->second >= (n / 2 + 1)) {
          return i->first;
        }
      }

      return -1;
    }
};
