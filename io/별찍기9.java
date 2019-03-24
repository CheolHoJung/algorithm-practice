package test.boj.io;

import org.junit.*;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class 별찍기9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }

    @Test
    public void test() {
        assertThat(solution(5)).isEqualTo(
                "*********\n" +
                " *******\n" +
                "  *****\n" +
                "   ***\n" +
                "    *\n" +
                "   ***\n" +
                "  *****\n" +
                " *******\n" +
                "*********\n"
        );
    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int line = n * 2 - 1;
        int star = line;
        int space = 0;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < space; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < star; j++) {
                sb.append("*");
            }
            if (i >= n - 1) {
                star += 2;
                space--;
            } else {
                star -= 2;
                space++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
