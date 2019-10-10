"""
입력
포켓몬도감 

출력
문제가 알파벳 -> 포켓몬 번호, 숫자 -> 포켓몬 번호에 해당하는 문자
"""
// 못 풀었습니다..
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1620 {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음. n은 총 포켓몬 수, m은 찾아야하는 질문 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] a = new String[N];

		// 포켓몬 도감 만들기
		HashMap<String, String> pocket = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			String pocketmon = br.readLine();
			pocket.put(pocketmon, Integer.toString(i+1));
			a[i] = pocketmon;
		}
		
        // 문제 받기
        for (int j = 0; j<M; j++){
			try{
				int n = Integer.parseInt(br.readLine());
				System.out.println(a[n-1]);
			}
			catch(NumberFormatException e){
				String name = br.readLine();
				System.out.println(pocket.get(name));
			}
        }

		br.close();
	}
}
