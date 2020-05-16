/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    // If list is size one, we done
    if (head.next == null) {
      return head;
    }

    // Get the first even node (useful later)
    ListNode firstEven = head.next;

    ListNode currNode = head;
    boolean isEven = false;
    while (currNode.next != null) {
      ListNode nextNode = currNode.next;

      if (nextNode.next != null) {
        currNode.next = nextNode.next;
      } else {
        if (!isEven) {
          currNode.next = firstEven;
        } else {
          currNode.next = null;
        }
      }

      currNode = nextNode;
      isEven = !isEven;
    }

    if (!isEven) {
      currNode.next = firstEven;
    }

    return head;

  }
}
