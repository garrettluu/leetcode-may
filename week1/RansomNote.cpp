class Solution {
  public:
    bool canConstruct(string ransomNote, string magazine) {
      unordered_map<char, int> map;

      for (int i = 0; i < magazine.length(); i++) {
        map[magazine[i]] = ++map[magazine[i]];
      }

      for (int i = 0; i < ransomNote.length(); i++) {
        map[ransomNote[i]] = --map[ransomNote[i]];
        if (map[ransomNote[i]] < 0) {
          return false;
        }
      }

      return true;
    }
};
