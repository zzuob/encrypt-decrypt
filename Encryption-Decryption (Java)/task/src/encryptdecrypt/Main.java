package encryptdecrypt;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 1) {
            Flag.cli(args);
        } else Flag.interactive();
        System.out.println(Shift.shiftString(Flag.data, Flag.key));
    }
}
