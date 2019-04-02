package test.boj.dp;

import java.io.*;

public class 포도주_시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(N, wines));

        br.close();
        bw.flush();
        bw.close();
    }

//    @Test
//    public void test() {
//        assertThat(solution(1, new int[]{0, 6}))
//                .isEqualTo(6);
//        assertThat(solution(2, new int[]{0, 6, 10}))
//                .isEqualTo(16);
//        assertThat(solution(3, new int[]{0, 6, 10, 13}))
//                .isEqualTo(23);
//        assertThat(solution(4, new int[]{0, 6, 10, 13, 10}))
//                .isEqualTo(29);
//        assertThat(solution(4, new int[]{0, 10, 6, 13, 10}))
//                .isEqualTo(33);
//        assertThat(solution(6, new int[]{0, 6, 10, 13, 9, 8, 1}))
//                .isEqualTo(33);
//        assertThat(solution(6, new int[]{0, 1, 10, 13, 9, 8, 6}))
//                .isEqualTo(37);
//    }


//    1. 내가 현재의 포도주를 먹지 않았을 경우 (dp[i - 1])
//    2. 현재의 포도주를 마시고 이전 꺼를 안마실 경우 (wine[i] + dp[i - 2]
//    3. 현재와 이전 포도주 모두를 마신 경우 (wine[i] + wine[i - 1] + Dp[i - 3])
//
//    wine	0	6	10	13	9	8	1
//    dp	0	6	16	23	28	33	33
//    1. 	x	x   x   16	23	28	33
//    2. 	x	x   x   19	25	31	29
//    3. 	x	x   x   23	28	33	32
//
//    wine	0	1	10	13	9	8	6
//    dp	0	1	11	23	23	31	37
//    1. 	x	x   x   11	23	23	31
//    2. 	x	x   x   14	20	31	29
//    3. 	x	x   x   23	23	28	37
    private static int solution(int N, int[] wines) {
        int[] dp = new int[10_010];
        for (int i = 1; i < 3 && i <= N; i++) {
            if (i == 1) {
                dp[i] = wines[1];
                continue;
            }
            dp[i] = wines[i] + wines[i - 1];
        }

        for (int i = 3; i <= N; i++) {
            int result = Math.max(dp[i - 1], wines[i] + dp[i - 2]);
            result = Math.max(result, wines[i] + wines[i - 1] + dp[i - 3]);
            dp[i] = result;
        }

        return dp[N];
    }
}
