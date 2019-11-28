import java.util.*;

// 백준 1915번.가장 큰 정사각형
public class No1915 {
    static int n,m,ans;
    static String s;
    static int[][] a = new int[1001][1001], d = new int [1001][1001];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        // 입력 받기
        for(int i=0; i<n; i++){
            s = in.next();
            for(int j=0; j<m; j++){
                a[i][j] = s.charAt(j)-48;
                if(a[i][j]==1){
                    d[i][j] = 1;
                    ans = 1;
                }
            }
        }

        /* 원소의 왼쪽, 왼쪽 위, 위쪽 원소가 모두 1인경우 -> 정사각형
        배열을 순회하면서 해당 위치에서 만들 수 있는 정사각형 한 변의 길이를 저장한다.*/
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(a[i-1][j]==1 && a[i-1][j-1]==1 && a[i][j-1]==1){
                    d[i][j] = Math.min(d[i-1][j], d[i-1][j-1]);
                    d[i][j] = Math.min(d[i][j],  d[i][j-1]) + 1;
                }
                // 더 큰 값 ans에 저장
                ans = Math.max(d[i][j], ans);
            }
        }
        // 변의 길이를 제곱하여 넓이를 출력한다.
        System.out.println(ans*ans);
        in.close();
    }
}