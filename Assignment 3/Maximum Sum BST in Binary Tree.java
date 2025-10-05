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
class Info{
    public boolean isBST;
    public int sum;
    public int mini;
    public int maxi;

    public Info(){
        isBST = true;
        sum = 0;
        mini = Integer.MAX_VALUE;
        maxi = Integer.MIN_VALUE;
    }
}

class Solution {
    int best;
    
    Info solve(TreeNode root){
        Info rootInfo = new Info();
        if(root==null){
            return rootInfo;
        }

        Info leftInfo = solve(root.left);
        Info rightInfo = solve(root.right);

        if(leftInfo.isBST && rightInfo.isBST && leftInfo.maxi<root.val && rightInfo.mini>root.val){
           rootInfo.sum = leftInfo.sum+rightInfo.sum+root.val;
           best = Math.max(best,rootInfo.sum);

           rootInfo.maxi = Math.max(rightInfo.maxi,root.val);
           rootInfo.mini = Math.min(leftInfo.mini,root.val);
        }
        else{
            rootInfo.isBST = false;
        }

        return rootInfo;
    }

    public int maxSumBST(TreeNode root) {
      best = 0;

       solve(root);

       return best;
    }
}