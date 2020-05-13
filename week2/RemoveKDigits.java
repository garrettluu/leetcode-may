class Solution {
  public int digitAt(String num, int i) {
    return Integer.parseInt(num.charAt(i) + "");
  }
  public String removeKdigits(String num, int k) {
    Stack<Integer> stack = new Stack<>();

    stack.push(digitAt(num, 0));

    for (int i = 1; i < num.length(); i++) {
      int current = digitAt(num, i);
      if (k > 0) {
        while (!stack.empty() && current < stack.peek() && k > 0) {
          stack.pop();
          k--;
        }
        if (current != 0 || !stack.empty()) {
          stack.push(current);
        }
      } else {
        stack.push(current);
      }
    }

    while (k > 0) {
      if (!stack.empty()) {
        stack.pop();
      }
      k--;
    }

    String result = "";

    for (int i = 0; i < stack.size(); i++) {
      result = result + ("" + stack.get(i));
    }

    if (result == "") {
      return "0";
    }
    return result;
  }
}
