//이코테 곱하기 혹은 더하기 문제
/*
    각 잘리가(0부터 9)로만 이루어진 문자열 s가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며
    숫자 사이에 'x'혹은 '+'연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구하라
    모든 연산은 왼쪽에서부터 순서대로 이루어진다고 가정
*/

#include <bits/stdc++.h>
using namespace std;

string s;

int main()
{  
    cin >> s;
    
    long long res=s[0]-'0';

    if(s.size()==1) return res;

    for(int i=1;i<s.size();i++){
        int curValue=s[i]-'0';
        if(curValue<=1||res<=1) res=res+curValue;
        else    res=res*curValue;
    }

    cout << res<<endl;
    return 0;
}
