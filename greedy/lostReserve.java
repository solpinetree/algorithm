// 바로앞 번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있음
// n : 전체학생수,
// lost : 체육복을 도난당한 학생들의 번호가 담긴 배열 
// reverse : 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
// Q) 체육 수업을 들을 수 있는 학생의 최댓값을 return
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer=0;
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++)    arr[i]=1;
        
        for(int l: lost)  arr[l-1]--;
        for(int r : reserve)   arr[r-1]++;  
        
        for(int i=0;i<n;i++){
            if(arr[i]==2){
                System.out.println(i);
                if(i>0){
                    if(arr[i-1]==0){
                      arr[i]--; 
                      arr[i-1]++;   
                      continue;}
                }
                if(i<n-1){
                    if(arr[i+1]==0){
                      arr[i]--; 
                      arr[i+1]++;}
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(arr[i]>0)   answer++;
        }
        
        
        return answer;
    }
}
