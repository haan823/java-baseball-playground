package numberbaseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<Integer> input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String nextLine = scanner.nextLine();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(Integer.valueOf(Character.getNumericValue(nextLine.charAt(i))));
        }
        return result;
    }

    public static boolean replay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int nextInt = scanner.nextInt();
        if (nextInt == 1) {
            return true;
        }
        return false;
    }
}
