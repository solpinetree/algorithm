package practice;

// 동빈이는 N x M 크기의 직사각형 형태의 미로에 갇힘(미로에는 여러 마리의 괴물이 있어 피해 탈출해야함) 
// 동빈이의 위치 : (1,1)
// 미로의 출구 : (N,M)
// 괴물이 있는 부분 : 0, 괴물이 없는 부분 : 1
// Q) 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수
import java.util.*;

class Node{
	int x,y;
	
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Practice2 {
	public static int n, m;
	public static int[][] graph=new int[201][201];
	
	// 이동할 네 가지 방향 정의(상, 하, 좌, 우)
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	

	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y));
		System.out.println(x+" "+y+" 들어감 ");
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			System.out.println(curNode.x+" "+curNode.y+" 나옴 ");
			x = curNode.x;
			y = curNode.y;
			// 현재 위치에서 상하좌우로 위치 확인
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				// 미로 찾기 공간을 벗어난 경우 
				if(nx<0||nx>=n||ny<0||ny>=m)	continue;
				// 괴물이 있는 경우
				if(graph[nx][ny]==0) continue;
				// 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
				if(graph[nx][ny]==1) {
					graph[nx][ny]=graph[x][y]+1;
					q.offer(new Node(nx,ny));
					System.out.println(nx+" "+ny+" 들어감 ");
				}
			}
		}
		return graph[n-1][m-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine(); // 버퍼 비우기

		//graph = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++)
				graph[i][j] = str.charAt(j) - '0';
		}

		System.out.println(bfs(0,0));
	}
}
