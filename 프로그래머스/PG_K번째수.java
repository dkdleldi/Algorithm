package pg;

import java.util.Arrays;

public class PG_K번째수 {

	public static void main(String[] args) throws Exception {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution(array, commands)));
	}

	static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
        	int idx = commands[i][1]-commands[i][0]+1;
			int[] temp = new int[idx];
			int n = commands[i][0]-1;
			for (int j = 0; j < idx; j++) {
				temp[j] = array[n++];
			}
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2]-1];
		}
        return answer;
    }
}
