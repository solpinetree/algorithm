class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int p1=0, p2=0;
        int tmp;
        vector<int> temp;
        double res;
      
        //merge sort, 합병 정렬 알고리즘 사용
        while(p1<nums1.size()&&p2<nums2.size()){
            if(nums1[p1]<=nums2[p2]){temp.push_back(nums1[p1++]);}
            else temp.push_back(nums2[p2++]);
        }
        
        if(p1==nums1.size()){
            while(p2<nums2.size()){temp.push_back(nums2[p2++]);}
        }else{
            while(p1<nums1.size()){temp.push_back(nums1[p1++]);}            
        }
        
        if(temp.size()%2==0){
            res=(double)(temp[temp.size()/2]+temp[temp.size()/2-1])/2;
        }else{
            res=temp[temp.size()/2];
        }
        
        return res;
    }
};
