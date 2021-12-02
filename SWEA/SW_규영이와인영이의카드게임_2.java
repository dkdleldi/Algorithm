package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_규영이와인영이의카드게임_2 {
	static int T, win, lose, draw;
	static int[] gyu = new int[9];
	static int[] in = new int[9];
	static int[] tgt = new int[9];
	static boolean[] card;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			card = new boolean[19];
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				card[gyu[i]] = true;
			}
			int index = 0;
			for (int i = 1; i <= 18; i++) {				
				if(card[i] == false) {
					in[index] = i;
					index++;					
				}
			}
			perm(0, 0);
			
			System.out.println("#" + t + " " + win + " " + lose);
			win = 0;
			lose = 0;
			draw = 0;
		}

	}
	static void perm(int tgtIdx, int flag) {
		if(tgtIdx == 9) {
			compare();
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if( (flag & 1<<i) != 0 ) continue;
			tgt[tgtIdx] = in[i];
			perm(tgtIdx + 1, flag | 1 << i);			
		}
		
	}
	static void compare() {
		int gyuSum = 0, inSum = 0;
		for (int i = 0; i < 9; i++) {
			if(gyu[i] > tgt[i]) gyuSum = gyuSum + gyu[i] + tgt[i];
			else inSum = inSum + tgt[i] + gyu[i];
		}
		if(gyuSum > inSum) win++;
		else if(gyuSum == inSum) draw++;
		else lose++;
	}
}
