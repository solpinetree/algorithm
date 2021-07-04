
// 이코테 문자열 재정렬
/*
 * 	알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어짐. 
 * 	1. 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에
 * 	2. 그 뒤에 모든 숫자를 더한 값을 이어서 출력 
 * 	ex) K1KA5CB7 => ABCKK13
 */

import java.util.*;

public class Implementation4 {
	public static void main(String[] args) {
		int sum=0;
		String alphabet="";
		String input="";
		Scanner sc = new Scanner(System.in);
		input=sc.next();
		
		for(int i=0;i<input.length();i++) {
			char curValue=input.charAt(i);
			
			if(curValue>='A'&&curValue<='Z')	alphabet+=curValue;
			else	sum+=(int)(curValue-'0');
		}
		
		//sorting a string alphabetically
		char[] chars=alphabet.toCharArray();
		Arrays.sort(chars);
		
		String res=new String(chars);
		res+=String.valueOf(sum);
		
		System.out.println(res);
		return;
	}
}
