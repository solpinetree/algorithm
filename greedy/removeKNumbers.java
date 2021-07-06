// number: 숫자 문자열 
// 이 숫자들 중 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자

import java.util.*;

class Solution {
    public int getMaxIndex(String number, int s, int e){
        int max = number.charAt(s);
        int maxIndex=s;
        
        for(int i=s;i<e;i++){
            if(max<number.charAt(i))
            {
                maxIndex=i;
                max=number.charAt(i);
            }
        }
        return maxIndex;
    }
    public String solution(String number, int k) {
        String answer = "";

        int prevMaxIndex=0;
        // 최종적으로 answer.length()가 number.length()에서 k를 뺀 수만큼 되야함
        int lengthOfReturn = number.length() - k;
        
        while(answer.length() < lengthOfReturn){
            int maxIndex = getMaxIndex(number, prevMaxIndex, number.length());
            
            // 여태까지의 answer의 길이와 지금 maxIndex 부터 마지막 인덱스까지의 개수가
            // lengthOfReturn 보다 크거나 같아야함 => 그래야 answer에 들어갈 수 있음
            while(number.length() - maxIndex < lengthOfReturn - answer.length())
                maxIndex = getMaxIndex(number, prevMaxIndex, maxIndex);
        
            
            if(number.length() - maxIndex == lengthOfReturn - answer.length()){
                // for(int i=maxIndex;i<number.length();i++)
                //     answer+=number.charAt(i); => 이 두줄로 시간초과..
                answer+=number.substring(maxIndex, number.length());
                break;
            }
            
            answer+=number.charAt(maxIndex);
            prevMaxIndex=maxIndex+1;
        }
        
        return answer;
        
// stack을 사용한 예 
//       char[] result = new char[number.length() - k];
//         Stack<Character> stack = new Stack<>();

//         for (int i=0; i<number.length(); i++) {
//             char c = number.charAt(i);
//             while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
//                 stack.pop();
//             }
//             stack.push(c);
//         }
//         for (int i=0; i<result.length; i++) {
//             result[i] = stack.get(i);
//         }
//         return new String(result);        
    }
}
