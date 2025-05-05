package Problem_2_remove_nth_from_end;


class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }

    }
    static class LinkedListAdd {
        ListNode head,tail;
        void add(int val) {

            ListNode listNode = new ListNode(val);
            if(head==null){
                head=listNode;
            }else{
                tail.next=listNode;
            }
            tail=listNode;
        }
        ListNode getHead(){
            return head;
        }
    }
// 🚨two pass approach: 😢
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int length=calculateLength(head);
//        if(length==n){
//            ListNode temp=head.next;
//            head=null;
//            return temp;
//        }
//        ListNode temp=head;
//        ListNode prev=null;
//        int index=length-n;
//        while(index-->0){
//            prev=temp;
//            temp=temp.next;
//
//        }
//        if(prev!=null){
//            prev.next= temp.next;
//        }
//        return head;
//
//    }
//    int calculateLength(ListNode head){
//        int length=0;
//        while(head!=null){
//            length++;
//            head=head.next;
//        }
//        return length;
//    }

    // one pass aproach
    // T.C.-0(n)
    // S.C.-O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next==null){
            return null;
        }
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode fast=temp;
        ListNode slow=temp;

        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        LinkedListAdd l1=new LinkedListAdd();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        Solution sol=new Solution();
        ListNode newHead=sol.removeNthFromEnd(l1.getHead(),2);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }
}