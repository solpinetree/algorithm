package practice;
//NxM 크기의 얼음 틀에 음료수 채우기 
//0 :구멍이 뚫려 있는 부분, 1 : 칸막이가 존재하는 부분
//얼음틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램
/*
 * 1. 특정한 지점의 주변 상, 하, 좌, 우를 살펴본 뒤에 주변 지점 중에서 값이 '0'이면서 아직 방문하지 않은
 * 		지점이 있다면 해당 지점을 방문 
 * 2. 방문한 지점에서 다시 상, 하, 좌, 우를 살펴보면서 방문을 진행하는 과정을 반복
 * 		=> 연결된 모든 지점을 방문할 수 있음
 * 3. 모든 노드에 대하여 1~2번의 과정을 반복하며, 방문하지 않은 지점의 수를 카운트
 */
import java.util.*;

public class Practice1 {
	public static int n,m;
	public static int[][] graph = new int[1000][1000];
	
	// DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
	public static boolean dfs(int x, int y) {
		// 주어진 범위를 벗어나는 경우에는 즉시 종료
		if(x<0||x>=n||y<0||y>=m)	return false;
		
		// 현재 노드를 아직 방문하지 않았다면
		if(graph[x][y] == 0) {
			// 해당 노드 방문 처리
			graph[x][y] = 1;
			// 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
			dfs(x -1 ,y);
			dfs(x, y-1);
			dfs(x+1,y);
			dfs(x, y+1);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		sc.nextLine(); // 버퍼 지우기
		
		// 맵 정보 입력 받기 
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			for(int j=0;j<m;j++)
				graph[i][j]=str.charAt(j)-'0';
		}
		
		// 모든 노드(위치)에 대하여 음료수 채우기
		int result = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				// 현재 위치에서 DFS 수행
				if(dfs(i,j))
					result++;
			}
		}
		
		System.out.println(result);
	}
}
