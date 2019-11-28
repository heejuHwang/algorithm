import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

// 백준 1463번.1로 만들기
public class No1463 {
	 
	public static int make1(int n) {
		// 1은 연산하지 않으니 0
		if (n==1) return 0;
		
		// 2 이상의 수에 대하여 DP수행
		else {
			int[] c = new int[n+1];
			c[1] = 0;
			/*
			숫자 n을 1로 만드는 방법 
			1. 1을 빼는 연산을 수행, n-1을 1로 만드는 연산 횟수
			2. 2 혹은 3으로 나누어 떨어진다면 나누고, 그 수를 1로 만드는 연산 횟수
			*/
			for(int j=2; j<=n; j++) {
				if(j%6 == 0) 
					c[j] = 1 + Math.min(c[j-1], Math.min(c[j/3], c[j/2]));
				else if(j%2 == 0) 
					c[j] = 1 + Math.min(c[j-1], c[j/2]);
				
				else if(j%3 == 0) 
					c[j] = 1 + Math.min(c[j-1], c[j/3]);
				
				else 
					c[j] = 1 + c[j-1];
				
			}
			return c[n];
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(make1(n));
	}

}
