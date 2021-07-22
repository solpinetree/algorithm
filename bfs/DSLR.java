import java.util.*;

// D : n을 두 배로 바꾼다. 결과 값이 9999보다 큰 경우에는 
// 		10000으로 나눈 나머지를 취함 
// S : n-1을 레지스터에 저장. 
// 		if) n==0 -> 9999가 레지스터에 저장됨
// L : n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장
// R : n의 각 자릿수를 오른편으로 회전시킴
// P) A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			boolean[] visited = new boolean[10000];
			Queue<Integer> q = new LinkedList<Integer>();
			String[] command = new String[10000];
			int A = sc.nextInt();
			int B = sc.nextInt();

			q.add(A);
			visited[A] = true;
			Arrays.fill(command, "");

			while (!q.isEmpty()&&!visited[B]) {
				int n = q.poll();
				int D = (n * 2) % 10000;
				int S = (n == 0) ? 9999 : n - 1;
				int L = (n % 1000) * 10 + (n / 1000);
				int R = (n / 10) + (n % 10) * 1000;
				if (visited[D]==false) {
					q.add(D);
					visited[D] = true;
					command[D] = command[n] + "D";
				}
				if (visited[S] != true) {
					q.add(S);
					visited[S] = true;
					command[S] = command[n] + "S";
				}
				if (visited[L] != true) {
					q.add(L);
					visited[L] = true;
					command[L] = command[n] + "L";
				}
				if (visited[R] != true) {
					q.add(R);
					visited[R] = true;
					command[R] = command[n] + "R";
				}

			}
			
			System.out.println(command[B]);
		}
	}
}

