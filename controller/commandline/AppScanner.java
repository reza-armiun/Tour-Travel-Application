package razarm.tosan.controller.commandline;

import java.util.Scanner;

public class AppScanner {

    private static final Scanner scanner = new Scanner(System.in);

    private AppScanner() {}


    public static Scanner getScanner() {
        return scanner;
    }


}
