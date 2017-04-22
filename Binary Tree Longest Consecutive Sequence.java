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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root.left, root.val, 1);
        helper(root.right, root.val,1);
        return max;
    }
    
    private void helper(TreeNode node, int val, int count) {
        if(node == null) {
            max = Math.max(max, count);
            return;
        }
        if(node.val == val + 1) {
            helper(node.left,node.val,count + 1);
            helper(node.right,node.val,count + 1);
            return;
        } else {
            max = Math.max(max, count);
            helper(node.left,node.val,1);
            helper(node.right,node.val,1);
            return;
        }
    }
}
