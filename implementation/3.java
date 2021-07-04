// 이코테 왕실의 나이트
/*
 * 	왕실 정원 :8 x 8 정원 
 *	나이트(신하)는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없음
 *	이동하는 두 가지 경우
 *	1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동 
 *	2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동 
 *	Q)나이트가 이동할 수 있는 경우의 수를 출력 
 *	행 1~8, 열 a~h
 */

import java.util.*;

public class Implementation3 {
	public static void main(String[] args) {
		//나이트가 이동할 수 있는 8가지 방향, 방향 벡터 
		int[] dx= {-2,-2,2,2,-1,1,1,-1};
		int[] dy= {1,-1,1,-1,2,2,-2,-2};
		
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
		int res=0;
		
		int x= (int)(s.charAt(0)-'a')+1;
		int y= (int)(s.charAt(1)-'1')+1;
		
		for(int i=0;i<8;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<1||nx>8||ny<1||ny>8)
					continue;
			res++;
		}
		
		System.out.println(res);
		return;
	}
}
