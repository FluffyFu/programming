/*
 * Problem name: Helper class
 * Solve date: Mon Sep 16 22:45:35 2019
 * Time Complexity:
 * Space Complexity:
 * Notes:
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        ListNode last = new ListNode(3);
        a.next.next = last;
        while (a.next != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}

