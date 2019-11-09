import java.util.Scanner;
import java.lang.Math;

public class MatrixDP {

	public static void main(String[] args) {
		/* n*n행렬에서 n의 값을 입력받는다.
		 * 경로를 구하고자 하는 행렬 값(n*n개)을 m에 입력받는다.
		 * c[i][j]는 m[i][j]까지 가는 경로합의 최대값을 저장한다. 
		 */

		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[][] m = new int[n+1][n+1];
	    int[][] c = new int[n+1][n+1];    

	    for (int i=1; i<=n; i++){
	    	for (int j=1;j<=n;j++){
	    		m[i][j] = sc.nextInt();
	    	}
	    }
	    sc.close();

	    for (int i=0; i<=n; i++){
	    	c[i][0] = 0;
	    }
	    for (int j=1; j<=n; j++){
	    	c[0][j] = 0;
	    }

	    for (int i=1; i<=n; i++){
	    	for(int j=1;j<=n;j++){
	    		c[i][j] = m[i][j] + Math.max(c[i-1][j],Math.max(c[i][j-1],c[i-1][j-1]));
	    	}
	    }
	    System.out.println(c[n][n]);
	}
}
