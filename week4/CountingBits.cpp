class Solution {
  public:
    int count(int num) {
      if (num == 0) {
        return 0;
      } else if (num == 1) {
        return 1;
      }
      //count the number of bits in num
      if (num % 2 == 0) {
        return count(num / 2);
      } else {
        return 1 + count((num - 1) / 2);
      }
    }
    vector<int> countBits(int num) {
      vector<int> ans;
      for (int i = 0; i <= num; i++) {
        ans.push_back(count(i));
      }

      return ans;
    }
};
