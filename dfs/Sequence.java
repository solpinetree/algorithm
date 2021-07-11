package boj;

import java.util.*;

public class Sequence {
	static boolean stop=false;

	public static void dfs(int location, String res, int n) {
		if(stop==true)	return;
		// location : 현재 따질 위치
		if(location == n+1) {
			// n자리 문자열을 찾는데 n+1위치까지 왔다는 건
			// n까지 모두 조건을 만족한다는 이야기이므로 답을 출력
			System.out.println("정답은 "+ res);
			stop=true;
		}else {
			// 현재 상황 : location-1까지는 조건을 만족하고
			// location에 놓을 숫자를 찾아야함			
			for(int i=1;i<4;i++) {
				// 1부터 3까지 놓는 경우를 전부 따져봄
				if(isPossible(res+Integer.toString(i))){
					dfs(location+1,res+Integer.toString(i),n);
				}
			}
		}
	}
	
	public static boolean isPossible(String str) {
		int mid = str.length()/2;
//		System.out.println(str+" "+mid);
		if(mid==0)	return true;
		if(str.substring(0,mid).equals(str.substring(mid)))
			return false;
		return isPossible(str.substring(1));		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String res = "";		
		dfs(1,res,n);
	}
}
