package Problem_1_Merge_K_sorted_list;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * T.C.-O(n log k) ,where n is number of nodes ,k times iterating
 * S.C.-O(k)
 */
class Solution {

    /**
     * class for linked list structure
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
     * @param lists an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * @return Merge all the linked-lists into one sorted linked-list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode(0);
        PriorityQueue<ListNode> list = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode nodeList : lists) {      // adding head of all linked list
            if (nodeList != null) {
                list.offer(nodeList);
            }
        }
        ListNode tail = temp;
        while (!list.isEmpty()) {             // loop executes until queue is not empty
            ListNode minNode = list.poll();   // pops out minimum node
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                list.offer(minNode.next);
            }
        }
        return temp.next;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode result = solution.mergeKLists(lists);
        System.out.println("Merged K-Sorted Lists:");
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }
}
