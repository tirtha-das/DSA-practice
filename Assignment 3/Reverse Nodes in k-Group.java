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
    public ListNode reverseLinkedList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1){
            return head;
        }
        

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int cnt = 0;
        ListNode cur = head;
        ListNode tempHead = cur;
        while(cur!=null){
           
            cnt++;
            if(cnt==k){
              ListNode next = cur.next;
              cur.next = null;
              ListNode tempTail = tempHead;
              tail.next = reverseLinkedList(tempHead);
              tail = tempTail;
              cnt=0;
              tempHead = next;
              cur = tempHead;

            }else if(cur!=null){
                cur=cur.next;
             }
        }

        tail.next = tempHead;


        return dummy.next;
    }
}