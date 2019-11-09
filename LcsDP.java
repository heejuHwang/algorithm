import java.util.Scanner;

public class LcsDP {

	public static void main(String[] args) {
		// 비교할 두 문자열을 입력받는다(x, y).
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		String y = sc.next();
		sc.close();
		
		// c에는 x,y의 최장 공통부분의 길이정보를, b에는 경로정보를 저장한다. 
		int m = x.length();
		int n = y.length();
		int c[][] = new int[m+1][n+1];
		int b[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			c[i][0] = 0;
		}
		for(int j=1;j<=n;j++) {
			c[0][j]=0;
		}
		
		for(int i=1; i<=m; i++) {
			for(int j=1;j<=n;j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					c[i][j] = c[i-1][j-1]+1;
					b[i][j] = 'D';
					
				}
				else {
					if(c[i-1][j] >= c[i][j-1]) {
						c[i][j] = c[i-1][j];
						b[i][j] = 'U';
					}
					else {
						c[i][j] = c[i][j-1];
						b[i][j] = 'L';
					}
				}
				
			}		
		}
		
		// b를 이용하여 공통부분 경로를 구한다.
		int a = n;
		String sq ="";
		
		for(int i=m; 1<=i; i--) {
			if(b[i][a] == 'D') {
				char tmp = x.charAt(i-1);
				sq = tmp + sq;
				a--;
			}
			else if(b[i][a] == 'L') {
				a--;
				i++;
			}
		}
		System.out.println(c[m][n]);
		System.out.println(sq);
	}
}
