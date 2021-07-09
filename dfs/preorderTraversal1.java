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
// given the root of a binary tree, return the preorder traversal of its nodes' values
// preorder traversal = root -> left -> right
// stack 이용
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        // constraints : the number of nodes in the tree is in the range [0, 100]
        // so the root could be null, which means the binary tree is empty
        if(root==null)  return res; 
        
        
        // create an empty stack and push root to it
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        
        // a) add curNode to List
        // b) push its right child
        // c) push its left child
        
        while(!nodeStack.isEmpty()){
            TreeNode curNode = nodeStack.peek();
            res.add(curNode.val);
            System.out.println(curNode.val + " ");
            nodeStack.pop();
            
            if(curNode.right != null)
                nodeStack.push(curNode.right);
            if(curNode.left != null)
                nodeStack.push(curNode.left);
        }
        return res;
    }
}
