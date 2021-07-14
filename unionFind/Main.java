import java.util.*;
// 첫째 줄에 n, m이 주어짐
// m은 입력으로 주어지는 연산의 개수
// 0 a b : 합집합, a가 포함되어 있는 집합과 b가 포함되어 있는 집합을 합침
// 1 a b :  원소가 같은 집합에 포함되어 있는지를 확인하는 연산
// a와 b: n 이하의 자연수 또는 0이며 같을 수도 있다 
public class Main {
	public static int[] parent;
	public static int find(int x) {
		if(parent[x]==x)	return x;
		parent[x]=find(parent[x]);
		return parent[x];
	}
	public static void union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x<y)	parent[y]=x;
		else if(y<x) parent[x]=y;
	}
	public static void isSameParent(int x, int y) {
		if(find(x)==find(y))
            System.out.println("YES");
		else 
         System.out.println("NO");   
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
        
		parent=new int[n+1];
		for(int i=0;i<n+1;i++)	parent[i]=i;		
        
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
            
 			if(a==0) {
				union(b,c);
			}else {
				isSameParent(b,c);
			}
		}
		
	}
}

