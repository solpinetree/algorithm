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
// Given the root of a binary tree, return its maximum depth
class Solution {
    public int res=0;
    public void dfs(TreeNode curNode, int depth){
        res=Math.max(res, depth);
        if(curNode.left!=null)
            dfs(curNode.left, depth+1);
        if(curNode.right!=null)
            dfs(curNode.right, depth+1);
    }
    public int maxDepth(TreeNode root) {
        if(root==null)  return 0;
        dfs(root, 1);
        return res;
    }
}
