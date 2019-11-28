import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
// 백준 1890번.점프
class No1890 {
 
    static int N;
    static int[][] map;
    static long[][] dp;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        dp = new long[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(solve(0,0));
    }
    
    static long solve(int x, int y) {
        
        if(dp[x][y] != -1)
            return dp[x][y];
        
        if(x == N-1 && y == N-1) {
            return 1;
        }
        
        if(map[x][y] == 0) 
            return 0;
        
        dp[x][y] = 0;
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i]*map[x][y];
            int ny = y + dy[i]*map[x][y];
            
            if(!isRange(nx, ny))
                continue;
            
            dp[x][y] += solve(nx,ny);
        }
        return dp[x][y];
    }
 
    static boolean isRange(int x , int y) {
        if(  x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
    
}