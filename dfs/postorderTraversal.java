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
// postorder traversal: left → right → root
class Solution {
    public List<Integer> res = new ArrayList<>();
    public void dfs(TreeNode curNode){
        if(curNode!=null)
        {
            dfs(curNode.left);
            dfs(curNode.right);
            res.add(curNode.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
}
