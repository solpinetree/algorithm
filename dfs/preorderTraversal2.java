// given the root of a binary tree, return the preorder traversal of its nodes' values
// preorder traversal = root -> left -> right
// recursive function 이용
class Solution {
    public List<Integer> res = new ArrayList<>();
    public void dfs(TreeNode curNode){
        if(curNode!=null){
            res.add(curNode.val);
            dfs(curNode.left);
            dfs(curNode.right);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
}
