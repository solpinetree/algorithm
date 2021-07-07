// progresses : 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
// speeds : 각 작업의 개발 속도가 적힌 정수 배
// Q) 각 배포마다 몇 개의 기능이 배포되는지 
// 배포되어야하는 순서가 정해져 있으므로 FIFO, queue를 이용해야함  
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int days;
        
        for(int i=0;i<progresses.length;i++)   q.add(i);
        
        
        while(!q.isEmpty()){
            int n=0;
            // 일수 관려 문제는 나머지 소숫점도 1일로 여겨야 하므로 Math.ceil() 사용 
            days=(int)Math.ceil((100-progresses[q.peek()])/(double)speeds[q.peek()]);
            n++;
            q.poll();
            while(!q.isEmpty()&&progresses[q.peek()]+speeds[q.peek()]*days>=100){
                n++;
                q.poll();
            }
            arr.add(n);
        }
        
        int[] answer = new int[arr.size()];
        for(int i=0;i<arr.size();i++)   answer[i]=arr.get(i);
        
        return answer;
    }
}

/*
큐를 이용한 다른 방법(더 효율적) 
progresses 와 speeds 배열을 한 번 돌면서 
기능개발 완료까지 남은 일수를 큐 저장
한 큐에는 q.peek()과 같은 날에 기능 개발 발표 할 수 있는 기능들로만 구성됨
      for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }
      answerList.add(q.size());
*/
