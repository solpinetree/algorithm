//나열된 수 중 더했을 때 가장 0에 가장 가까운 두 수의 조합을 찾아라. 
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> data(n);
    vector<int> res(2);
    for(int i=0;i<n;i++) cin >> data[i];
    sort(data.begin(),data.end()); //-99 -2 -1 4 98
    int left=0, right=n-1;
    res[0]=data[left];
    res[1]=data[right];    
    while(left<right){
        if(abs(res[0]+res[1])>abs(data[left]+data[right])){
            res[0]=data[left];
            res[1]=data[right];
        }
        if(data[left]+data[right]<0)    left++;  //data[lfet]+data[right]이 0에 가까워지도록 포인터를 옮김
        else   right--;
    }
    
    cout << res[0] << " " <<  res[1];
    return 0;
}
