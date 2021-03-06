package test.boj.io;

import org.junit.*;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class 별찍기16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }

    @Test
    public void test() {
        assertThat(solution(4)).isEqualTo( 
            "   * \n" +
            "  * * \n" +
            " * * * \n" +
            "* * * * \n"
        );

    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = n - (i + 1); j > 0; j--) {
                sb.append(" ");
            }
            for (int j = 0; j <= i; j++) {
                sb.append("* ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
