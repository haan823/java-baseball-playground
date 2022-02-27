import java.util.Scanner;

public class StringCalculator {

    private String[] values;
    private long result = 0L;

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    void calc() {
        if (checkOperand(values[0])) {
            result = Integer.parseInt(values[0]);
        }
        for (int i = 1; i < values.length - 1; i += 2) {
            if (!checkOperator(values[i]) || !checkOperand(values[i + 1])) {
                throw new IllegalStateException("올바른 연산식이 아닙니다.");
            }
            String operation = values[i];
            long operand = Integer.parseInt(values[i + 1]);
            if ("+".equals(operation)) {
                result = add(operand);
            } else if ("-".equals(operation)) {
                result = sub(operand);
            } else if ("*".equals(operation)) {
                result = mul(operand);
            } else if ("/".equals(operation)) {
                result = div(operand);
            }
        }
    }

    boolean checkOperand(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    boolean checkOperator(String value) {
        if ("+".equals(value) || "-".equals(value) || "*".equals(value) || "/".equals(value)) {
            return true;
        }
        return false;
    }

    long add(long number) {
        return result + number;
    }

    long sub(long number) {
        return result - number;
    }

    long mul(long number) {
        return result * number;
    }

    long div(long number) {
        if (number == 0) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
        return result / number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator();

        String value = scanner.nextLine();
        stringCalculator.setValues(value.split(" "));

        stringCalculator.calc();
        System.out.println(stringCalculator.result);

    }
}
