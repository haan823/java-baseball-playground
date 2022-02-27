import java.util.Scanner;

public class InputView {

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        return input;
    }

    public boolean doNextGame() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ("1".equals(input)) {
            return true;
        }
        return false;
    }
}
