package TaskLineCalculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LineCalculator {

    public static char operator;
    public static int numeral;
    public static String strFirst;
    public static String strSecond;
    public static String strSubstring;

    public static void setOperator() {
        char[] chars = strSubstring.toCharArray();
        ArrayList<Character> temp = new ArrayList<>();
        for (char ch : chars) {
            if (ch == '/' || ch == '*' || ch == '-' || ch == '+') {
                temp.add(ch);
            }
        }
        if (temp.size() == 1) {
            operator = temp.get(0);
        } else {
            System.out.println("Формат операции не удовлетворяет заданию");
            throw new IllegalArgumentException();
        }
    }

    public static void setNumeral(String string) {
        int i = string.indexOf(operator);
        String temp = string.substring(i + 1).trim();
        int tmp = Integer.parseInt(temp);
        if (tmp > 0 && tmp < 11) {
            numeral = tmp;
        } else {
            System.out.println("Формат операции не удовлетворяет заданию");
            throw new IllegalArgumentException();
        }
    }

    public static String setString(String string) {
        if (string.length() < 11) {
            return string;
        } else {
            System.out.println("Формат операции не удовлетворяет заданию");
            throw new IllegalArgumentException();
        }
    }

    public static void setValues(String string) {
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(string, "\"");
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        if (tokens.size() == 2) {
            strFirst = setString(tokens.get(0));
            strSubstring = tokens.get(1);
            setOperator();
            setNumeral(strSubstring);
        } else if (tokens.size() == 3) {
            strFirst = setString(tokens.get(0));
            strSubstring = tokens.get(1);
            setOperator();
            strSecond = setString(tokens.get(2));
        } else {
            System.out.println("Формат операции не удовлетворяет заданию");
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите арифметическую операцию: сложения строк, вычитания строки из строки, умножения строки на число\n" +
                "или деления строки на число, значения строк выделяются двойными кавычками,\n" +
                "например: \"a\" + \"b\", \"a\" - \"b\", \"a\" * b, \"a\" / b");
        Scanner scanner = new Scanner(System.in);

        setValues(scanner.nextLine());
        Calculator.print(Calculator.calculate());
    }
}




