import java.util.Scanner;
import java.util.Objects;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws ScanerException {
        Scanner in = new Scanner(System.in);
        System.out.println(
         "Доброго дня.\n" +
         "Данная программа предназначена работы с арабскими и римскими цифрами от 1 до 10 включительно, соответственно только с целыми числами.\n" +
         "Программа предназначена для арифметических действий (сложение, вычитание, деление, умножения) только с двумя аргументами одинакового вида.\n" +
         "Операнды и операторы необходимо отделить пробелами."
        );
        System.out.print(
                "Ожидаю ввода выражения: ");
        String calculationExpression = in.nextLine(); // Ввод выражения вычисления (Entering a calculation expression)
        String[] expression = calculationExpression.split(" "); // Разбитие строки на массивы (Splitting a string into arrays)

        int lengthExpression = expression.length; // Определение длины массива (Determining the length of an array)
        int lengthArray = 3; // Переменная отвечающая за логику отсеивания, условие : выражение состоит из двух переменных и одного операнда
                             // (The variable responsible for the filtering logic, condition : the expression consists of two variables and one operand)

        if (lengthExpression < lengthArray) {
            throw new ScanerException(
                    "throws Exception //т.к. строка не является математической операцией");
        }
        if (lengthExpression > lengthArray) {
            throw new ScanerException("" +
                    "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String[] referenceNumbers = new String[12]; // Создания массива арабских чисел для сравнения (Creating an array of Arabic numbers for comparison)

        for (int i = 0; i < referenceNumbers.length; i++) { // Заполнение массива числами для сравнения (Filling an array with numbers for comparison)
            referenceNumbers[i] = String.valueOf(i);
        }
        RomanNumerals[] Rome = RomanNumerals.values(); // Создания массива с данными Enam, для сравнения (Creating an array with Enam data, for comparison)

                                // Создание аргументов для проверки типа цифр (Creating arguments for checking the type of digits)
        boolean arg1 = false;   // Переменная для первого аргумента (Variable for the first argument)
        boolean arg2 = false;   // Переменная для второго аргумента (Variable for the second argument)

        for (int i=0; i < referenceNumbers.length; i++){ // Проверка принадлежности первого операнда к арабским числам
                                                         // (Checking whether the first operand belongs to Arabic numbers)
            if (Objects.equals(expression [0], referenceNumbers [i])){
                arg1 = true;
                break;
            }
        }
        for (int i=0; i < referenceNumbers.length; i++){ //Проверка принадежности второго операнда к арабским числам
                                                         //(Checking whether the second operand belongs to Arabic numbers)
            if (Objects.equals(expression [2], referenceNumbers [i])){
                arg2 = true;
                break;
            }
            else {
            }
        }
                                                // Блок вычислений (Calculation Block)
            if (arg1 == arg2 && arg1 == true) { // Блок вычислений №1, арабские числа (Calculation block No. 1, Arabic numerals)
                                                // Цикл вычисления арабских чисел (The cycle of calculating Arabic numbers)
                for (int j=0; j < referenceNumbers.length; j++){ //Проверка операндов на < 11 (Checking operands for < 11)
                    if (Integer.valueOf(expression[0]) > 10 || Integer.valueOf(expression[2]) > 10){
                        throw new ScanerException(
                                "throws Exception //т.к. введеные числа арументов больше 10");
                    }
                }
                switch (expression[1]) {
                    case "+":
                        System.out.print ("Результат вычисления: ");
                        System.out.println (Integer.valueOf(expression[0]) + Integer.valueOf(expression[2]));
                        break;
                    case "-":
                        System.out.print("Результат вычисления: ");
                        System.out.println (Integer.valueOf(expression[0]) - Integer.valueOf(expression[2]));
                        break;
                    case "*":
                        System.out.print("Результат вычисления: ");
                        System.out.println (Integer.valueOf(expression[0]) * Integer.valueOf(expression[2]));
                        break;
                    case "/":
                        System.out.print("Результат вычисления: ");
                        double a = Double.valueOf(expression[0]) / Double.valueOf(expression[2]);
                        System.out.println (Integer.valueOf((int) a));
                        break;
                    default:
                        throw new ScanerException(
                                 "throws Exception //т.к. формат математической операции не удовлетворяет заданию - " +
                                 "использованы операторы помимо (+, -, /, *)");
                }
            }
            else if (arg1 == arg2 && arg1 == false) { // Блок вычислений №2, римские числа (Calculation block No. 2, Roman numerals)
                                                      // Цикл вычисления римских чисел (The cycle of calculating Roman numbers)
                for (int i=0; i < referenceNumbers.length; i++){ //проверка операндов на < XI (Checking operands on < XI)
                    if (Objects.equals(expression[0], Rome[i].name())){
                        if (Integer.parseInt(Rome[i].getTranslation()) > 10){
                            throw new ScanerException(
                                    "throws Exception //т.к. введеные числа арументов больше X");
                        }
                    }
                }
                for (int i = 0; i < Rome.length; i++) { // Сравнение римских чисел и конвертация в арабские для Первого операнда
                                                        // (Comparison of Roman numbers and conversion to Arabic for the First operand)
                    if (Objects.equals(expression[0], Rome[i].name())) {
                        expression[0] = Rome[i].getTranslation();
                        break;
                    }
                }
                for (int j = 0; j < Rome.length; j++) { // Сравнение римских чисел и конвертация в арабские для Второго операнда
                                                        // (Comparison of Roman numbers and conversion to Arabic for the Second operand)
                    if (Objects.equals(expression[2], Rome[j].name())) {
                        expression[2] = Rome[j].getTranslation();
                        break;
                    }
                }
                int result; // Переменная для проверки условия на < 1
                            // (Variable for checking the condition for < 1)
                switch (expression[1]) {
                    case "+":
                        System.out.print("Результат вычисления: ");
                        result = Integer.valueOf(expression[0]) + Integer.valueOf(expression[2]);
                        break;
                    case "-":
                        System.out.print("Результат вычисления: ");
                        result = Integer.valueOf(expression[0]) - Integer.valueOf(expression[2]);
                        break;
                    case "*":
                        System.out.print("Результат вычисления: ");
                        result = Integer.valueOf(expression[0]) * Integer.valueOf(expression[2]);
                        break;
                    case "/":
                        System.out.print("Результат вычисления: ");
                        result = Integer.valueOf(expression[0]) / Integer.valueOf(expression[2]);
                        break;
                    default:
                        throw new ScanerException(
                                "throws Exception //т.к. формат математической операции не удовлетворяет заданию - " +
                                "использованы операторы помимо (+, -, /, *)");
                }
                if (result <1){ // Проверка условия на < 1 (Checking the condition for < 1)
                    throw new ScanerException(
                            "throws Exception //т.к. в римской системе нет отрицательных чисел, " +
                            "результат вычисления меньше 1");
                }
                for (int i=0; i < Rome.length; i++) { // Конвертация результата расчета в римские цифры
                                                      // (Conversion of the calculation result to Roman numerals)
                    if (Objects.equals(result, Integer.parseInt(Rome[i].getTranslation()))){
                        System.out.println(Rome[i]);
                        break;
                    }
                }
            }
                else { // Блок вычислений №3, прочие числа или одновременные операции с римскими и арабскими цифрами
                       // (Calculation block No. 3, other numbers or simultaneous operations with Roman and Arabic numerals)
                throw new ScanerException(
                        "throws Exception //т.к. \n" +
                                "Вариант № 1: используются одновременно разные системы счисления.\n" +
                                "Вариант № 2: в выражении один из операндов или оба не является арабскими или римскими числами.\n" +
                                "Вариант № 3: в выражении используются дробные числа.");
            }
        // Необходима нормальная библиотека римских чисел.
            in.close();
        }
    }


