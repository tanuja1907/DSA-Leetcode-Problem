package Problem_3_Palindrome_Linked_List;
import java.util.Stack;

public class Palindrome {
    static class ListNode {
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


    public boolean isPalindrome(ListNode head) {
            Stack<Integer> stack=new Stack<>();
            ListNode curr=head;
            while(curr!=null){
                stack.push(curr.val);
                curr=curr.next;
            }
            curr=head;
            while(curr!=null){
                if(curr.val != stack.pop())return false;
                curr=curr.next;
            }
            return true;
        }

    public static void main(String[] args) {
        Palindrome palindrome=new Palindrome();
        LinkedListAdd  l1=new LinkedListAdd();
        l1.add(5);
        l1.add(9);
        l1.add(2);
        l1.add(5);
        System.out.println(palindrome.isPalindrome(l1.getHead()));
    }
    }

