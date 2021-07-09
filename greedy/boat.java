// 최대 2명씩
// people : 사람들의 몸무게를 담은 배열
// limit : 무게 제한, limit 이하
// Q) 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        // two pointers
        int left=0;
        int right=people.length-1;
        // left, right은 각각 남은 사람 중 무게가 가장 적게 나가는 사람과
        // 가장 많이 나가는 사람을 가리킨다. 가장 많이 나가는 사람과 가장 적게 나가는 사람
        // 의 무게의 합이 limit 보다 크다면 가장 많이 나가는 사람은 혼자 보트를 타야만 한다
        // 따라서 두명이 탔을 경우에만 증감하는 left는 두 명이 탄 보트의 개수를 나타내므로
        // 총 사람 수에서 두 명이 탄 보트의 개수를 빼주면 된다
        while(left<right){
            if(people[left]+people[right]<=limit){
                left++;
                right--;
            }
            else{
                right--;
            }
        }
        return people.length-left;
    }
}
