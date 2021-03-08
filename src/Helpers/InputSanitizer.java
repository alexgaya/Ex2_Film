/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author m
 */
public class InputSanitizer {

    public static String sanitizeString(String s) {
        s = s.trim();
        return s;
    }
    
    public static int sanitizeNumber(String n) throws NumberFormatException {
        n = sanitizeString(n);
        int num = Integer.parseInt(n);
        return num;
    }
}
