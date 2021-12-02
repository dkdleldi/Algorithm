package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Flatten {
	static int dump, minIdx, maxIdx;
	static int[] box;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			dump = Integer.parseInt(br.readLine());
			box = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 100; j++) {
				box[j] = Integer.parseInt(st.nextToken());
			}
			reset();
			for (int j = 0; j < dump; j++) {
				if(box[maxIdx] - box[minIdx] == 0 || box[maxIdx] - box[minIdx] == 1) break;
				box[minIdx]++;
				box[maxIdx]--;
				reset();
			}
			System.out.println("#"+ (i+1) + " " + (box[maxIdx] - box[minIdx]));
		}
	
		
	}
	static void reset() {
		for (int i = 0; i < 100; i++) {
			if(box[i] < box[minIdx]) minIdx = i;
			if(box[i] > box[maxIdx]) maxIdx = i;
		}
	}
	
}
