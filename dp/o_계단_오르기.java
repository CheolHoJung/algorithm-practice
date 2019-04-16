package test.boj.dp;

import org.junit.*;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class o_계단_오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] stairPoints = new int[n];
        for (int i = 0; i < n; i++) {
            stairPoints[i] = Integer.parseInt(br.readLine());
        }

        Stairs stairs = new Stairs(n, stairPoints);
        bw.write(String.valueOf(stairs.climb()));

        bw.flush();
        bw.close();
        br.close();
    }


    @Test
    public void test() {
        Stairs stairs = new Stairs(6, new int[]{10, 20, 15, 25, 10, 20});
        assertThat(stairs.climb())
            .isEqualTo(75);
    }

    private static class Stairs {

        private static final int MAX_COUNT = 300;

        private final int[] stairPoints;

        private final int[] dp;

        public Stairs(int n, int[] stairPoints) {
            this.stairPoints = new int[n + 1];
            this.dp = new int[MAX_COUNT + 1];
            for (int i = 1; i <= n; i++) {
                this.stairPoints[i] = stairPoints[i - 1];
            }
        }

        public int climb() {
            dp[1] = this.stairPoints[1];
            dp[2] = dp[1] + this.stairPoints[2];

            for (int i = 3; i < this.stairPoints.length; i++) {
                dp[i] = Math.max(climbOneStair(i), climbTwoStair(i));
            }

            return dp[this.stairPoints.length - 1];
        }

        // 두 칸을 오르는 경우: 두 칸을 오르는 경우에는 3칸 연속 법칙이 성립할 수가 없음
        //                   그러므로 두번 째 이전 칸에서의 최대 포인트과 현재 칸의 포인트를 더함
        private int climbTwoStair(int pos) {
            if (pos < 3) throw new IllegalArgumentException();
            return this.stairPoints[pos] + this.dp[pos - 2];
        }

        // 한 칸을 오르는 경우: 3칸 연속 법칙 때문에 두번 째 이전 칸에 있는 계단과는 함께 오를 수 없음
        //                   그러므로 현재 칸의 포인트와 이전 칸의 포인트를 더한 뒤
        //                   세번 째 이전 칸에서의 최대 포인트와 더함
        private int climbOneStair(int pos) {
            if (pos < 3) throw new IllegalArgumentException();
            return this.stairPoints[pos] + this.stairPoints[pos - 1] + this.dp[pos - 3];
        }
    }
}
