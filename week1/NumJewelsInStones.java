class Solution {
  public int numJewelsInStones(String J, String S) {
    int numJewels = 0;
    // construct hashmap of jewels
    Map<Character, Character> jewels = new HashMap<>();
    for (int i = 0; i < J.length(); i++) {
      jewels.put(J.charAt(i), J.charAt(i));
    }

    // loop through S and look up if each char is a jewel
    for (int i = 0; i < S.length(); i++) {
      if (jewels.containsKey(S.charAt(i))) {
        numJewels++;
      }
    }

    return numJewels;


  }
}
