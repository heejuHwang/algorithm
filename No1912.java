import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1912.연속합
public class No1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int m[] = new int[n];
		int dp[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = m[0];
		int max = m[0];
		
		// 1부터 n번째 수까지 1씩 범위를 늘려가면서 해당 범위에서의 최대합을 구한다.
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1]+m[i], m[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.print(max);
	}
}