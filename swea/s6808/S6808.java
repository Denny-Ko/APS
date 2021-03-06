package s6808;

import java.util.Scanner;

public class S6808 {

	private static int[] card;
	private static int N;
	private static int ansWin, ansLose;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 1. 입력
			N = 18;

			card = new int[N / 2];

			for (int i = 0; i < N / 2; i++) {

				card[i] = input.nextInt();

			}

			// 2. 계산
			perm(N);

			// 3. 결과 출력
			System.out.printf("#%d %d %d\n", tc, ansWin, ansLose);

		}

		input.close();

	}

	/**
	 * 1. ans변수 초기화 2. 방문체크를 위한 배열 생성 3. 순열 생성
	 * 
	 * @param N : 총 카드의 수
	 */
	private static void perm(int N) {
		// ans 초기화
		ansWin = 0;
		ansLose = 0;

		// visited 생성
		boolean[] visited = new boolean[N + 1];

		for (int idx : card) {
			visited[idx] = true;
		}

		// 순열
		permUtil(0, visited, new int[9]);
	}

	private static void permUtil(int idx, boolean[] visited, int[] result) {
		// base-case
		if (idx == 9) {

			game(result);
			
			return;

		}

		// recursive-case
		for (int i = 1; i <= N; i++) {

			if (visited[i])
				continue;

			result[idx] = i;

			visited[i] = true;

			permUtil(idx + 1, visited, result);

			visited[i] = false;

		}

	}

	private static void game(int[] result) {
		
		int scoreW = 0;
		int scoreL = 0;

		for (int i = 0; i < 9; i++) {

			if (card[i] > result[i])
				scoreW += card[i] + result[i];
			else if (card[i] < result[i])
				scoreL += card[i] + result[i];

		}

		if (scoreW > scoreL)
			++ansWin;
		else if (scoreW < scoreL)
			++ansLose;

	}

}
