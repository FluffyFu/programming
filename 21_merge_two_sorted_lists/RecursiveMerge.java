/*
 * Problem name: merge two sorted lists
 * Solve date: Sun Sep 15 23:18:18 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: meger(list1, list2) = list1.val + merge(list1.next, list2) or
 *  list2.val + merge(list1, list2.next);
 *  At each recursion step, a new ListNode is created.
 */


public class RecursiveMerge {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val <= l2.val) {
            ListNode node = new ListNode(l1.val);
            node.next = mergeTwoLists(l1.next, l2);
            return node;
        }
        else {
            ListNode node = new ListNode(l2.val);
            node.next = mergeTwoLists(l1, l2.next);
            return node;
    }
}


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(2);

        ListNode res = new RecursiveMerge().mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
