/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast = head;
        ListNode prev = null;
        ListNode slow = null;

        int cnt = 0;

        while(fast.next!=null){
           if(cnt==n-1){
            slow = head;
           }
           fast = fast.next;
           if(slow!=null){
            prev = slow;
            slow = slow.next;
           }

           cnt++;
        }

        if(slow==null){
            return head.next;
        }

       
            prev.next = slow.next;
        

        return head;
    }
}