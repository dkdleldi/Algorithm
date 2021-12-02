package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Z {
	static int N, r, c, plus, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int start = 0;
		int end = (int) Math.pow(2, N) - 1;
		int plus = ((int) Math.pow(2, N) * (int) Math.pow(2, N)) / 4;
		search(start, end, start, end, plus);
		System.out.println(ans);
	}
	static void search(int rStart, int rEnd, int cStart, int cEnd, int plus) {		
		if(rStart == rEnd || cStart == cEnd) {
			return;
		}
		int rMid = (rStart + rEnd) / 2;
		int cMid = (cStart + cEnd) / 2;
		if(r <= rMid && c <= cMid) {
			ans = ans + plus * 0;
			search(rStart, rMid, cStart, cMid, plus/4);	
		}
		else if(r <= rMid && c > cMid) {
			ans = ans + plus * 1;
			search(rStart, rMid, cMid+1, cEnd, plus/4);
		}
		else if(r > rMid && c <= cMid) {
			ans = ans + plus * 2;
			search(rMid+1, rEnd, cStart, cMid, plus/4);
		}
		else if(r > rMid && c > cMid) {
			ans = ans + plus * 3;
			search(rMid+1, rEnd, cMid+1, cEnd, plus/4);
		}	
	}
}
