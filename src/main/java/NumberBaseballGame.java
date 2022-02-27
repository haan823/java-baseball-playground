import java.util.Random;
import java.util.Scanner;

public class NumberBaseballGame {

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    private String answer;
    private int[] count;


    boolean endGame(int strike) {
        if (strike == 3) {
            return true;
        }
        return false;
    }

    int countStrike(String answer, String input) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += countCharForStrike(answer.charAt(i), input.charAt(i));
        }
        return result;
    }

    int countCharForStrike(Character answer, Character input) {
        if (answer.equals(input)) {
            return 1;
        }
        return 0;
    }

    int countBall(String answer, String input) {
        int result = 0;
        int countStrike = countStrike(answer, input);
        for (int i = 0; i < 3; i++) {
            result += countCharForBall(input.charAt(i));
        }
        return result - countStrike;
    }

    int countCharForBall(Character input) {
        if(count[Character.getNumericValue(input)] > 0){
            count[Character.getNumericValue(input)]--;
            return 1;
        }
        return 0;
    }

    boolean play() {
        InputView iv = new InputView();
        ResultView rv = new ResultView();
        makeRandomNumber();
        System.out.println(answer);
        boolean gameOver = false;

        while (!gameOver) {
            init();
            String input = iv.getInput();
            int strike = countStrike(answer, input);
            int ball = countBall(answer, input);
            rv.print(ball, strike);
            gameOver = endGame(strike);
        }
        rv.gameOver();

        if (iv.doNextGame()) {
            return true;
        }
        return false;
    }

    void makeRandomNumber() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            sb.append(Integer.toString(random.nextInt(10)));
        }
        answer = sb.toString();
    }

    void init() {
        count = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 3; i++) {
            count[Character.getNumericValue(answer.charAt(i))]++;
        }
    }

    public static void main(String[] args) {
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        boolean doNextGame = true;

        while (doNextGame) {
            doNextGame = numberBaseballGame.play();
        }
    }

}
