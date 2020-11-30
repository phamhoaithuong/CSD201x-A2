/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

public class Input {
    public static final Scanner INPUT = new Scanner(System.in);
    
    public static void pause() {
        System.out.print("Press enter to continue...");
        INPUT.nextLine();
    }
    
    public static String inputStr(String msg) {
        while (true) {
            System.out.print(msg);
            String input = INPUT.nextLine();
            if (input.isEmpty()) System.out.println("Could not be empty");
            else return input;
        }
    }
    
    public static int inputInt(String msg) {
        while (true) {
            String input = inputStr(msg);
            if (Number.isInteger(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.printf("%s is not a number, please input again!", input);
                System.out.println(msg);
            }
        }
    }
    
    public static double inputDouble(String msg) {
        while (true) {
            String input = inputStr(msg);
            if (Number.isDouble(input)) {
                return Double.parseDouble(input);
            } else {
                System.out.printf("%s is not a number, please input again!", input);
                System.out.print(msg);
            }
        }
    }    
}
