package test.boj.dp;

        import org.junit.*;

        import java.io.*;

        import static org.assertj.core.api.Assertions.assertThat;

public class r_파도반_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < tCase; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(solution(N)) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    @Test
    public void test() {
        assertThat(solution(1))
                .isEqualTo(1L);
        assertThat(solution(2))
                .isEqualTo(1L);
        assertThat(solution(12))
                .isEqualTo(16L);
        assertThat(solution(100))
                .isEqualTo(888855064897L);
    }


    //  i	    1	2	3	4	5	6		7		8		9		10		11
//  dp[i]   1	1	1	2	2	3		4		5		7		9		12
//          1	1	1	2	2	2 + 1		3 + 1		4 + 1		5 + 2		7 + 2		9 + 3
//          1	1	1	2	2	dp[5] + dp[1..3]	dp[6] + dp[1..3]	dp[7] + dp[1..3]	dp[8] + dp[4..5]	dp[9] + dp[4..5]	dp[10] + dp[6]
//  -> dp[i - 1] + dp[i - 5] (i > 5)
    private static long solution(int N) {
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        return dp[N];
    }
}
