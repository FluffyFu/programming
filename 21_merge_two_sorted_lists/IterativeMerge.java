/*
 * Problem name: Merge two lists
 * Solve date: Tue Sep 17 21:04:12 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Comparing with recursive method, iterative methods save the stack overhead and thus
 *  is more space efficient.
 */

public class IterativeMerge {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
                res = res.next;
            }
            else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
            }
        }
        if (l1 == null) {
            res.next = l2;
        }
        else {
            res.next = l1;
        }
        return pointer.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = new IterativeMerge().mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
