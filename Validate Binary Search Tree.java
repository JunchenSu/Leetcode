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
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    
    private boolean helper(TreeNode root, long max, long min) {
        if(root == null) return true;
        else if(root.val >= max || root.val <= min) return false;
        else if(root.left == null && root.right == null) return true;
        else return helper(root.left, root.val, min)&&helper(root.right,max,root.val);
    }
}
