/*
 * Problem name: merge two sorted lists
 * Solve date: Sun Sep 15 23:18:18 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: meger(list1, list2) = list1.val + merge(list1.next, list2) or
 * list2.val + merge(list1, list2.next);
 */

private class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class RecursiveMerge {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    }

    public static void main() {
        ListNode a = new ListNode('s');
        a.next = new ListNode('a');
        a.next.next = new ListNode('m');
        while (a.next != null) {
            System.out.println(a.val);
        }

    }
}
