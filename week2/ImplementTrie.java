class TrieNode {
  char c;
  TrieNode left;
  TrieNode mid;
  TrieNode right;
  boolean isWord;

  public TrieNode(char c) {
    this.c = c;
  }
}
class Trie {
  int size = 0;
  TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode currNode = root;
    if (size == 0) {
      for (int i = 0; i < word.length(); i++) {
        currNode = new TrieNode(word.charAt(i));
        if (i != word.length() - 1) {
          currNode = currNode.mid;
        } else {
          size++;
          currNode.isWord = true;
        }
      }
    } else {
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (currNode != null) {
          if (c == currNode.c) {
            if (i != word.length() - 1) {
              currNode = currNode.mid;
            } else {
              currNode.isWord = true;
              size++;
            }
          } else if (c > currNode.c) {
            currNode = currNode.right;
            i--;
          } else if (c < currNode.c) {
            currNode = currNode.left;
            i--;
          }
        } else {
          currNode = new TrieNode(c);
          if (i != word.length() - 1) {
            currNode = currNode.mid;
          }
        }
      }
    }
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode currNode = root;

    if (size == 0) {
      return false;
    }

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (currNode != null) {
        if (c == currNode.c) {
          if (i != word.length() - 1) {
            currNode = currNode.mid;
          } else {
            return currNode.isWord;
          }
        } else if (c < currNode.c) {
          currNode = currNode.left;
          i--;
        } else if (c > currNode.c) {
          currNode = currNode.right;
          i--;
        }
      } else {
        return false;
      }
    }

    return false;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode currNode = root;

    if (size == 0) {
      return false;
    }

    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (currNode != null) {
        if (c == currNode.c) {
          if (i != prefix.length() - 1) {
            currNode = currNode.mid;
          }
        } else if (c < currNode.c) {
          currNode = currNode.left;
          i--;
        } else if (c > currNode.c) {
          currNode = currNode.right;
          i--;
        }
      } else {
        return false;
      }
    }

    return containsWordNode(currNode);
  }

  private boolean containsWordNode(TrieNode start) {
    boolean left = false;
    boolean right = false;
    boolean mid = false;
    if (start.isWord) {
      return true;
    }

    if (start.left != null) {
      left = containsWordNode(start.left);
      if (left) {
        return true;
      }
    }
    if (start.mid != null) {
      mid = containsWordNode(start.mid);
      if (mid) {
        return true;
      }
    }
    if (start.right != null) {
      right = containsWordNode(start.right);
      if (right) {
        return true;
      }
    }

    return false;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
