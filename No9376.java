import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ#9376 탈옥
 * https://www.acmicpc.net/problem/9376
 */

public class No9376 {

    static final int BLANK = 0;
    static final int WALL = -1;
    static final int PRISON = 1;
    static final int DOOR = 2;

    static final int[] dRow = {0, -1, 0, 1};
    static final int[] dCol = {-1, 0, 1, 0};

    static int[][] map = new int[105][105];
    static int h, w;

    public static void main(String[] args) throws IOException {
    	// t는 test case의 개수
        int t;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            
            Node helper = new Node(0, 0);
            Node prison1 = new Node(-1, -1);
            Node prison2 = new Node(-1, -1);
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken()) + 2;
            w = Integer.parseInt(st.nextToken()) + 2;
            // 감옥 map 입력받기. 가장자리에 '.'을 붙여서 만든다.
            for (int i = 1; i < h - 1; i++) {

                String s = "." + br.readLine() + ".";
                for (int j = 0; j < w; j++) {

                    char c = s.charAt(j);
                    
                    // 입력받은 값에 따라서 '.'이면 BLANK, '*'이면 WALL, '$'이면 PRISON 으로 map 변환
                    switch (c) {

                        case '.':
                            map[i][j] = BLANK;
                            break;
                        case '*':
                            map[i][j] = WALL;
                            break;
                        case '$':
                            map[i][j] = PRISON;
                            // 위치 찾은 prisoner의 row, col값 저장
                            if (prison1.row == -1) {

                                prison1 = new Node(i, j);
                            } else {

                                prison2 = new Node(i, j);
                            }
                            break;
                        case '#':
                            map[i][j] = DOOR;
                            break;
                    }
                }
            }

            for (int j = 0; j < w; j++) {

                map[0][j] = map[h - 1][j] = BLANK;
            }

            // 감옥 안의 두 사람, 감옥 밖의 한 사람을 기준으로 각각 bfs 실행
            int[][] dist1 = bfs(helper);
            int[][] dist2 = bfs(prison1);
            int[][] dist3 = bfs(prison2);

            int ans = h * w;
            int tempCost = 0;
            
            // 세 사람의 dist를 합쳐서 최소값을 print 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {

                    if (map[i][j] == WALL) continue;

                    tempCost = dist1[i][j] + dist2[i][j] + dist3[i][j];
                    if (map[i][j] == DOOR) tempCost -= 2;

                    ans = ans > tempCost ? tempCost : ans;
                }
            }

            System.out.println(ans);

        } // ~while loop

    } // ~main
    
    // 만난 문의 개수를 dist에 저장
    static int[][] bfs(Node src) {

        int[][] dist = new int[h][w];

        for (int i = 0; i < h; i++) {

            Arrays.fill(dist[i], -1);
        }

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(src);
        dist[src.row][src.col] = 0;

        while (!queue.isEmpty()) {

            Node u = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nextRow = u.row + dRow[i];
                int nextCol = u.col + dCol[i];

                if (nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w) continue;
                if (map[nextRow][nextCol] == WALL) continue;


                if (map[nextRow][nextCol] == BLANK || map[nextRow][nextCol] == PRISON) {

                    if (dist[nextRow][nextCol] == -1 || dist[nextRow][nextCol] > dist[u.row][u.col]) {

                        dist[nextRow][nextCol] = dist[u.row][u.col];
                        queue.add(new Node(nextRow, nextCol));
                    }
                } else if (map[nextRow][nextCol] == DOOR) {

                    if (dist[nextRow][nextCol] == -1 || dist[nextRow][nextCol] > dist[u.row][u.col] + 1) {

                        dist[nextRow][nextCol] = dist[u.row][u.col] + 1;
                        queue.add(new Node(nextRow, nextCol));
                    }
                }
            }
        }

        return dist;
    }

    static void printMap(int[][] arr) {

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }
}

class Node {

    int row;
    int col;

    Node(int row, int col) {

        this.row = row;
        this.col = col;
    }
}