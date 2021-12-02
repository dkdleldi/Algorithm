import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_백설공주와일곱난쟁이_3040 {
	static int[] dwarf = new int[9];
	static int[] tgt = new int[7];
	static int[] ans = new int[7];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
		
		for (int i = 0; i < 7; i++) {
			System.out.println(ans[i]);
		}
		
	}
	static void comb(int srcIdx, int tgtIdx) {
		if( tgtIdx == 7 ) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += tgt[i];
			}
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					ans[i] = tgt[i];
				}
			}
			return;
		}			
		if( srcIdx == 9 ) return;
		
		tgt[tgtIdx] = dwarf[srcIdx];
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);			
	}
}
