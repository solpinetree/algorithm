import java.util.Scanner;

//이코테 시각 
/*
 * 입력된 값 N
 * 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중 3이 하나라도 포함되는 모든 경우의 수를 구하라
 */
public class Implementation2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int res=45*45;
		
		if(n==0) {	
			System.out.println(res);
			return;
		}
		
		if(n%10<3) {
			res=res*(n/10+1)*(n%10+1);
		}else {
			res=res*(n/10+1)*(n%10);
		}
		
		res=(n/10+1)*(n%10+1)*60*60-res;
		
		System.out.println(res);
		return;
	}
}

