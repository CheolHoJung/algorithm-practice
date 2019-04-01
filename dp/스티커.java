package test.boj.dp;

import org.junit.*;

import java.io.*;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 스티커 {
    static int[][] dp = new int[2][100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < tCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] numbers = new int[2][];
            for (int j = 0; j < 2; j++) {
                int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                numbers[j] = s;
            }

            bw.write(solution2(n, numbers) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    @Test
    public void test2() {
        assertThat(solution(5, new int[][]{
                {50, 10, 100, 20, 40},
                {30, 50, 70, 10, 60},
        })).isEqualTo(260);

        assertThat(solution(7, new int[][]{
                {10, 30, 10, 50, 100, 20, 40},
                {20, 40, 30, 50, 60, 20, 80},
        })).isEqualTo(290);

        assertThat(solution(1, new int[][] {
                {1},
                {1}
        })).isEqualTo(1);

        assertThat(solution(1, new int[][] {
                {0},
                {1}
        })).isEqualTo(1);
    }

    // 대각선으로 이동하면서 값을 더해나감
    // 한칸만 이동할 수 있는게 아니라, 두칸 이상도 이동 가능
    // 그러나, 세칸의 경우를 보면 (위, 아래, 위) 혹은 (아래, 위, 아래)와 같이 한칸씩 이동해서도 도달할 수 있음
    // 세칸을 한번에 이동한 것보다 한칸씩 3번 이동하면서 더한 값이 더 큰게 당연하므로, 한칸 혹은 두칸만 고려하면 됨
    // dp[0 || 1][i] = Math.max(한칸 전, 두칸 전) + a[i]
    private static int solution2(int n, int[][] numbers) {
        dp[0][0] = dp[1][0] = 0;
        dp[0][1] = numbers[0][0];
        dp[1][1] = numbers[1][0];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + numbers[0][i - 1];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + numbers[1][i - 1];
        }
        return Math.max(dp[0][n], dp[1][n]);
    }

    @Test
    public void test() {
        assertThat(solution(5, new int[][]{
                {50, 10, 100, 20, 40},
                {30, 50, 70, 10, 60},
        })).isEqualTo(260);

        assertThat(solution(7, new int[][]{
                {10, 30, 10, 50, 100, 20, 40},
                {20, 40, 30, 50, 60, 20, 80},
        })).isEqualTo(290);

        assertThat(solution(1, new int[][] {
                {1},
                {1}
        })).isEqualTo(1);

        assertThat(solution(1, new int[][] {
                {0},
                {1}
        })).isEqualTo(1);
    }


    //    10 30 10 50 100 20 40
    //    20 40 30 50 60 20 80

    //    (1) 0 40 0 0 100 0 80

    //    (2) 10 40 10 50 100 0 80

    // 첫 반복 -> 위아래좌우 비교했을 때 가장 큰놈 선택
    // 두번째 반복 -> 선택되지 않은 놈들 중, 선택된 놈과 비교해서 교차되는 놈을 선택
    //           -> 좌우 선택된 놈들과 비교했을 때 모두 교차되는 경우가 아니라면 선택 불가
    // 오답
    private static int solution(int n, int[][] numbers) {
        // 1 위, 2 아래
        int[] selected = new int[n];

        for (int i = 0; i < n; i++) {
            int numUp = numbers[0][i];
            int leftUp = i > 0 ? numbers[0][i - 1] : 0;
            int rightUp = i < n - 1 ? numbers[0][i + 1] : 0;
            int numDown = numbers[1][i];

            if (numUp >= leftUp && numUp >= rightUp && numUp >= numDown) {
                selected[i] = 1;
                continue;
            }

            int leftDown = i > 0 ? numbers[1][i - 1] : 0;
            int rightDown = i < n - 1 ? numbers[1][i + 1] : 0;
            if (numDown >= leftDown && numDown >= rightDown && numDown >= numUp) {
                selected[i] = 2;
                continue;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (selected[i] != 0) {
                sum += numbers[selected[i] - 1][i];
                continue;
            }

            int leftSelected = i > 0 ? selected[i - 1] : 0;
            int rightSelected = i < n - 1 ? selected[i + 1] : 0;

            if (leftSelected != 0 && rightSelected == 0) {
                selected[i] = 3 - leftSelected;
                sum += numbers[selected[i] - 1][i];
                continue;
            }

            if (rightSelected != 0 && leftSelected == 0) {
                selected[i] = 3 - rightSelected;
                sum += numbers[selected[i] - 1][i];
                continue;
            }

            if(leftSelected != 0 && rightSelected == leftSelected) {
                selected[i] = 3 - leftSelected;
                sum += numbers[selected[i] - 1][i];
                continue;
            }
        }

        return sum;
    }
}
