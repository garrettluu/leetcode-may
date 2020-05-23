class Solution {
  public:
    string frequencySort(string s) {
      map<char, int> charMap;
      for (int i = 0; i < s.length(); i++) {
        charMap[s[i]]++;
      }

      map<int, vector<char>, greater<int>> counts;

      for (auto i = charMap.begin(); i != charMap.end(); i++) {
        counts[i->second].push_back(i->first);
      }

      string result = "";

      for (auto i = counts.begin(); i != counts.end(); i++) {
        for (int k = 0; k < i->second.size(); k++) {
          for (int j = 0; j < i->first; j++) {
            result += (i->second)[k];
          }
        }
      }


      return result;
    }
};
