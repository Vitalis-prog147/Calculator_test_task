public class TestCalculator {
    static String operandPlus = " + ";
    static String operandMinus = " - ";
    static String operandMultiply = " * ";
    static String operandDivide = " / ";

    public static Void ExpressionArabicNumbers(int finalNumberCycle, String operand) throws ScannerException {
        for (int i = 1; i < finalNumberCycle; i++) {
            for (int j = 1; j < finalNumberCycle; j++) {
                System.out.print("Выражение: " + i + operand + j+"\t");
                String input = i + operand + j;
                System.out.println(Main.calc(input));
            }
        }
        return null;
    }

    public static Void ExpressionRomesNumbers(int finalNumberCycle, String operand) throws ScannerException {
        for (int i = 1; i < finalNumberCycle; i++) {
            for (int j = 1; j < finalNumberCycle; j++) {
                String input = RomanNumerals.RomanNumerals(i) + operand + RomanNumerals.RomanNumerals(j);
                String inputDecrypted = i + operand + j;
                System.out.print("Выражение: " + input +  " ( " + inputDecrypted + " ) " + "\t");
                if (Main.calculationBlock(i + operand + j )>0){
                    System.out.println(Main.calc(input)+  " ( " + RomanNumerals.arabicRecordConstructor(Main.calc(input)) + " ) ");
                }
                else {
                    System.out.println("менее 1");
                }
            }
        }
        return null;
    }

    public static Void TestArabicNumbers(int finalNumberCycle) throws ScannerException {
        ExpressionArabicNumbers(finalNumberCycle, operandPlus);
        ExpressionArabicNumbers(finalNumberCycle, operandMinus);
        ExpressionArabicNumbers(finalNumberCycle, operandMultiply);
        ExpressionArabicNumbers(finalNumberCycle, operandDivide);
        return null;
    }

    public static Void TestRomanNumbers(int finalNumberCycle) throws ScannerException {
        ExpressionRomesNumbers(finalNumberCycle, operandPlus);
        ExpressionRomesNumbers(finalNumberCycle, operandMinus);
        ExpressionRomesNumbers(finalNumberCycle, operandMultiply);
        ExpressionRomesNumbers(finalNumberCycle, operandDivide);
        return null;
    }

    public static Void TestNumbers(int finalNumberCycle) throws ScannerException {
        TestRomanNumbers(finalNumberCycle);
        TestArabicNumbers(finalNumberCycle);
        return null;
    }

}