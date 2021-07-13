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
// p, q : roots of two binary trees
// P) Write a function to check if they are the same or not
// Two binary trees are considered the same if they are structurally identical, 
// and the nodes have the same value. 
class Solution {
    public class Pair{
        TreeNode p;
        TreeNode q;
        Pair(TreeNode p, TreeNode q){
            this.p=p;
            this.q=q;
        }
    }
    public boolean bfs(TreeNode p, TreeNode q){
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(p,q));
        
        while(!que.isEmpty()){
            Pair curPair = que.poll();
            
            if((curPair.p==null)&&(curPair.q==null)==true){
                continue;
            }else if((curPair.p==null)||(curPair.q==null)==true)    return false;
            
            if(curPair.p.val!=curPair.q.val)
                return false;
            
            que.add(new Pair(curPair.p.left, curPair.q.left));
            que.add(new Pair(curPair.p.right,curPair.q.right));
        }
        return true;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return bfs(p,q);
    }
}
