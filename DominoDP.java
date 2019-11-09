import java.util.Scanner;

public class DominoDP {

	public static void main(String[] args) {
		/*
		 * 가로의 길이가 1, 2일땐 도미노를 채우는 경우의 수가 1,2가지 이다.
		 * 가로의 길이가 n(3<=n)이면, 사각형을 채우는 방법의 수 c[n]는 
		 * c[n-1](길이가 1짧은 사각형끝에 세운 도미노 하나를 붙임) + c[n-2](길이가 2짧은 사각형끝에 눕혀서 2개 쌓은 도미노를 붙임)이라고 할 수 있다.
		 */

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();		
		
		if(n<=2) {
			System.out.println(n);
		}

		if(3 <= n) {
			int[] c = new int[n+1];
			for(int i=0;i<=2;i++) {
				c[i] = i;
			}
			for(int j=3;j<=n;j++) {
				c[j] = c[j-2]+c[j-1];
			}
			System.out.println(c[n]);
		}	
	}
}
