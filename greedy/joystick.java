import java.util.*;
import static java.lang.Math.abs;

class Solution {
    public int countMove(char c){
        //int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1}; => 이런식으로 비교하는 방법도 있음
        // A에서 아래쪽으로 비교했을 때 조이스틱 움직임수와 
        // 위쪽으로 비교했을 때 움직임수 중 작은 움직임수를 return
        if(c-'A'>'Z'-c+1)   return (int)('Z'-c)+1;
        else return (int)(c-'A');
    }
    
    public int determineDirection(String name, ArrayList<Character> s, int i){
        // cnt_l = name.length-cnt_r 로 구하는 방법도 있음         
        // name 과 s 를 비교해서 현재 위치 i 에서 왼쪽, 오른쪽 둘 중 어느쪽에
        // 더 가까이 조작해야할 문자가 존재하는지 리턴 
        int cnt_l=0;
        int cnt_r=0;
        int cur=i;
        while(name.charAt(cur)==s.get(cur)) { 
            cnt_r++;   cur++;
            if(cur==name.length()) cur=0;     
            if(cur==i)  return 0;
        }
        cur=i;
        while(name.charAt(cur)==s.get(cur)) { 
            cnt_l--;   cur--;
            if(cur==-1) cur=name.length()-1;   
            if(cur==i)  return 0;
        }
        System.out.println(cnt_l+" "+cnt_r); 
        if(abs(cnt_l)<cnt_r) return cnt_l;
        else return cnt_r;
    }
    
    
    public int solution(String name) {
        int answer = 0;
        // name의 각 문자를 담을 ArrayList 선언
        ArrayList<Character> s = new ArrayList<>(name.length());
        // ArrayList를 AAAAAA ... 으로 초기화  
        for(int i=0;i<name.length();i++) s.add('A');
        int i=0;
        
        while(true){
            answer+=countMove(name.charAt(i));
            s.set(i,name.charAt(i));

            int move=determineDirection(name, s, i);
            if(move==0) break;
            answer+=abs(move);
            i=i+move;
            if(i<0) i=name.length()+i;
            if(i>name.length()-1) i=i-name.length();
        }
        return answer;
    }
}
