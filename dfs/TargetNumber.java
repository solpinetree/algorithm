// numbers : 음이 아닌 정수들
// numbers를 더하거나 빼서 target 넘버 만들기
// Q) 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return
import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(numbers[0]);
        q.add(-1*numbers[0]);
        
        for(int i =1 ;i<numbers.length;i++){
            int size=q.size();
            while(size>0){
                q.add(q.peek()-1*numbers[i]);
                q.add(q.peek()+numbers[i]);
                q.poll();
                size--;
            }
        }
        
        while(!q.isEmpty()){
            if(q.poll()==target)
                answer++;
        }
        
        return answer;
    }
}

// 좀 더 효율적인 방법 
/*
// numbers : 음이 아닌 정수들
// numbers를 더하거나 빼서 target 넘버 만들기
// Q) 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return
import java.util.*;
class Solution {
    public int dfs(int[] numbers, int n, int sum, int target){
        if(n==numbers.length)
        {
            if(sum==target)
                return 1;
            else
                return 0;
        }
        return dfs(numbers, n+1, sum+numbers[n],target)
                +dfs(numbers,n+1, sum-numbers[n], target);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        return dfs(numbers,0,0,target);
    }
}
*/
