package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_멀티탭스케줄링_1700 {

	static int N, K, cnt;
	static int[] use;
	static int[] plug;
	static int[] mulTap;
	static boolean[] using;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		use = new int[K+1];
		using = new boolean[K+1];
		plug = new int[K];
		mulTap = new int[N];		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());
			use[num]++;
			plug[i] = num;
		}
		
		int pNum = 0;
		int max = 0;
		int idx = 0;
		for (int i = 0; i < K; i++) {
			boolean b = false;
			use[plug[i]]--;
			if(using[plug[i]]) continue;
			
			for (int j = 0; j < N; j++) {
				if(mulTap[j] == 0) {
					mulTap[j] = plug[i];
					using[plug[i]] = true;
					b = true;
					pNum++;
					break;
				}
				
				else if(pNum == N) {
					if(use[mulTap[j]] == 0) {
						using[mulTap[j]] = false;
						using[plug[i]] = true;
						mulTap[j] = plug[i];						
						cnt++;
						b = true;
						break;
					}
					else {
						if(i+1 == K) break;
						for (int k = i+1; k < K; k++) {
							if(mulTap[j] == plug[k]) {
								if(k > max) {
									max = k;
									idx = j;
								}
								break;
							}
						}
					}
				}
			}
			if(!b) {
				using[mulTap[idx]] = false;
				using[plug[i]] = true;
				mulTap[idx] = plug[i];			
				cnt++;
			}			
		}
		
		System.out.println(cnt);
	}
}
