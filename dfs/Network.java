import java.util.*;
class Solution {
    static boolean[] visited;
    public void dfs(int curNode, int n, int[][] computers){
        if(visited[curNode]==true)  return;
        visited[curNode]=true;
        for(int i=0;i<n;i++){
            if(computers[curNode][i]==1)
                dfs(i, n, computers);
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];
        Arrays.fill(visited, false);
        for(int i=0;i<n;i++){
            if(visited[i]==false)
            {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
}
