class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        /*
        vector<int> res;
        for(int i=0;i<nums.size();i++){res.push_back(nums[i]*nums[i]);}
        sort(res.begin(),res.end());
        
        return res;
        //sort() 의 시간복잡도 O(nlog(n))
        //two pointers technique을 사용하면 runtime이 줄어듬
        */
        
        //two pointers
        int size =nums.size();
        vector<int> res(size);
        int start = 0;
        int end = size-1;
        
        for(int i=size-1;i>=0;i--){
            if(abs(nums[start])>abs(nums[end])){
                res[i]= nums[start]*nums[start];
                start++;
            }else{
                res[i]= nums[end]*nums[end];
                end--;                
            }
        }
        
        return res;
        //977. Squares of a Sorted Array
    }
};
