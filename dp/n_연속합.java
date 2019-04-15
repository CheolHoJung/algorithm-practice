package test.boj.dp;

import org.junit.*;

import java.io.*;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class n_연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ContinuousSum continuousSum = new ContinuousSum(n, br.readLine());
        System.out.println(continuousSum.max());

        bw.flush();
        bw.close();
        br.close();

    }

    @Test
    public void test() {
        assertThat(solution(10, "10 -4 3 1 5 6 -35 12 21 -1"))
                .isEqualTo(33);
        assertThat(solution(1, "1"))
                .isEqualTo(1);
        assertThat(solution(1, "-1000"))
                .isEqualTo(-1000);
        assertThat(solution(2, "-2000 -1000"))
                .isEqualTo(-1000);
        assertThat(solution(2, "-1000 -2000"))
                .isEqualTo(-1000);
        assertThat(solution(3, "-1000 5 1000"))
                .isEqualTo(1005);
        assertThat(solution(5, "-3 -1 2 -1 5"))
                .isEqualTo(6);
    }

    private int solution(int n, String numbers) {
        ContinuousSum continuousSum = new ContinuousSum(n, numbers);
        return continuousSum.max();
    }

    static class ContinuousSum {

        private final int n;
        private final int[] numbers;
        private final int[] dp;

        public ContinuousSum(int n, String numbers) {
            this.n = n;
            this.dp = new int[n + 1];
            this.numbers = new int[n + 1];
            StringTokenizer tokenizer = new StringTokenizer(numbers);
            for (int i = 1; i <= n; i++) {
                this.numbers[i] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // 현재 숫자를 이전 숫자까지의 합과 더한 경우와
        // 현재 숫자부터 시작하는 경우로 나눌 수 있음
        // dp[i - 1] + this.numbers[i]: 현재 숫자를 이전 숫자까지의 합과 더한 경우
        // this.numbers[i]: 현재 숫자부터 시작하는 경우
        //      -1000    5      1000
        // dp   -1000    5      1005
        // O             -1005  1005
        // X             5      1000
        public int max() {
            int result = this.numbers[1];
            dp[1] = this.numbers[1];

            for (int i = 2; i <= n; i++) {

                dp[i] = Math.max(
                    dp[i - 1] + this.numbers[i],
                    this.numbers[i]
                );

                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
}
