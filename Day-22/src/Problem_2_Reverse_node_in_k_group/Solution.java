package Problem_2_Reverse_node_in_k_group;

/**
 *  T.C.-O(n)
 *  S.C.-O(1)
 */
class Solution {

    /**
     * Structure class for linked list
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     *
     * @param head   head of the linked list
     * @param k      no. of nodes to reverse
     * @return       the head node after reversing linked list
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode prev = temp;
        while (true) {
            ListNode kth = getKthNode(prev, k);
            if (kth == null) break;
            ListNode kNext = kth.next;

            // reverse the k-group
            ListNode prevRev = kNext;
            ListNode currRev = prev.next;
            ListNode groupStart = prev.next;

            while (currRev != kNext) {
                ListNode tempRev = currRev.next;
                currRev.next = prevRev;
                prevRev = currRev;
                currRev = tempRev;
            }
            //reconnect reversed group
            prev.next = kth;
            prev = groupStart;
        }
        return temp.next;
    }

    ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();
        ListNode newHead = solution.reverseKGroup(head, 2);
        System.out.println("Reversed linked list");
        while (newHead != null) {
            System.out.print(newHead.val);
            if (newHead.next != null) {
                System.out.print(" -> ");
            }
            newHead = newHead.next;
        }

    }
}