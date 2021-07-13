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
// return true if the tree has a root-to-leaf path such that adding up
// all the values along the path equals targetSum. 
// a leaf is a node with no children
class Solution {
    public boolean dfs(TreeNode curNode, int targetSum, int sum){
        if(curNode == null) return false;
        sum +=curNode.val;
        if(sum==targetSum&&curNode.left==null&&curNode.right==null)  return true;
        return dfs(curNode.left, targetSum, sum)||dfs(curNode.right,targetSum, sum);   
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum,0);
    }
}
