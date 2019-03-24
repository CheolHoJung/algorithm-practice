package test.boj.io;

import org.junit.*;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class 별찍기5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }

    @Test
    public void test() {
        assertThat(solution(5)).isEqualTo(
            "    *\n" +
            "   ***\n" +
            "  *****\n" +
            " *******\n" +
            "*********\n"
        );
    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int k = n - (i + 1); k > 0; k--) {
                sb.append(" ");
            }

            for (int j = (i + 1) * 2 - 1; j > 0; j--) {
                sb.append("*");
            }
            sb.append("\n");

        }

        return sb.toString();
    }
}
