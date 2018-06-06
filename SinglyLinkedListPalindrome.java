/*
  Given a singly linked list, determine if it is a palindrome.

  Example 1:

  Input: 1->2
  Output: false
  Example 2:

  Input: 1->2->2->1
  Output: true
*/

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode list1 = head;
        ListNode list2;

        // Find middle
        ListNode middle = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        list2 = reverseList(middle.next);

        // Check if palindrome
        while (list1 != null && list2 != null) {
            if (list1.val != list2.val)
                return false;

            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode list) {
        if (list == null || list.next == null)
            return list;

        ListNode prev = null;
        ListNode current = list;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list = prev;
        return list;
    }
}

public class SinglyLinkedListPalindrome {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new Solution().isPalindrome(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
