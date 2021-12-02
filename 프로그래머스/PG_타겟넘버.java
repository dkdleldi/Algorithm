package pg;

public class PG_타겟넘버 {

	public static void main(String[] args) throws Exception {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	static int answer = 0;
	
	static int solution(int[] numbers, int target) {
        int size = numbers.length;
        dfs(0, 0, size, numbers, target);
        return answer;
    }
	
	static void dfs(int sum, int idx, int size, int[] numbers, int target) {
		if(idx == size && sum == target) {
			answer++;
			return;
		}
		if(idx == size) return;
		dfs(sum-numbers[idx], idx+1, size, numbers, target);
		dfs(sum+numbers[idx], idx+1, size, numbers, target);
	}
}
