/*
 * Problem name: 83 remove duplicates from linked list
 * Solve date: Tue Oct  8 21:33:40 2019
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Notes: maintain two pointers a, b which both starts from the left. b keeps moving until a and b
 *  differs. Then set a.next = b, moves a to b. Keep doing this until b hits the end. Set a.next = None.
 */

public class TwoPointer {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        if (head.next==null) return head;
        else {
            ListNode a = head;
            ListNode b = head.next;
            while (b != null) {
                if (b.val != a.val) {
                    a.next = b;
                    a = b;
                }
                b = b.next;
            }
            a.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        // head.next.next.next = null;

        TwoPointer tp = new TwoPointer();
        ListNode res = tp.deleteDuplicates(head);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
