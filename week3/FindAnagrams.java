class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int[] pMap = new int[26];

    int length = p.length();

    int left = 0;
    int right = p.length();

    for (int i = 0; i < length; i++) {
      pMap[p.charAt(i) - 'a']++;
    }

    while (right <= s.length()) {
      int[] sMap = new int[26];
      String substring = s.substring(left, right);

      for (int i = 0; i < length; i++) {
        sMap[substring.charAt(i) - 'a']++;
      }

      if (Arrays.equals(sMap, pMap)) {
        result.add(left);
      }

      left++;
      right++;
    }

    return result;

  }
}
