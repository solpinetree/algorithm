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
// given the root of a binary tree, return the inorder traversal of its nodes' values
// inorder : left -> rot -> right
class Solution {
    public List<Integer> res;
    public void dfs(TreeNode curNode){
        if(curNode==null)   return;
        if(curNode.left!=null) {dfs(curNode.left);}
        res.add(curNode.val);
        if(curNode.right!=null) {dfs(curNode.right);}
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }
}
