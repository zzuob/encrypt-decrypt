package encryptdecrypt;

public class Shift {

    private static final int width = getStop() - getStart() + 1;;

    public static int getStart() { return ' '; }

    public static int getStop() {
        return '~';
    }

    public static int getWidth() {
        return width;
    }

    public static char shiftChar(char symbol, int shift){
        if (shift == 0) return symbol;
        int ascii = symbol;
        if (getStart() <= ascii && ascii <= getStop()) {
            ascii = (((ascii-getStart()) + shift) % getWidth()) + getStart();
        }
        return (char) ascii;
    }

    public static String shiftString(String text, int shift) {
        char[] symbols = text.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = shiftChar(symbols[i], shift);
        }
        return new String(symbols);
    }
}

