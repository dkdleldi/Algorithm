package pg;

import java.util.Arrays;

public class PG_카펫 {

	public static void main(String[] args) throws Exception {
		int brown = 24;
		int yellow = 24;
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

	static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpet = brown + yellow;
        for (int i = carpet-2; i > 0; i--) {
			if(carpet % i == 0) {
				if(((i*2) + ((carpet/i-2)*2)) == brown) {
					answer[0] = i;
					answer[1] = carpet / i;
					break;
				}
			}
		}
        return answer;
    }
}
