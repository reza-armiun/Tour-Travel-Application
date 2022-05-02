package razarm.tosan.controller.commandline;

import java.util.Scanner;

public class SimpleScanner {

    private static final Scanner scanner = new Scanner(System.in);

    private SimpleScanner() {}


    public static Scanner getScanner() {
        return scanner;
    }


}
