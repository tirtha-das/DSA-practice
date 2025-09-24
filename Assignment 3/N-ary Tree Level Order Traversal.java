/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> solve(Node root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;

    Queue<Node> pn = new LinkedList<>();
    pn.add(root);

    while (!pn.isEmpty()) {
        int sz = pn.size();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < sz; i++) {
            Node cur = pn.poll();
            temp.add(cur.val);

            for (Node child : cur.children) {
                pn.add(child);
            }
        }

        ans.add(temp);
    }

    return ans;
    }
    public List<List<Integer>> levelOrder(Node root) {
        return solve(root);
    }
}