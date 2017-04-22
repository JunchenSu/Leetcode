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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);//注意这个递归只能写在这里不能写在下面，因为如果放弃当前这个点，sum是不能变的。
    }
    
    private int helper(TreeNode root, int sum) {
        int res = 0;
        if(root == null) return 0;
        else if(root.val == sum) {
            res++;
        } 
        res += helper(root.right, sum - root.val) + helper(root.left, sum- root.val);//注意考虑子的值为0的情况
        return res;
    }
}
