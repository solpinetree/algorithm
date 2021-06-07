#include <string>
#include <vector>
#include <unordered_map>
#include <set>
using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer(2);
    set<string> j;
    unordered_map<string, int> arr;
    int start = 0, end =0;
    int prev=100000;
    
    for(int i=0;i<gems.size();i++)  j.insert(gems[i]);//총 몇종류 있는지 확인
    
    while(1){
        if(arr.size()==j.size()){//조건에 합당한 경우 start pointer를 옮김
            if(end-start<prev){
                answer[0]=start+1;
                answer[1]=end;
                prev = end - start;
            }
            if(--arr[gems[start]]==0)   arr.erase(gems[start]);
            start++;
            if(end==gems.size()+1)    break;
        }else if(arr.size()<j.size()){//아직 조건에 합당하지 않는 경우 end pointer르 옮김
            if(end==gems.size())    break;   //segmentation fault를 방지
            arr[gems[end]]++;
            end++;
        }
    }
    
    return answer;
}
