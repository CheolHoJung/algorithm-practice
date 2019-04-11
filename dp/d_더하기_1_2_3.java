package test.boj.dp;

import org.junit.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class d_더하기_1_2_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int t_case = 0 ; t_case < num ; t_case++){

            int n = Integer.parseInt(br.readLine());
            int dp[] = new int[12];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i = 4; i <= n ; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            bw.append(String.valueOf(dp[n]+"\n"));
        }
        bw.close();
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] result = solution(IntStream.range(0, n)
//                .map(i -> sc.nextInt())
//                .toArray());
//
//        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
//    }

    @Test
    public void test_점화식_사용() {
        assertThat(solution2(new int[]{1, 2, 3}))
                .isEqualTo(new int[]{1, 2, 4});

        assertThat(solution2(new int[]{4, 7, 10}))
                .isEqualTo(new int[]{7, 44, 274});
    }

    private int[] solution2(int[] nums) {
        int[] result = new int[nums.length];
        int dp[] = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= 10; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int tCase = 0; tCase < nums.length; tCase++){
            int caseNum = nums[tCase];
            result[tCase] = dp[caseNum];
        }
        return result;
    }

    @Test
    public void test_단계마다_계산() {
        assertThat(solution(new int[]{1, 2, 3}))
                .isEqualTo(new int[]{1, 2, 4});

        assertThat(solution(new int[]{4, 7, 10}))
            .isEqualTo(new int[]{7, 44, 274});
    }

    private static int[] solution(int[] testCases) {
        final int[] result = new int[testCases.length];
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(Arrays.asList(1, 2, 3));

        for (int step = 0; step < 10; step++) {
            List<Integer> prevSums = stack.pop();
            List<Integer> sums = new ArrayList<>();
            for (int prevSum : prevSums) {
                for (int j = 0; j < testCases.length; j++) {
                    if (prevSum == testCases[j]) {
                        result[j]++;
                    }
                }

                if (step == 9) break;

                for (int numToSum = 1; numToSum <= 3; numToSum++) {
                    int sum = numToSum + prevSum;
                    sums.add(sum);
                }
            }
            stack.push(sums);
        }
        return result;
    }
}
