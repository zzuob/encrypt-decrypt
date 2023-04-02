package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 1) {
            Flag.cli(args);
        } else Flag.interactive();
        String shifted = Shift.shiftString(Flag.data, Flag.key);
        if (Flag.fileOutput) {
            try (FileWriter writer = new FileWriter(Flag.filePath)) {
                writer.write(shifted);
            } catch (IOException e) {
                System.out.printf("Error: An exception occurred while writing to \"%s\"", Flag.filePath);
            }
        }
        else System.out.println(shifted);
    }
}
