/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    
    private int helper(TreeNode root,int currentVal) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return currentVal*10 + root.val;
        else return helper(root.left,currentVal*10 + root.val) + helper(root.right,currentVal*10 + root.val);
    }
}
