/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
     Stack<Node> st = new Stack<>();

    Node dummy = new Node(-1);
    Node prev = dummy;

      st.push(head);

      while(!st.isEmpty()){
        Node cur = st.pop();
        prev.next = cur;
        cur.prev = prev;
        prev = prev.next;
        if(cur.next!=null){
            Node next = cur.next;
            cur.next = null;
            next.prev = null;
            st.push(next);
        }

        if(cur.child!=null){
            Node child = cur.child;
            cur.child = null;
            st.push(child);
        }
      }

      Node newHead = dummy.next;
      newHead.prev = null;
      return newHead;

    }
}