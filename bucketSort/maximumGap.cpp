//linear time으로 배열 정렬하는 방법
//1. counting sort
//2. radix sort
//3. bucket sort


class Solution {
public:
    int maximumGap(vector<int>& nums) {
        if(nums.size()<2)   return 0;
        
        int minValue=*min_element(nums.begin(),nums.end());
        int maxValue=*max_element(nums.begin(),nums.end());
        
        if(minValue==maxValue)  return 0;//in case bucket size = 0
        
        //minimum possible maximum gap
        int bucketSize=(maxValue-minValue)/(nums.size()-1);
        if(bucketSize==0)   bucketSize=1;   //[1,1,1,1,1,5,5,5,5,5]
        int bucketNum=(maxValue-minValue)/bucketSize+1;
        vector<int> bucketMins(bucketNum,INT_MAX);
        vector<int> bucketMaxs(bucketNum,INT_MIN);
        
        for(auto& a :nums){
            int idx = (a-minValue)/bucketSize;
            bucketMins[idx]=min(bucketMins[idx],a);
            bucketMaxs[idx]=max(bucketMaxs[idx],a);
        }
        
        int res = bucketSize; //maximum gap is always greater or equal to bucketSize
        //finally, we only need to compare max number in current bucket and min number in the enxt bucket
        int preMax=bucketMaxs[0];
        for(int i=1;i<bucketNum;i++){
            if(bucketMins[i]==INT_MAX) continue;
            res=max(res,bucketMins[i]-preMax);
            preMax=bucketMaxs[i];
        }
        
        return res;
    }
};
