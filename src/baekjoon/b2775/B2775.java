package baekjoon.b2775;

import java.util.Scanner;

public class B2775 {

	public static int[][] apart = new int[15][15];
	private static int k, n;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			k = input.nextInt();
			n = input.nextInt();

			for (int j = 0; j <= n; j++) {
				apart[0][j] = j;
			}

			for (int i = 1; i <= k; i++) {
				int temp = 0;
				for (int j = 1; j <= n; j++) {
					temp += apart[i - 1][j];
					apart[i][j] = temp;
				}
			}

			System.out.println(apart[k][n]);

		}

		input.close();

	}

}
