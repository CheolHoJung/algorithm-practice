package test.boj.dp;

import org.junit.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class dp_1로만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solutionDp(sc.nextInt()));
    }

    @Test
    public void test() {
        assertThat(solutionBfs(1000000))
            .isEqualTo(19);

        assertThat(solutionDp(1000000))
            .isEqualTo(19);
    }

    private static int solutionDp(int X) {
        int[] dp = new int[1000001];
        dp[2] = dp[3] = 1;

        for (int i = 4; i <= X; i++) {
            // dp[3]은 (3) / 3 = 1회
            // dp[4]는 (4 - 1) / 3 = 2회
            // dp[5]는 (5 - 1 - 1) / 3 = 3회
            // dp[6]은 (6) / 3 - 1 = 2회
            // dp[7]은 (7 - 1) / 3 - 1 = 3회
            // dp[8]은 (8) / 2 / 2 / 2 = 3회
            // dp[9]는 (9) / 3 / 3 = 2회
            // dp[10]은 (10 - 1) / 3 = 2회

            // dp[4] = dp[3] + 1 = 2회 -> Math.min(dp[4]: 2, dp[2] + 1: 2) = 2회
            // dp[5] = dp[4] + 1 = 3회
            // dp[6] = dp[5] + 1 = 4회 -> / 2: Math.min(dp[6]: 4, dp[3] + 1: 2) = 2회 -> / 3: Math.min(dp[6]: 4, dp[2] + 1: 2) = 2회
            // dp[7] = dp[6] + 1 = 3회
            // dp[8] = dp[7] + 1 = 4회 -> Math.min(dp[8]: 4, dp[4] + 1: 3) = 3회
            // dp[9] = dp[8] + 1 = 4회 -> Math.min(dp[9]: 4, dp[3] + 1: 1) = 2회
            // dp[10] = dp[9] + 1 = 3회 -> math.min(dp[10]: 3, dp[5] + 1: 4) = 3회

            // 3. D[N] = D[N - 1] + 1
            dp[i] = dp[i - 1] + 1;

            // 2. D[N] = D[N / 2] + 1
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 1. D[N] = D[N / 3] + 1
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[X];
    }

    // 1 <= X <= 10^6 (1M): O(N) or O(N log N)
    // timeout
    static boolean[] visit;
    private static int solutionBfs(int X) {
        visit = new boolean[1000001];
        return bfs(X);
    }

    private static int bfs(int X) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();

        xQueue.add(X);
        countQueue.add(0);
        while (true) {
            int x = xQueue.poll();
            int count = countQueue.poll();

            if (x == 1) {
                return count;
            }
            if (!visit[x - 1]) {
                xQueue.add(x - 1);
                countQueue.add(count + 1);
            }
            if (!visit[x / 2] && x % 2 == 0) {
                xQueue.add(x / 2);
                countQueue.add(count + 1);
            }
            if (!visit[x / 3] && x % 3 == 0) {
                xQueue.add(x / 3);
                countQueue.add(count + 1);
            }

            visit[x] = true;
        }
    }

    // result is not min
    private int solution(int X) {
        int count = 0;
        while (X != 1) {
            if (X % 3 == 0) {
                X /= 3;
            } else if (X % 2 == 0) {
                X /= 2;
            } else {
                X--;
            }

            count++;
        }
        return count;
    }
}
