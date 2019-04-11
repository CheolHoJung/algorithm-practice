package test.boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class l_가장_긴_감소하는_부분_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Numbers numbers = new Numbers(n, br.readLine());
        System.out.println(numbers.maxLengthOfDecreaseSubNumbers());

        bw.flush();
        bw.close();
        br.close();
    }

//    @Test
//    public void test() {
//        Numbers numbers = new Numbers(6, "10 30 10 20 20 10");
//        assertThat(numbers.maxLengthOfDecreaseSubNumbers())
//            .isEqualTo(3);
//    }

    static class Numbers {
        private static final int MAX_N = 1000;

        private final int[] numbers;
        private final int[] dpOfLength;

        public Numbers(int n, String numbers) {
            this.dpOfLength = new int[MAX_N + 1];
            this.numbers = createNumbers(n, numbers);
        }

        private int[] createNumbers(int n, String numbers) {
            StringTokenizer tokenizer = new StringTokenizer(numbers);

            int[] result = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                result[i] = Integer.parseInt(tokenizer.nextToken());
            }
            return result;
        }

        //        maxLengthOfLagerNumbers -> numbers[i]보다 큰 숫자들의 부분수열에서 길이가 가장 큰 부분수열의 길이
//        dp[i] = maxLengthOfSmallerNumbers(i) + 1
//
//        i       	0	1	2	3	4	5	6
//        numbers	0	10	30	10	20	20	10
//        dp	    0	1	1	2	2	2	3
        public int maxLengthOfDecreaseSubNumbers() {
            int max = 0;

            for (int i = 1; i < numbers.length; i++) {
                dpOfLength[i] = maxLengthOfLagerNumbers(i) + 1;
                max = Math.max(max, dpOfLength[i]);
            }

            return max;
        }

        private int maxLengthOfLagerNumbers(int i) {
            int maxLength = 0;

            for (int j = i - 1; j >= 0; j--) {
                maxLength = getMaxLength(maxLength, i, j);
            }

            return maxLength;
        }

        private int getMaxLength(int nowLength, int nowIndex, int prevIndex) {
            if (numbers[prevIndex] > numbers[nowIndex]) {
                return Math.max(nowLength, dpOfLength[prevIndex]);
            }

            return nowLength;
        }
    }
}
