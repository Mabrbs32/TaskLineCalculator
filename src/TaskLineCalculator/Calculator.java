package TaskLineCalculator;

public class Calculator {

    public static void print(String string) {
        if (string.length() < 41) {
            System.out.println("Результат: " + "\"" + string + "\"");
        } else {
            System.out.println("Результат: " + "\"" + string.substring(0, 40) + "..." + "\"");
        }
    }

    public static String toAdd(String stringOne, String stringTwo) {
        return stringOne + stringTwo;
    }

    public static String toMultiply(String string, int num) {
        return string.repeat(num);
    }

    public static String toDivide(String string, int num) {
        return string.substring(0, string.length() / num);
    }

    public static String toSubtract(String stringOne, String stringTwo) {
        int index = stringOne.indexOf(stringTwo);
        String[] array = stringOne.split(stringTwo);
        StringBuilder builder = new StringBuilder();

        if (index < 0) {
            return stringOne;
        } else {
            for (String str : array) {
                builder.append(str);
            }
            return builder.toString();
        }
    }

    public static String calculate() {
        if (LineCalculator.operator == '+' && LineCalculator.strSecond != null) {
            return toAdd(LineCalculator.strFirst, LineCalculator.strSecond);
        } else if (LineCalculator.operator == '-' && LineCalculator.strSecond != null) {
            return toSubtract(LineCalculator.strFirst, LineCalculator.strSecond);
        } else if (LineCalculator.operator == '/' && LineCalculator.numeral != 0) {
            return toDivide(LineCalculator.strFirst, LineCalculator.numeral);
        } else if (LineCalculator.operator == '*' && LineCalculator.numeral != 0) {
            return toMultiply(LineCalculator.strFirst, LineCalculator.numeral);
        } else {
            System.out.println("Формат операции не удовлетворяет заданию");
            throw new IllegalArgumentException();
        }
    }
}

