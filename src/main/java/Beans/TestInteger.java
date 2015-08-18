/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Ashique
 */
import java.math.*;

public class TestInteger {
    public static void main(String args[]) {
        String number1 = "5";
        String minus = "-";
        String number2 = "3";
        number1 = minus + number1;
        System.out.println(Integer.parseInt(number1) * Integer.parseInt(number2));
    }
}
