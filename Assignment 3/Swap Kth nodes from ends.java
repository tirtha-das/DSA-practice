class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return null;

        // Step 1: count length
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        if (k > n) return head;  // invalid
        if (2 * k - 1 == n) return head; // same node

        Node dummy = new Node(-1);
        dummy.next = head;

        // Step 2: find kth from start
        Node prev1 = dummy, node1 = head;
        for (int i = 1; i < k; i++) {
            prev1 = node1;
            node1 = node1.next;
        }

        // Step 3: find kth from end
        Node prev2 = dummy, node2 = head;
        for (int i = 1; i < n - k + 1; i++) {
            prev2 = node2;
            node2 = node2.next;
        }

        // Step 4: swap links
        if (prev1 != prev2) {
            prev1.next = node2;
            prev2.next = node1;
        

        Node tempNext = node1.next;
        node1.next = node2.next;
        node2.next = tempNext;
        }

        return dummy.next;
    }
}
