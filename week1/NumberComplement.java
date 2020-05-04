class Solution {
  public static final double LOG_2 = Math.log(2);
  public int findComplement(int num) {
    int bits = (int) (Math.log(num) / LOG_2) + 1;
    int mask = ~(0xFFFFFFFF << bits);
    return ~num & mask;
  }
}
