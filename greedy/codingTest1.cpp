//이코테 1일될때까지 
/*
어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행
1. n - 1
2. n/k (오직 n이 k로 나누어 떨어질 때만 선택할 수 있음)

n과 k가 주어질 때 n이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하라
*/

#include <bits/stdc++.h>
using namespace std;

int n,k;
int res=0;

int main(){

    // N, K 값을 입력받음 
    cin >> n >> k;   //19, 7

    while(true){
        // tartget=n이하의 k로 나누어지는 최대의 수
        int target = (n/k)*k; // target=(19/7)*7=14
        res=res+(n-target);//19에서 14까지 한꺼번에 빼준 후 res에 그만큼 더해줌 -> 루프 횟수 줄어듬
        n=target;
        // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
        if(n<k) break; //n=2,k=7
        n=n/k;
        res++;
    }

    res=res+n-1; //n에서 1이될때까지 1을 빼는 횟수 더하기
    cout<<res<<endl;
}
