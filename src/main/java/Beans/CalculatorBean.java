/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import my.calc.Calculation;

/**
 *
 * @author Ashique
 */
@ManagedBean(name="calcBean")
@RequestScoped
public class CalculatorBean implements Serializable {
    private static double result = 0;
    private static int counter = 0;
    public static String operators = ""; // should not use static.... {issue}
    
    private String text="";

    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    

    //Button number click events
    /*===========================*/
    
    public void clickedZero() throws Exception {
       text = text + "0";
    }
    
    public void clickedOne() throws Exception {
       text = text + "1";
    }
    
    public void clickedTwo() throws Exception {
       text = text + "2";
    }
    
    public void clickedThree() throws Exception {
       text = text + "3";
    }
    
    public void clickedFour() throws Exception {
       text = text + "4";
    }
    
    public void clickedFive() throws Exception {
       text = text + "5";
    }
      
    public void clickedSix() throws Exception {
       text = text + "6";
    }
       
    public void clickedSeven() throws Exception {
       text = text + "7";
    }
        
    public void clickedEight() throws Exception {
       text = text + "8";
    }
         
    public void clickedNine() throws Exception {
       text = text + "9";
    }
    
    public void clickedPoint() throws Exception {
        if(!text.contains("."))
             text = text + ".";
    }
    
    //Operation Buttons
    /*==================*/
    
    public void clickedPlus() {
        counter++;
        if(counter==1)
            result = Double.parseDouble(text);
        else {
            result = result + Double.parseDouble(text);
        }
        text = "";
        operators = "+";
        
    }
    
    public void clickedMinus() {
        counter++;
        if(counter==1) {
            result = Double.parseDouble(text);
        }else {
            result = result -  Double.parseDouble(text);
        }
        text = "";
        operators = "-";
    }
    
    public void clickedMul() {
        counter++;
        if(counter==1)
            result= Double.parseDouble(text);
        else {
            result = result * Double.parseDouble(text);
        }
        text = "";
        operators = "*";
    }
    
    public void clickedDiv() {
        counter++;
        if(counter==1)
            result = Double.parseDouble(text);
        else{
            result = result / Double.parseDouble(text);
        }
        text = "";
        operators = "/";
    }
    
    public void plusMinus() {
        
    }
    
    public void screenClear() throws Exception {
        text = "0";
        result = 0;
        operators = "";
        counter = 0;
    }
    
    public void clickEquals() throws Exception {
        counter++;
        if(operators.equals("+")){
            text = Double.toString(Calculation.getInstance().addition(result, Double.parseDouble(text)));
            counter=0;
        }
        if(operators.equals("-")){
            text = Double.toString(Calculation.getInstance().subtraction(result, Double.parseDouble(text)));
            counter = 0;
        }
        if(operators.equals("*")){
            text = Double.toString(Calculation.getInstance().multiplication(result, Double.parseDouble(text)));
            counter = 0;
        }
        if(operators.equals("/")){
            text = Double.toString(Calculation.getInstance().division(result, Double.parseDouble(text)));
            counter = 0;
        } 
    }    
}
