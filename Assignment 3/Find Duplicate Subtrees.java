/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    String solve(TreeNode root,List<TreeNode>ans,Map<String,Integer>mp){
        if(root==null){
          return new String("");
        }

        String left = solve(root.left,ans,mp);
        String right = solve(root.right,ans,mp);

        StringBuilder sb = new StringBuilder("");
        sb.append(Integer.toString(root.val));
        sb.append('L');
        sb.append(left);
        sb.append('R');
        sb.append(right);

        String hashKey = sb.toString();
        mp.put(hashKey,mp.getOrDefault(hashKey,0)+1);
        if(mp.get(hashKey)==2){
           ans.add(root);
        }

        return hashKey;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>ans = new ArrayList<>();
        Map<String,Integer>mp = new HashMap<>();

        solve(root,ans,mp);
       return ans;
    }
}