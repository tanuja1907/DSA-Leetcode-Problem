package Problem_1_Add_Two_Number;

class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) { this.val = val; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode tail=head;
        int carry=0;
        while(l1!=null || l2!=null || carry==1 ){
            int addition=0;
            if(l1!=null){
                addition+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                addition+=l2.val;
                l2=l2.next;
            }
            addition+=carry;
            carry=addition/10;
            ListNode newNode=new ListNode(addition%10);
            tail.next=newNode;
            tail=tail.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" -> ");
            result = result.next;
        }
        System.out.println();
    }
}