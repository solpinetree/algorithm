// 섬 연결 최단거리, 최소비용 구하기 
import java.util.*;
class Bridge implements Comparable<Bridge>{
    int island1;
    int island2;
    int cost;
    Bridge(int island1, int island2, int cost){
        this.island1=island1;
        this.island2=island2;
        this.cost=cost;
    }
    @Override
    public int compareTo(Bridge b){
        if(this.cost<b.cost)
            return -1;
        else if(this.cost>b.cost)
            return 1;
        else 
            return 0;
    }
}
class Solution {
    public static int[] parent;
    public static ArrayList<Bridge> bridgeList;

    public static void union(int x, int y){
        x=find(x);
        y=find(y);
        if(x!=y)    parent[y]=x;
    }

    public static int find(int x){
        if(parent[x]==x)    return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }

    public static boolean isSameParent(int x, int y){
        x=find(x);
        y=find(y);
        if(x==y)    return true;
        else return false;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        bridgeList = new ArrayList<Bridge>();
        for(int i=0;i<costs.length;i++){
            bridgeList.add(new Bridge(costs[i][0],costs[i][1],costs[i][2]));
        }

        parent = new int[n];
        for(int i=0;i<n;i++)    parent[i]=i;

        Collections.sort(bridgeList);


        for(int i=0;i<bridgeList.size();i++){
            Bridge bridge = bridgeList.get(i);
            if(!isSameParent(bridge.island1, bridge.island2)){
                answer+=bridge.cost;
                union(bridge.island1, bridge.island2);
            }
        }

        return answer;
    }
}
