import java.util.Scanner;

// 백준 2193번.이친수
public class No2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
			long dp[][] = new long[n+1][2];
			
			// [n][0]은 0으로 끝나는 문자열 [n][1]은 1로 끝나는 문자열이다.
	    dp[1][0] = 0;
	    dp[1][1] = 1;

			/* 0앞에는 0과 1이 모두 올 수 있으므로 [i-1][0] + [i-1][1]
			1 앞에는 0만 올 수 있으므로 [i-1][0]	*/
	    for(int i = 2; i <= n; i++){
	      dp[i][0] = dp[i-1][0] + dp[i-1][1];
	      dp[i][1] = dp[i-1][0];
			}
			
			// 길이 n인 이친수의 개수를 더하여 출력
	    System.out.println(dp[n][0] + dp[n][1]);
	}

}