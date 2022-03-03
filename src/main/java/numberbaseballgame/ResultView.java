package numberbaseballgame;

public class ResultView {

    public static void output(PlayResult playResult) {
        StringBuffer sb = new StringBuffer();
        if (playResult.getBall() > 0) {
            sb.append(playResult.getBall()).append("볼 ");
        }
        if (playResult.getStrike() > 0) {
            sb.append(playResult.getStrike()).append("스트라이크");
        }

        System.out.println(sb.toString());
    }

}
