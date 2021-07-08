// 중요도가 높은 문서를 먼저 인쇄하는 프린터
// Q) 인쇄를 요청한 문서가 몇 번째로 인쇄되는지
// priorities : 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 
// location : 인쇄를 요청한 문서의 인덱스
// FIFO => queue
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for(int i : priorities) que.add(i);
        // 중요도가 크기 순이므로 sorting 해서 프린트 순서에 이용할 수 있음        
        Arrays.sort(priorities); 
        
        while(!que.isEmpty()){
            // que의 탑이 que에 있는 대기목록 중 중요도가 가장 크다면
            if(que.peek()==priorities[priorities.length-answer-1]){
                que.poll();
                answer++;
                location--; // que 안에서의 인쇄요청한 문서의 위치를 tracking
                if(location<0) break;
            }else{
                que.add(que.poll());
                location--;
                if(location<0)
                    location=que.size()-1;
            }
        }
        
        return answer;
    }
}
