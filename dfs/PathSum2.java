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
// given the root : a binary tree, targetSum
// return all root-to-leaf paths where each path's sum equals targetSum.
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> sub = new ArrayList<>();
    
    public void dfs(TreeNode curNode, int targetSum, int sum){
        sum+=curNode.val;
        sub.add(curNode.val);
        
        if(targetSum==sum&&curNode.left==null&&curNode.right==null){
            res.add(new ArrayList<>(sub));  
        }
        
        if(curNode.left!=null){
            dfs(curNode.left,targetSum, sum);
            sub.remove(sub.size()-1);
        }
        
        if(curNode.right!=null){
            dfs(curNode.right,targetSum, sum);
            sub.remove(sub.size()-1);
        }
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root!=null) 
            dfs(root, targetSum, 0);
        return res;
    }
}
