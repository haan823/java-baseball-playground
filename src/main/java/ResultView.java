public class ResultView {

    public void print(int ball, int strike) {
        StringBuffer sb = new StringBuffer();
        if (ball != 0) {
            sb.append(Integer.toString(ball)).append("볼 ");
        }
        if (strike != 0) {
            sb.append(Integer.toString(strike)).append("스트라이크");
        }
        System.out.println(sb.toString());
    }

    public void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
