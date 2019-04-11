package test.boj.dp;

import org.junit.*;

import java.io.*;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class k_가장_큰_증가_부분_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(("0 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(n, numbers));

        bw.flush();
        bw.close();
        br.close();
    }

    @Test
    public void test() {
        assertThat(solution(10, new int[]{0, 1, 100, 2, 50, 60, 3, 5, 6, 7, 8}))
            .isEqualTo(113);
    }

    // 자신보다 작은 숫자들의 부분수열에서 합이 가장 큰 경우를 구해야 한다. -> dp[i - 1], Math.max 사용
    // 자신보다 작은 숫자들의 부분수열에서 합이 같은 경우는 하나만 선택해도 상관없다.

    // maxSumOfSmallerNumbers(i) = numbers[i]보다 작은 숫자들의 부분수열에서 가장 큰 합을 가진 부분수열의 합
    // dp[i] = maxSumOfSmallerNumbers(i) + numbers[i]

    // i       0   1    2   3   4   5   6
    // numbers 0 | 1    100 2   50  60  3
    // dp      0 | 1    101 3   53  113 6
    private static int solution(int n, int[] numbers) {
        int[] dpOfMaxSum = new int[1001];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dpOfMaxSum[i] = maxSumOfSmallerNumbers(dpOfMaxSum, numbers, i) + numbers[i];
            max = Math.max(max, dpOfMaxSum[i]);
        }

        return max;
    }

    private static int maxSumOfSmallerNumbers(int[] dpOfMaxSum, int[] numbers, int i) {
        int max = 0;
        int now = numbers[i];
        for (int j =  i - 1; j >= 0; j--) {
            int prev = numbers[j];
            if (prev < now) {
                max = Math.max(max, dpOfMaxSum[j]);
            }
        }
        return max;
    }
}
