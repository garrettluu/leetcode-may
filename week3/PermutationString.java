class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int[] s1Map = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      s1Map[s1.charAt(i) - 'a']++;
    }

    int left = 0;
    int right = s1.length();

    while (right <= s2.length()) {
      int[] subMap = new int[26];
      String substring = s2.substring(left, right);

      for (int i = 0; i < substring.length(); i++) {
        subMap[substring.charAt(i) - 'a']++;
      }

      if (Arrays.equals(s1Map, subMap)) {
        return true;
      }

      left++;
      right++;
    }

    return false;

  }
}
