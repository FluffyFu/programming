/*
 * Problem name: 2 Add two numbers
 * Solve date: Thu Oct 24 21:08:10 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Calculate the results the same way as doing the calculation by hand from the beginning of the
 *  linked list until one of the linked list is exhausted.
 */

public class SimpleAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;

        while(l1!=null && l2!=null) {
            int number = l1.val + l2.val + carry;

            if (number >= 10) {
                current.next = new ListNode(number % 10);
                carry = 1;
            }
            else {
                current.next = new ListNode(number);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }

        if (carry == 0) {
            if (l1 == null) {
                current.next = l2;
            }
            else {
                current.next = l1;
            }
        }
        else {
            if (l1 == null && l2 == null) {
               current.next = add_one_to_list(new ListNode(0), 1);
            }
            else if (l1 == null){
                current.next = add_one_to_list(l2, 1);
            }
            else {
                current.next = add_one_to_list(l1, 1);
            }
        }
        return head.next;
    }

    private ListNode add_one_to_list(ListNode l, int carry) {
        // deal with the case of adding a linked list with an integer
        ListNode head = l;
        while (carry == 1 && l.next != null) {
            if (l.val == 9) {
                l.val = 0;
                carry = 1;
                l = l.next;
            }
            else {
                l.val += 1;
                carry = 0;
            }
        }
        if (carry == 1 && l.val == 9) {
            l.val = 0;
            l.next = new ListNode(1);
        }
        else if (carry == 1) {
            l.val += 1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode res = new SimpleAddition().addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
