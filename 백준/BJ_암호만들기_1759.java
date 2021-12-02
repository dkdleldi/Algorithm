import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_암호만들기_1759 {

	static int L, C;
	static char[] alphabet;
	static char[] tgt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = new char[C];
		tgt = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);			
		}
		Arrays.sort(alphabet);
		comb(0, 0, 0, 0);
	}
	
	static void comb(int srcIdx, int tgtIdx, int con, int vowel) {
		if(tgtIdx == L) {
			if(con >= 1 && vowel >= 2) System.out.println(tgt);			
			return;
		}
		if(srcIdx == C) return;
		
		int conTemp = con;
		int vowelTemp = vowel;
		tgt[tgtIdx] = alphabet[srcIdx];
		if(tgt[tgtIdx] == 'a' || tgt[tgtIdx] == 'e' || tgt[tgtIdx] == 'i' || tgt[tgtIdx] == 'o' || tgt[tgtIdx] == 'u') {
			conTemp++;
		}
		else vowelTemp++;
		comb(srcIdx+1, tgtIdx+1, conTemp, vowelTemp);
		comb(srcIdx+1, tgtIdx, con, vowel);
	}
}
