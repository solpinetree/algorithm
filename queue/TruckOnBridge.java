// bridge_length : 다리에 올라갈 수 있는 최대 트럭 수
// weight : 다리가 견딜 수 있는 무게(이하)
// truck_weights : 트럭별 무게
// Q) 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length-1;
        // que : bridge 위에 있는 트럭을 표현, 트럭이 없으면 0으로 채움
        Queue<Integer> que = new LinkedList<>();
        que.add(truck_weights[0]);
        int que_sum=truck_weights[0];
        int curIndex=1;
        
        while(curIndex<truck_weights.length){
            // bridge 위에 자리가 있는 동안 while문 돌림
            while(que.size()!=bridge_length){
                // bridge 위에 있는 트럭의 무게  + 대기 트럭의 무게 <= weight(무게제한)
                if(que_sum+truck_weights[curIndex]<=weight){
                    que.add(truck_weights[curIndex]);
                    que_sum+=truck_weights[curIndex];
                    curIndex++;
                    if(curIndex==truck_weights.length)  break;
                }else   que.add(0); 
                // 지금 대기 트럭이 bridge에 못 올라가는 경우 0으로 채움              
            }
            
            // 다리 위 맨 앞 큐를 비우고 1초 추가 
            que_sum-=que.poll();
            answer++;
        }

        while(!que.isEmpty()){
            que.poll();
            answer++;
        }
        
        return answer+1;
    }
}
