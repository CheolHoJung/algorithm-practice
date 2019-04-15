package test.boj.dp;

import org.junit.*;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

// https://cheolhojung.github.io/posts/algorithm/boj-biotonic-partial-sequence.html
public class m_가장_긴_바이토닉_부분_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        BitonicSubSequence biTonicSubNumbers = new BitonicSubSequence(n, br.readLine());
        System.out.println(biTonicSubNumbers.maxLength());

        bw.flush();
        bw.close();
        br.close();
    }

    @Test
    public void test() {
        assertThat(solution(1, "1"))
            .isEqualTo(1);
        assertThat(solution(10, "1 5 2 1 4 3 4 5 2 1"))
            .isEqualTo(7);
        assertThat(solution(7, "10 5 10 20 10 30 5"))
                .isEqualTo(5);
    }

    private int solution(int n, String numbers) {
        BitonicSubSequence biTonicSubNumbers = new BitonicSubSequence(n, numbers);

        return biTonicSubNumbers.maxLength();
    }

    static class BitonicSubSequence {

        private static final int MAX_LENGTH = 1000;
        private static final int PREV_SMALLER = 0;
        private static final int NEXT_SMALLER = 1;

        private final int n;
        private final int[] numbers;

        private int[][] dp;

        public BitonicSubSequence(int n, String numbers) {
            this.n = n;
            this.numbers = new int[n + 2];
            this.dp = new int[2][MAX_LENGTH + 1];

            StringTokenizer tokenizer = new StringTokenizer(numbers);
            for (int i = 1; i <= n; i++) {
                this.numbers[i] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        public int maxLength() {
            int result = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                dp[PREV_SMALLER][i] = maxLengthPrevSmallerNumbers(i) + 1;
            }

            for (int i = n; i >= 1; i--) {
                dp[NEXT_SMALLER][i] = maxLengthNextSmallerNumbers(i) + 1;
                result = Math.max(result, dp[NEXT_SMALLER][i] + dp[PREV_SMALLER][i] - 1);
            }

            return result;
        }

        private int maxLengthNextSmallerNumbers(int i) {
            return maxRangeClosed(i + 1, n, i, NEXT_SMALLER);
        }

        private int maxLengthPrevSmallerNumbers(int i) {
            return maxRangeClosed(1, i - 1, i, PREV_SMALLER);
        }

        private int maxRangeClosed(int start, int end, int i, int SMALLER_INDEX) {
            return IntStream.rangeClosed(start, end)
                    .map(j -> max(i, j, SMALLER_INDEX))
                    .max()
                    .orElse(0);
        }

        private int max(int i, int j, int SMALLER_INDEX) {
            if (this.numbers[i] > this.numbers[j]) {
                return dp[SMALLER_INDEX][j];
            }
            return 0;
        }

//        private int maxLengthNextSmallerNumbers2(int i) {
//            int result = 0;
//            for (int j = i + 1; j <= n; j++) {
//                result = max(result, i, j, NEXT_SMALLER);
//            }
//            return result;
//        }
//
//        private int maxLengthPrevSmallerNumbers2(int i) {
//            int result = 0;
//            for (int j = i - 1; j >= 1; j--) {
//                result = max(result, i, j, PREV_SMALLER);
//            }
//            return result;
//        }
//
//        private int max(int result, int i, int j, int SMALLER_INDEX) {
//            if (this.numbers[i] > this.numbers[j]) {
//                return Math.max(result, dp[SMALLER_INDEX][j]);
//            }
//            return result;
//        }
    }
}
