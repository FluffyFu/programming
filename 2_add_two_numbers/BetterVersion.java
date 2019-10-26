/*
 * Problem name: 2 Add two numbers;
 * Solve date: Sat Oct 26 09:33:19 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Cleaner way to perform the addition.
 */

public class BetterVersion {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode sentinel = new ListNode(0);
        ListNode current = sentinel;

        while (l1 != null || l2 != null) {
            sum /= 10;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (sum >= 10) current.next = new ListNode(1);

        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode res = new BetterVersion().addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
