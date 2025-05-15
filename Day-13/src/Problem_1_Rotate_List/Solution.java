package Problem_1_Rotate_List;

/**
 * this program rotates the list kth times
 * @countNodes function calculates the total nodes in the list
 * this program uses T.C. -O(n) as we are travelling all nodes
 * S.C. is O(1) ,no extra space is using
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * n is the total nodes in the list
     * tail is the last node of list then tail.next is directed to head to make it circular
     * @param head is the head of list
     * @param k    k times rotates list to the right
     * @return     new head of the rotated list
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int n = countNodes(head);
        k = k % n;
        if (k == 0) return head;
        ListNode tail = head;
        // to make list circular
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        ListNode temp = tail;
        // to find node at the end after kth times rotation
        for (int i = 0; i < n - k; i++) {
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
    }

    int countNodes(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Before rotation list looks like:");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print("->");
            temp = temp.next;
        }
        System.out.println();
        Solution solution = new Solution();
        ListNode rotated = solution.rotateRight(head, 2);
        System.out.println("After rotation list looks like:");
        while (rotated != null) {
            System.out.print(rotated.val);
            if (rotated.next != null) System.out.print("->");
            rotated = rotated.next;
        }
    }
}
