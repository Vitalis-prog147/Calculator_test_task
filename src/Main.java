import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Введите первое число тип операции, которую вы хотите выполнить (+, -, *, /) и второе число - ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] position;
        RomanNumber[] romanNumbers = RomanNumber.values();
        int answer = 0;
        int i = 0;
        if (input.indexOf('+') > i) {
            position = input.split("[+]");
            boolean isRomanFirst = checkIsRoman(position[0], romanNumbers);
            boolean isRomanSecond = checkIsRoman(position[1], romanNumbers);
            if (isRomanFirst != isRomanSecond) {
                throw new IOException("Используются одновременно разные системы счисления");
            }
            if (isRomanFirst) {
                toArabicNumber(position, romanNumbers);
            }
            check(position);
            answer = Integer.parseInt(position[0]) + Integer.parseInt(position[1]);
            if (isRomanFirst) {
                if (answer <= 0) {
                    throw new IOException("в римской системе нет нуля и отрицательных чисел");
                }
                toRomanNumber(romanNumbers, answer);
            } else {
                System.out.println("Ответ арабскими- " + answer);
            }
        } else if (input.indexOf('-') > i) {
            position = input.split("[-]");
            boolean isRomanFirst = checkIsRoman(position[0], romanNumbers);
            boolean isRomanSecond = checkIsRoman(position[1], romanNumbers);
            if (isRomanFirst != isRomanSecond) {
                throw new IOException("Используются одновременно разные системы счисления");
            }
            if (isRomanFirst) {
                toArabicNumber(position, romanNumbers);
            }
            check(position);
            answer = Integer.parseInt(position[0]) - Integer.parseInt(position[1]);
            if (isRomanFirst) {
                if (answer <= 0) {
                    throw new IOException("в римской системе нет нуля и отрицательных чисел");
                }
                toRomanNumber(romanNumbers, answer);
            } else {
                System.out.println("Ответ арабскими- " + answer);
            }
        } else if (input.indexOf('*') > i) {
            position = input.split("[*]");
            boolean isRomanFirst = checkIsRoman(position[0], romanNumbers);
            boolean isRomanSecond = checkIsRoman(position[1], romanNumbers);
            if (isRomanFirst != isRomanSecond) {
                throw new IOException("Используются одновременно разные системы счисления");
            }
            if (isRomanFirst) {
                toArabicNumber(position, romanNumbers);
            }
            check(position);
            answer = Integer.parseInt(position[0]) * Integer.parseInt(position[1]);
            if (isRomanFirst) {
                if (answer <= 0) {
                    throw new IOException("в римской системе нет нуля и отрицательных чисел");
                }
                toRomanNumber(romanNumbers, answer);
            } else {
                System.out.println("Ответ арабскими- " + answer);
            }
        } else if (input.indexOf('/') > i) {
            position = input.split("[/]");
            boolean isRomanFirst = checkIsRoman(position[0], romanNumbers);
            boolean isRomanSecond = checkIsRoman(position[1], romanNumbers);
            if (isRomanFirst != isRomanSecond) {
                throw new IOException("Используются одновременно разные системы счисления");
            }
            if (isRomanFirst) {
                toArabicNumber(position, romanNumbers);
            }
            check(position);
            answer = Integer.parseInt(position[0]) / Integer.parseInt(position[1]);
            if (isRomanFirst) {
                if (answer <= 0) {
                    throw new IOException("в римской системе нет нуля и отрицательных чисел");
                }
                toRomanNumber(romanNumbers, answer);
            } else {
                System.out.println("Ответ арабскими- " + answer);
            }
        } else {
            throw new IOException("Строка не является математической операцией");
        }
    }

    private static boolean checkIsRoman(String position, RomanNumber[] romanNumbers) {
        boolean isRoman = false;
        for (RomanNumber number : romanNumbers) {
            if (position.equals(number.toString())) {
                isRoman = true;
                break;
            }
        }
        return isRoman;
    }

    private static void toRomanNumber(RomanNumber[] romanNumbers, int answer) {
        for (RomanNumber romanNumber : romanNumbers) {
            if (answer == romanNumber.getArabicNumber()) {
                System.out.println("Ответ римскими- " + romanNumber);
                break;
            }
        }
    }

    private static void toArabicNumber(String[] position, RomanNumber[] romanNumbers) {
        for (int j = 0; j < position.length; j++) {
            for (RomanNumber romanNumber : romanNumbers) {
                if (position[j].equals(romanNumber.toString())) {
                    position[j] = String.valueOf(romanNumber.getArabicNumber());
                    break;
                }
            }
        }
    }

    private static void checkNumberVariables(String[] position) throws IOException {
        if (position.length != 2) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда");
        }
    }

    private static void checkRangeNumbers(String[] position) throws Exception {
        for (String string : position) {
            if (Integer.parseInt(string) > 10) {
                throw new Exception("Калькулятор принимает на вход только числа от 1 до 10 включительно");
            }
        }
    }

    private static void check(String[] position) throws Exception {
        checkNumberVariables(position);
        checkRangeNumbers(position);
    }
}

