// 이코테 상하좌우
/*
    여행가 A는 N x N 크기의 정사각형 공간 위에 서 있음.
    여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1,1)
    계획서가 있음 (R,L,U,D)
    첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표(X,Y)를 공백을 기준으로 구분하여 출력함
*/

#include <bits/stdc++.h>
using namespace std;

int n;
string plans;
int x=1,y=1;

// L, R, U, D
int dx[4]={0,0,-1,1};
int dy[4]={-1,1,0,0};
char moveTypes[4]={'L','R','U','D'};

int main(){

    cin>>n;
    cin.ignore(); // 버퍼 비우기
    getline(cin, plans);

    int move;

    for(int i=0;i<plans.size();i++){
        
        if(plans[i]<'A'||plans[i]>'Z')  continue;

        //find a particular value in an array and return its index
        move = distance(moveTypes,
            find(moveTypes, moveTypes+4,plans[i]));

        if(x+dx[move]!=0&&x+dx[move]!=5&&y+dy[move]!=0&&y+dy[move]!=5)
        { 
            x=x+dx[move];
            y=y+dy[move];
        }
    }


    cout << x << " " << y << endl;
    return 0;
}
