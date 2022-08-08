import java.util.Arrays;
import java.util.Scanner;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws ScanerException {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Доброго дня.\n" +
                        "Данная программа предназначена работы с арабскими и римскими цифрами от 1 до 10 включительно, соответственно только с целыми числами.\n" +
                        "Программа предназначена для арифметических действий (сложение, вычитание, деление, умножения) только с двумя аргументами одинакового вида.\n" +
                        "Операнды и операторы необходимо отделить пробелами."
        );
        System.out.print("Ожидаю ввода выражения: ");
        String calculationExpression = in.nextLine(); // Ввод выражения вычесления
        String[] expression = calculationExpression.split(" ");

        int lengthExpression = expression.length; // определение длины массива
        //System.out.println (lengthExpression);
        int lehgthArray = 3;

        if (lengthExpression < lehgthArray) {
            throw new ScanerException("throws Exception //т.к. строка не является математической операцией");
        }
        if (lengthExpression > lehgthArray) {
            throw new ScanerException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String[] referenceNumbers = new String[12]; // создания массива арабских чисел для сравнения

        for (int i = 0; i < referenceNumbers.length; i++) { //заполнение массива числами для сравнения
            referenceNumbers[i] = String.valueOf(i);
        }
        RomanNumerals[] Rome = RomanNumerals.values(); // создания массива с данными Enam, для сравнения
        //System.out.println(Arrays.toString(Rome));




        boolean arg1 = false; // для проверки типа цифр
        boolean arg2 = false;

        for (int i=0; i < referenceNumbers.length; i++){ //проверка принадежности первого операнда к арабским числам

            if (Objects.equals(expression [0], referenceNumbers [i])){
                //System.out.println("Первый операнд арабское число");
                arg1 = true;
                break;
            }
        }
        for (int i=0; i < referenceNumbers.length; i++){//проверка принадежности второго операнда к арабским числам

            if (Objects.equals(expression [2], referenceNumbers [i])){
                arg2 = true;
                break;
            }
            else {

            }
        }


            if (arg1 == arg2 && arg1 == true) { // вычисление арабских чисел

                for (int j=0; j < referenceNumbers.length; j++){ //проверка операндов на < 11
                    if (Integer.valueOf(expression[0]) > 10 || Integer.valueOf(expression[2]) > 10){
                        throw new ScanerException("throws Exception //т.к. введеные числа арументов больше 10");
                    }
                }

                //System.out.println("Операнды являются арабскими числами");

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
                        throw new ScanerException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - использованы операторы помимо (+, -, /, *)");
                }
            }
            else if (arg1 == arg2 && arg1 == false) { // вычисление римских чисел

                for (int i=0; i < referenceNumbers.length; i++){ //проверка операндов на < XI
                    if (Objects.equals(expression[0], Rome[i].name())) {
                        int a = Integer.parseInt(Rome[i].getTranslation());
                        if (a > 10){
                            throw new ScanerException("throws Exception //т.к. введеные числа арументов больше X");
                        }
                    }
                    if (Objects.equals(expression[2], Rome[i].name())) {
                        int a = Integer.parseInt(Rome[i].getTranslation());
                        if (a > 10){
                            throw new ScanerException("throws Exception //т.к. введеные числа арументов больше X");
                        }
                    }
                }

                //System.out.println("Операнды являются римскими числами");

                for (int i = 0; i < Rome.length; i++) { // Сравнение римских чисел и конвертация в арабские для Первого операнда
                    if (Objects.equals(expression[0], Rome[i].name())) {
                        expression[0] = Rome[i].getTranslation();
                        break;
                    }
                }
                for (int j = 0; j < Rome.length; j++) { // Сравнение римских чисел и конвертация в арабские для Второго операнда
                    if (Objects.equals(expression[2], Rome[j].name())) {
                        expression[2] = Rome[j].getTranslation();
                        break;
                    }
                }
                int result;
                switch (expression[1]) {
                    case "+":
                        System.out.print("Результат вычисления: ");
                        result = Integer.valueOf(expression[0]) + Integer.valueOf(expression[2]);
                        //System.out.println (result);
                        break;
                    case "-":
                        System.out.print("Результат вычисления: ");
                        result = Integer.valueOf(expression[0]) - Integer.valueOf(expression[2]);
                        //System.out.println (result);
                        break;
                    case "*":
                        System.out.print("Результат вычисления: ");
                        result = Integer.valueOf(expression[0]) * Integer.valueOf(expression[2]);
                        //System.out.println (result);
                        break;
                    case "/":
                        System.out.print("Результат вычисления: ");
                        result = Integer.valueOf(expression[0]) / Integer.valueOf(expression[2]);
                        //System.out.println (Integer.valueOf((int) result));
                        break;
                    default:
                        throw new ScanerException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - использованы операторы помимо (+, -, /, *)");
                }
                if (result <1){
                    throw new ScanerException("throws Exception //т.к. в римской системе нет отрицательных чисел, результат вычисления меньше 1");
                }
                //System.out.println(Integer.valueOf((int) result));

                for (int i=0; i < Rome.length; i++) { // Сравнение арабских чисел и конвертация результата расчета в римские
                    int n = Integer.parseInt(Rome[i].getTranslation());
                    if (Objects.equals(result, n)) {
                        System.out.println(Rome[i]);
                        break;
                    }
                }
            }
                else {
                throw new ScanerException("throws Exception //т.к. используются одновременно разные системы счисления");
            }

        // Калькулятор умеет работать только с целыми числами.
        // Необходима нормальная библиотека римских чисел.
            in.close();
        }
    }


