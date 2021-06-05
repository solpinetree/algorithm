#include<iostream>
#include<vector>

using namespace std;

//sliding window => 구간이 고정적 길이
//two pointers => 구간이 가변적 길이 
//이 문제에선 구간이 가변적이므로 two pointers algorithm을 사용
//언제 right pointer를 증감시키고, 언제 left pointer를 증감시키는지 결정해야함.
//sum < M 일 때 right pointer ++;
//sum > M 일 때 left pointer ++;
//두 포인터 각각 N번씩 움직이므로 시간복잡도는 O(N)

int main(){
    int M = 0, N = 0;
    vector<int> nums;
    int result = 0;
    int sum = 0;
    int start = 0, end = 0;
    
    cin >> N >> M;
  
    for(int i=0;i<N;i++){
        int temp = 0;
        cin >> temp;
        nums.push_back(temp);
    }

    sum = nums[0];
  
    while(start<N){
        if(sum>M){
            sum-=nums[start];
            start++;
        }else if(sum<M){
            end++;
            if(end==N)
                break;
            sum+=nums[end];
        }
        
        if(sum==M){
            result++;
            sum-=nums[start];
            start++;
            end++;
            if(end==N)
                break;
            sum+=nums[end];         
        } 
    }
     
    cout << result << endl;
     
    return 0;
}
