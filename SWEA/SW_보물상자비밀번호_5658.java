package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_보물상자비밀번호_5658 {

	static int T, N, K, ans;
	static char[] num;
	static ArrayList<String> key;
	static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			num = br.readLine().toCharArray();
			key = new ArrayList<String>();
			for (int i = 0; i < N/4; i++) {
				number(i);
				rotate();
			}
			Collections.sort(key);
			ans = 0;
			toNum();
			System.out.println("#" + t + " " + ans);
		}
	}

	static void toNum() {
		int idx = key.size()-K;
		char[] change = key.get(idx).toCharArray();
		int hexIdx = 0;
		for (int i = change.length-1; i >= 0; i--) {
			int n = 0;
			for (int j = 0; j < 16; j++) {
				if(change[i] == hex[j]) n = j;
			}
			ans += (int)Math.pow(16, hexIdx) * n;
			hexIdx++;
		}
	}
	
	static void number(int idx) {
		int jIdx = 0;
		for (int i = idx*4; i < idx*4 + 4; i++) {
			String temp = "";
			for (int j = jIdx; j < jIdx + N/4; j++) {
				temp += Character.toString(num[j]);
			}
			jIdx = jIdx + N/4;
			boolean same = false;
			for (int j = 0; j < key.size(); j++) {
				if(temp.equals(key.get(j))) {
					same = true;
					break;
				}
			}
			if(!same) key.add(temp);
		}
	}
	
	static void rotate() {
		int len = num.length;
		char temp = num[len-1];
		for (int i = len-2; i >= 0; i--) {
			num[i+1] = num[i];
		}
		num[0] = temp;
	}
}
