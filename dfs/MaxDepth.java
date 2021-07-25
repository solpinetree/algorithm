class Solution {
    public static int res;
    public void dfs(Node curNode, int depth){
        if(curNode.children.isEmpty()){
            res=Math.max(res, depth);
        }
        for(int i=0;i<curNode.children.size();i++){
            dfs(curNode.children.get(i),depth+1);
        }
    }
    public int maxDepth(Node root) {
        res=0;
        if(root==null)
            return 0;
        dfs(root,1);
        return res;
    }
}
