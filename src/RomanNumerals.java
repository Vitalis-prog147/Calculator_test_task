import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class RomanNumerals {

    public static String RomanNumerals(int arabicNumber) throws ScannerException {

        if (arabicNumber < 1 || arabicNumber > 3999) {
            throw new ScannerException("В римской системе исчесления нет чисел меньше 1 или больше 3999" +
                    "/In the Roman system of calculus, there are no numbers less than 1 or greater than 3999");
        }

        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String result = "";

        for (Map.Entry<String, Integer> convertibleNumber : roman_numerals.entrySet()) {
            int matches = arabicNumber / convertibleNumber.getValue();
            result += romeRecordConstructor(convertibleNumber.getKey(), matches);
            arabicNumber = arabicNumber % convertibleNumber.getValue();
        }

        return result;
    }

    public static String romeRecordConstructor(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static Integer arabicRecordConstructor(String s) throws ScannerException {
        for (int i = 1; i < 4000; i++) {
            if (Objects.equals(s, RomanNumerals.RomanNumerals(i))) {
                return i;
            }
        }
        return null;
    }

}