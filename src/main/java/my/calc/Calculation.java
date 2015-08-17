/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.calc;

import Algorithm.Operations;

/**
 *
 * @author Ashique
 */
public class Calculation implements Operations {
    private static Calculation cal;
    public Calculation() {}
    public static Calculation getInstance() {
        if(cal == null)
            cal = new Calculation();
        return cal;
    }
    
    @Override
    public double addition(double a, double b) throws Exception {
        return (a+b);
    }
    
    @Override
    public double subtraction(double a, double b) throws Exception {
        return (a-b);
    }
    
    @Override
    public double multiplication(double a, double b) throws Exception {
        return (a*b);
    }
    
    @Override
    public double division(double a, double b) throws Exception {
        return (a/b);
    }
}
