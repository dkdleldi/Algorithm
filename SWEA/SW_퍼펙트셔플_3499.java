import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_퍼펙트셔플_3499 {
	static int T, N;
	static String[] before1, before2, after;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_3499_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int num = (int) Math.ceil((double)N/2);

			before1 = new String[num];
			before2 = new String[N-num];
			after = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				if( i < num ) before1[i] = st.nextToken();
				else before2[i - num] = st.nextToken();
			}
			
			for (int i = 0; i < N; i++) {
				if( i % 2 == 0 ) after[i] = before1[i/2];
				else after[i] = before2[i/2];
			}
			
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(after[i] + " ");
			}
			System.out.println();
		}
	}
}
