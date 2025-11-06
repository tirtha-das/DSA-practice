/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.*;

 public class Solution {
     static void loadLeafNodes(TreeNode root, ArrayList<Integer> res) {
    if (root == null) {
        return;
    }
    if (root.left == null && root.right == null) {
        res.add(root.data);
        return;
    }
    loadLeafNodes(root.left, res);
    loadLeafNodes(root.right, res);
}

static void loadLeftBoundary(TreeNode root, ArrayList<Integer> res) {
    if (root == null || (root.left == null && root.right == null)) {
        return;
    }
    res.add(root.data);
    if (root.left != null) {
        loadLeftBoundary(root.left, res);
    } else {
        loadLeftBoundary(root.right, res);
    }
}

static void loadRightBoundary(TreeNode root, ArrayList<Integer> res) {
    if (root == null || (root.left == null && root.right == null)) {
        return;
    }
    if (root.right != null) {
        loadRightBoundary(root.right, res);
    } else {
        loadRightBoundary(root.left, res);
    }
    res.add(root.data); // add after recursion to get reverse order
}

  static ArrayList<Integer> solve(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null) return res;

    res.add(root.data);

    loadLeftBoundary(root.left, res);
    loadLeafNodes(root.left, res);
    loadLeafNodes(root.right, res);
    loadRightBoundary(root.right, res);

    return res;
}
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        return solve(root);
    }
}