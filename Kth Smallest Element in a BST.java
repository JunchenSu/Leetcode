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
    public int kthSmallest(TreeNode root, int k) {
       /* iterative in-order
       if(root == null)
        return 0;
 
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currentNode = root;
 
        while(!s.empty() || currentNode!=null){
 
        if(currentNode!=null)
        {
            s.push(currentNode);
            currentNode=currentNode.left;
        }
        else
        {
            TreeNode n = s.pop();
            k--;
            if(k == 0) return n.val;
            currentNode=n.right;
        }
        }
        return -1;
        */
        
        
        
        /*Binary Search*/
        int count = countNodes(root.left);
        if(k <= count) return kthSmallest(root.left, k);
        else if(k > count + 1) return kthSmallest(root.right, k - count - 1);//1 is root
        return root.val;
    }
        
        
        
        
    private int countNodes(TreeNode root) {
        if(root == null) return 0;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
