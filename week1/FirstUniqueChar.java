class Solution {
  public int firstUniqChar(String s) {
    Map<Character, Integer> charMap = new HashMap<>();

    //populate hashmap
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      charMap.computeIfPresent(c, (k,v) -> v+1);
      charMap.computeIfAbsent(c, k -> 1);
    }

    for (int i = 0; i < s.length(); i++) {
      if (charMap.get(s.charAt(i)) == 1) {
        return i;
      }
    }

    return -1;
  }
}
