public enum RomanNumerals {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XI(11),
    XII(12);

    public static int length;
    private String translation;
    RomanNumerals (Integer translation){
        this.translation = String.valueOf(translation);
    }

    public String getTranslation() {
        return translation;
    }




}
