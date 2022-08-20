import java.util.Scanner;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws ScannerException {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Доброго дня.\n" +
                        "Данная программа предназначена работы с арабскими и римскими цифрами от 1 до 10 включительно, соответственно только с целыми числами.\n" +
                        "Программа предназначена для арифметических действий (сложение, вычитание, деление, умножения) только с двумя аргументами одинакового вида.\n" +
                        "Операнды и операторы необходимо отделить пробелами."
        );
        //TestCalculator.TestNumbers(11);
        System.out.print(
                "Ожидаю ввода выражения: ");
        String calculationExpressionInput = in.nextLine(); // Ввод выражения вычисления (Entering a calculation expression)
        System.out.println(calc(calculationExpressionInput));

        in.close();
    }

    public static String calc (String input) throws ScannerException {
        String[] expression = input.split(" "); // Разбитие строки на массивы (Splitting a string into arrays)
        int lengthExpression = expression.length; // Определение длины массива (Determining the length of an array)
        int lengthArray = 3; // Переменная отвечающая за логику отсеивания, условие : выражение состоит из двух переменных и одного операнда
        // (The variable responsible for the filtering logic, condition : the expression consists of two variables and one operand)

        if (lengthExpression < lengthArray) {
            throw new ScannerException(
                    "throws Exception //т.к. строка не является математической операцией");
        }

        if (lengthExpression > lengthArray) {
            throw new ScannerException("" +
                    "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if (checkingRomanNumbers(expression[0]) && checkingRomanNumbers(expression[2])) {
            input = RomanNumerals.arabicRecordConstructor(expression[0])+" "+expression[1]+" "+RomanNumerals.arabicRecordConstructor(expression[2]);
            return RomanNumerals.RomanNumerals(calculationBlock(input));
        }

        else if (checkingArabicNumbers(expression[0]) && checkingArabicNumbers(expression[2])){
            return String.valueOf(calculationBlock(input));
        }

        else { // Блок вычислений №3, прочие числа или одновременные операции с римскими и арабскими цифрами
            // (Calculation block No. 3, other numbers or simultaneous operations with Roman and Arabic numerals)
            throw new ScannerException(
                    "throws Exception //т.к. \n" +
                            "Вариант № 1: используются одновременно разные системы счисления.\n" +
                            "Вариант № 2: в выражении один из операндов или оба не является арабскими или римскими числами.\n" +
                            "Вариант № 3: в выражении используются дробные числа.");
        }

    }

    public static Integer calculationBlock (String input) throws ScannerException {
        String[] expression = input.split(" ");
        System.out.print("Результат вычисления: ");
        switch (expression[1]) {
            case "+":
                return Integer.valueOf(expression[0]) + Integer.valueOf(expression[2]);
            case "-":
                return Integer.valueOf(expression[0]) - Integer.valueOf(expression[2]);
            case "*":
                return Integer.valueOf(expression[0]) * Integer.valueOf(expression[2]);
            case "/":
                double a = Double.valueOf(expression[0]) / Double.valueOf(expression[2]);
                return Integer.valueOf((int) a);
            default:
                throw new ScannerException(
                        "throws Exception //т.к. формат математической операции не удовлетворяет заданию - " +
                                "использованы операторы помимо (+, -, /, *)");
        }

    }

    public static Boolean checkingArabicNumbers (String input) throws ScannerException {
        String[] referenceNumbers = new String[12]; // Создания массива арабских чисел для сравнения (Creating an array of Arabic numbers for comparison)

        for (int i = 0; i < referenceNumbers.length; i++) { // Заполнение массива числами для сравнения (Filling an array with numbers for comparison)
            referenceNumbers[i] = String.valueOf(i);
        }

        for (int i = 0; i < referenceNumbers.length; i++) { // Проверка принадлежности операнда к арабским числам
            // (Checking whether the operand belongs to Arabic numbers)

            if (Objects.equals(input, referenceNumbers[i])) {

                if (Integer.valueOf (input) > 10){//Проверка операндов на < 11 (Checking operands for < 11)
                    throw new ScannerException(
                            "throws Exception //т.к. введеные числа арументов больше 10");
                }

                return true;
            }
        }

        return false;
    }

    public static Boolean checkingRomanNumbers (String input) throws ScannerException {

        for (int i = 1; i < 4000; i++) { // Проверка принадлежности операнда к римским числам
            // (Checking whether the operand belongs to Roman numbers)

            if (Objects.equals(input, RomanNumerals.RomanNumerals(i))) {

                if (RomanNumerals.arabicRecordConstructor(RomanNumerals.RomanNumerals(i))> 10) {//проверка операндов на < XI (Checking operands on < XI)
                    throw new ScannerException(
                            "throws Exception //т.к. введеные числа арументов больше X");
                }

                return true;
            }

        }

        return false;
    }

}


