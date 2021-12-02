import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_원점으로집합_8458 {

	static int T, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int max = 0;
			boolean even = true;
			boolean b = true;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int abs = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				if(i == 0) {
					if(abs % 2 == 0) even = true;
					else even = false;
				}
				else if((!even && abs % 2 == 0) || (even && abs % 2 == 1)) {
					b = false;
				}
				max = Math.max(max, abs);
			}
			if(!b) {
				//sb.append("#").append(t).append(" ").append(-1).append("\n");
				System.out.println("#" + t + " " + -1);
				continue;
			}
			int ans = 0;
			int sum = 0;
			while(true) {
				if(max <= sum && ((max % 2 == 0 && sum % 2 == 0) || (max % 2 == 1 && sum % 2 == 1))) {
					break;
				}
				sum += ++ans;
			}
			//sb.append("#").append(t).append(" ").append(ans).append("\n");
			System.out.println("#" + t + " " + ans);
		}
		//System.out.println(sb);
	}
}
