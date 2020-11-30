/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

public class Number {
    
    public static boolean isInteger(Object obj) {
        try {
            Integer.parseInt(obj.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isDouble(Object obj) {
        try {
            Double.parseDouble(obj.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
}
