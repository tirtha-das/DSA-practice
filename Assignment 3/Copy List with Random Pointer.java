/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> tracker = new HashMap<>();

        Node dummy = new Node(-1);
        Node tail = dummy;

        Node cur = head;

        while(cur!=null){
            tail.next = new Node(cur.val);
            tail = tail.next;
            tracker.put(cur,tail);
            cur = cur.next;
        }

        for(HashMap.Entry<Node,Node>it: tracker.entrySet()){
            Node original = it.getKey();
            Node copied = it.getValue();
            copied.random = tracker.get(original.random);
        }

        return dummy.next;
    }
}