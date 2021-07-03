// 이코테 모험가 길드
/*
    모험가 N명
    공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있음. 
    Q) 최대 몇 개의 모험가 그룹을 만들 수 있는지, 
        즉, 여행을 떠날 수 있는 그룹 수의 최댓값 
*/

#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> arr;

int main(){

    cin >> n;
    for(int i=0;i<n;i++){
        int num;
        cin >> num;
        arr.push_back(num);
    }

    sort(arr.begin(), arr.end());

    int res=0;
    int cnt=0;

    for(int i : arr){
        cnt++;
        if(cnt>=i){
            res++;
            cnt=0;
        }
    }

    cout << res << endl;
    return 0;
}
