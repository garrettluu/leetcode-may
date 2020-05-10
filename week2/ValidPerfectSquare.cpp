class Solution {
  public:
    bool isPerfectSquare(int num) {
      unsigned int sumOfOdds = 0;
      int i = 1;
      while (sumOfOdds < num) {
        sumOfOdds += (2*i - 1);
        i++;
      }

      return (sumOfOdds == num);
    }
};
