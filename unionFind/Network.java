// n : 컴퓨터의 개수 
// computers : 연결에 대한 정보가 담긴 2차원 배열
// P) 네트워크의 개수를 return 
// 몇개의 사이클(root)이 있는지 확인한다.
import java.util.*;
class Solution {
    public static int[] parent;
    
    public static int find(int x) {
        if(x==parent[x])
            return x;
        else
            return parent[x]=find(parent[x]);
    }
    
    public static void union(int x, int y){
        parent[find(y)]=find(x);
    }
    public int solution(int n, int[][] computers) {
        parent = new int[computers.length];
        ArrayList<Integer> root = new ArrayList<>();
        
        for(int i=0;i<computers.length;i++){
            parent[i]=i;
        }
        
        for(int i=0;i<computers.length;i++){
            for(int j=i+1;j<computers.length;j++){
                if(computers[i][j]==1)
                    union(i, j);
            }
        }
        
        for(int i=0;i<computers.length;i++){
            if(!root.contains(find(i)))
                root.add(find(i));
        }
        
        return root.size();
    }
}
