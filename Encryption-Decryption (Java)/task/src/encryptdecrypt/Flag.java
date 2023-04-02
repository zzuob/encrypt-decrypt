package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Flag {
    static String mode = ""; // "enc" or "dec"
    static int key;
    static String data; // text to shift
    static boolean fileOutput = false;
    static String filePath = "";

    public static boolean isDecrypt() {
        return mode.equals("dec");
    }

    private static String getDataFromFile(String path) {
        String result = "";
        try {
            result = new String(Files.readAllBytes(Path.of(path)));
        } catch (IOException e) {
            System.out.println("Error: Cannot read file at " + path);
            System.exit(-1);
        }
        return result;
    }

    public static void interactive() {
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter \"enc\" for encryption or \"dec\" for decryption");
            mode = scan.nextLine();
        } while(!(mode.equals("enc") || mode.equals("dec")));
        System.out.println("Enter message to encrypt/decrypt:");
        data = scan.nextLine();
        boolean notSet = true;
        do {
            System.out.println("Enter shift value:");
            try {
                key = Integer.parseInt(scan.nextLine());
                notSet = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer");
            }
        } while(notSet); // loop until user inputs positive integer
        if (isDecrypt()) key = -key; // decryption reverses the shift direction
    }

    public static void cli(String[] args){
        boolean fromFile = false;
        for (String flag: args
             ) {
            if (flag.equals("-in")) {
                fromFile = true;
                break;
            }
        }
        for (int i = 0; i < args.length; i++) {
            try {
                switch (args[i]) {
                    case "-mode" -> mode = args[i + 1];
                    case "-key" -> key = Integer.parseInt(args[i + 1]);
                    case "-data" -> data = fromFile ? data : args[i + 1];
                    case "-in" -> data = getDataFromFile(args[i + 1]);
                    case "-out" -> {fileOutput = true; filePath = args[i + 1];}
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: -key must be an integer - "+e.getMessage());
                System.exit(-1);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: missing argument value for "+args[i]);
                System.exit(-1);
            }
        }
        if (isDecrypt()) key = -key;
    }
}
