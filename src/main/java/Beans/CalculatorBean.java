/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
    
    private String color ;
    private boolean error = false;
    
    private static boolean plusClicked = false, minusClicked = false, mulClicked = false, divClicked = false;
    private String text="PLEASE TURN ON THE CALCULATOR.";
    private String msg="ACTIVATE THE CALCULATOR PLEASE...";
    
    /**
     * Switch for turn on/off the calculator.
    */
    
    private static boolean buttonState = false;
    public void onOff() {
        if(buttonState==false) {
            buttonState = true;
            text = "0";
            msg = "";
        }else {
            buttonState = false;
            msg = "ACTIVATE THE CALCULATOR PLEASE...";
            text = "PLEASE TURN ON THE CALCULATOR.";
        }
    }
    
    
    /**
     * Background Color
     * fontColor
     */
    private String backgroundColor = "";
    private String fontColor = "";
    
    public String getBackgroundColor() {
        if(buttonState==false)
            return "black";
        else
            return "white";
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getFontColor() {
        if(buttonState==false)
            return "#33D422";
        else
            return "#333300";
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }
    
    
    
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
     * Disabled at this moment
     * @return = color of the error
     */
    
    public String getColor() {
        if(error == true)
            return "red";
        else
            return "black";
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    /**
     * checking whether the screen is clear or not
     * @return = state of the screen
     */
  
    public static boolean clearScreen() {
        if(counter==1)
            return true;
        else
            return false;
    }
    
    //Button number click events
    /*===========================*/
    
    public void clickedZero() throws Exception {
        if(buttonState){
            text = text + "0";
            msg = msg + "0";
        }
    }
    
    public void clickedOne() throws Exception {
        if(buttonState) {
            text = text + "1";
            msg = msg + "1";
        }  
    }
    
    public void clickedTwo() throws Exception {
        if(buttonState) {
            text = text + "2";
            msg = msg + "2";
        }
    }
    
    public void clickedThree() throws Exception {
        if(buttonState) {
            text = text + "3";
            msg = msg + "3";
        }
    }
    
    public void clickedFour() throws Exception {
       if(buttonState) {
           text = text + "4";
           msg = msg + "4";
       }
    }
    
    public void clickedFive() throws Exception {
       if(buttonState) {
           text = text + "5";
           msg = msg + "5";
       }
    }
      
    public void clickedSix() throws Exception {
       if(buttonState) {
           text = text + "6";
           msg = msg + "6";
       }
    }
       
    public void clickedSeven() throws Exception {
       if(buttonState) {
            text = text + "7";
            msg = msg + "7";
       }
    }
        
    public void clickedEight() throws Exception {
       if(buttonState) {
           text = text + "8";
           msg = msg + "8";
       }
    }
         
    public void clickedNine() throws Exception {
       if(buttonState) {
           text = text + "9";
           msg = msg + "9";
       }
    }
    
    public void clickedPoint() throws Exception {
        if(buttonState) {
            if(!text.contains(".")) {
             text = text + ".";
             msg = msg + ".";
        }else {
            error = true;
            msg = msg + "; Point cannot be inserted twice in a number\n";
            }
        }
    }
    
    //Scientific Buttons
    /*==================*/
    
    public void clickedSine() throws Exception{
       if(buttonState) {
           double sine = Math.sin(Math.toRadians(Double.parseDouble(text)));
           text = Double.toString(sine);
           msg = msg + "; sine value is: "+text;
       }  
    }
    public void clickedCosine() throws Exception{
        if(buttonState) {
           double cos = Math.cos(Math.toRadians(Double.parseDouble(text)));
           text = Double.toString(cos);
           msg = msg + "; cosine value is: "+text;
       } 
    }
    public void clickedTangent() throws Exception{
        if(buttonState) {
           double tan = Math.tan(Math.toRadians(Double.parseDouble(text)));
           text = Double.toString(tan);
           msg = msg + "; tan value is: "+text;
       } 
    }
    public void clickedPi() throws Exception{
        if(buttonState) {
           text = Double.toString(Math.PI);
           msg = msg + "; pi value is: "+text;
       } 
    }
    
    public void clickedLog() throws Exception{
        if(buttonState) {
           //text = Double.toString(Math.log(Double.parseDouble(text)));
           //msg = msg + "; pi value is: "+text;
       } 
    }
    
    //Operation Buttons
    /*==================*/
    
    public void backClicked() throws Exception {
        if(buttonState) {
            text = text.substring(0, text.length()-1);
            msg = msg+ "; the number has been edited to: "+text+"\n";
        }
    }
    
    public void clickedPlus() throws Exception {
        if(buttonState) {
            msg = msg + " + ";
        if(clearScreen() && minusClicked==true)
            number1 = -Double.parseDouble(text);
        else
            number1 = Double.parseDouble(text);
        
        text = "";
        counter++;
        plusClicked = true;
        minusClicked = mulClicked = divClicked = false;
        } //buttonState
    }
    
    
    public void clickedMinus() throws Exception {
        if(buttonState) {
                msg = msg + " - ";
        if(clearScreen() && minusClicked==true)
            number1 = -Double.parseDouble(text);
        else
            number1 = Double.parseDouble(text);
        
        text = "";
        counter++;
        minusClicked = true;
        plusClicked = mulClicked = divClicked = false;
        } //buttonState
    }
    
    public void clickedMul() throws Exception {
        if(buttonState) {
            msg = msg + " * ";
            if(clearScreen() && minusClicked==true)
                number1 = -Double.parseDouble(text);
            else
                number1 = Double.parseDouble(text);
        
        text = "";
        counter++;
        mulClicked = true;
        minusClicked = plusClicked = divClicked = false;
        } // buttonState
    }
    
    public void clickedDiv() throws Exception {
        if(buttonState) {
            msg = msg + " / ";
        if(clearScreen() && minusClicked==true)
            number1 = -Double.parseDouble(text);
        else
            number1 = Double.parseDouble(text);
        
        text = "";
        counter++;
        divClicked = true;
        minusClicked = mulClicked = plusClicked = false;
        } //buttonState   
    }
    
    public void plusMinus() throws Exception {
        if(buttonState) {
            text = Double.toString(Double.parseDouble(text)*(-1));
            msg = msg + "; The number has been transformed to: "+text+"\n";
        }
    }
    
    public void sqrt() throws Exception {
        if(buttonState) {
        if(Double.parseDouble(text)<0) {
            error = true;
            msg = msg + "; negative number is not allowed here.\n";
        }else {
            text = Double.toString(Math.sqrt(Double.parseDouble(text)));
            msg = msg + "; The square root is: "+text+"\n";
        }
        } //buttonState
    }
    
    public void screenClear() throws Exception {
        if(buttonState) {
            msg = "";
            text = "0";
            result = 0;
            plusClicked = minusClicked = mulClicked = divClicked = false;
            counter = 0;
            buttonState = true;
        } //buttonState
    }
    
    public void clickEquals() throws Exception {
        if(buttonState) {
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
        }else {
            error = true;
            msg = msg + "\nOperation Invalid. Please try again.\n";
        }
        } //buttonState
    } //equals
    
    public void trigonoCalc() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().redirect("Trigonometry.xhtml");
    }
    
    public static void main(String args[]) throws Exception {
        new CalculatorBean().backClicked();
    }
}
