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
    private  static double number1;
    private  static double number2;
    private static double result=0;
    private static int counter = 0;
    
    private static boolean plusClicked = false, minusClicked = false, mulClicked = false, divClicked = false;
    private String text="0.0";
    private String msg="";
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    /**
     * 
     * @throws java.lang.Exception
    */
    public void minusIssue() throws Exception {
        if(minusClicked) text = "-"+text;
    }
    
    public static boolean clearScreen() {
        if(counter==1)
            return true;
        else
            return false;
    }
    
    //Button number click events
    /*===========================*/
    
    public void clickedZero() throws Exception {
       text = text + "0";
       msg = msg + "0";
    }
    
    public void clickedOne() throws Exception {
       text = text + "1";
       msg = msg + "1";  
    }
    
    public void clickedTwo() throws Exception {
       text = text + "2";
       msg = msg + "2";
    }
    
    public void clickedThree() throws Exception {
       text = text + "3";
       msg = msg + "3";
    }
    
    public void clickedFour() throws Exception {
       text = text + "4";
       msg = msg + "4";
    }
    
    public void clickedFive() throws Exception {
       text = text + "5";
       msg = msg + "5";
    }
      
    public void clickedSix() throws Exception {
       text = text + "6";
       msg = msg + "6";
    }
       
    public void clickedSeven() throws Exception {
       text = text + "7";
       msg = msg + "7";
    }
        
    public void clickedEight() throws Exception {
       text = text + "8";
       msg = msg + "8";
    }
         
    public void clickedNine() throws Exception {
       text = text + "9";
       msg = msg + "9";
    }
    
    public void clickedPoint() throws Exception {
        if(!text.contains(".")) {
             text = text + ".";
             msg = msg + ".";
        }else 
            msg = msg + "Point cannot be inserted twice in a number\n";
    }
    
    //Operation Buttons
    /*==================*/
    
    public void clickedPlus() throws Exception {
        msg = msg + " + ";
        if(clearScreen() && minusClicked==true)
            number1 = -Double.parseDouble(text);
        else
            number1 = Double.parseDouble(text);
        
        text = "";
        counter++;
        plusClicked = true;
        minusClicked = mulClicked = divClicked = false;
    }
    
    //some issues have here
    public void clickedMinus() throws Exception {
        msg = msg + " - ";
        if(clearScreen() && minusClicked==true)
            number1 = -Double.parseDouble(text);
        else
            number1 = Double.parseDouble(text);
        
        text = "";
        counter++;
        minusClicked = true;
        plusClicked = mulClicked = divClicked = false;
    }
    
    public void clickedMul() throws Exception {
        msg = msg + " * ";
        if(clearScreen() && minusClicked==true)
            number1 = -Double.parseDouble(text);
        else
            number1 = Double.parseDouble(text);
        
        text = "";
        counter++;
        mulClicked = true;
        minusClicked = plusClicked = divClicked = false;
    }
    
    public void clickedDiv() throws Exception {
        msg = msg + " / ";
        if(clearScreen() && minusClicked==true)
            number1 = -Double.parseDouble(text);
        else
            number1 = Double.parseDouble(text);
        
        text = "";
        counter++;
        divClicked = true;
        minusClicked = mulClicked = plusClicked = false;
    }
    
    public void plusMinus() {
        
    }
    
    public void screenClear() throws Exception {
        msg = "";
        text = "0";
        result = 0;
        plusClicked = minusClicked = mulClicked = divClicked = false;
        counter = 0;
    }
    
    public void clickEquals() throws Exception {
        number2 = Double.parseDouble(text);
        if(plusClicked){
            result = (number1 + number2);
            text = Double.toString(result);
            msg = msg + "; output is: "+text+"\n";
            counter=0;
            
        } else if(minusClicked){
            result = (number1 - number2);
            text = Double.toString(result);
            msg = msg + "; output is: "+text+"\n";
            counter = 0;
        }else if(mulClicked){
            result = (number1 * number2);
            text = Double.toString(result);
            msg = msg + "; output is: "+text+"\n";
            counter = 0;
        }else if(divClicked){
            result = (number1 / number2);
            text = Double.toString(result);
            msg = msg + "; output is: "+text+"\n";
            counter = 0;
        }else
            msg = msg + "\nOperation Invalid. Please try again.\n";
    }    
}
