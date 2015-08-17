/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Ashique
 */
@ManagedBean(name="testBean")
public class GetterSetter {
    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public void clickEqu() {
        text = "equals clicked";
    }
}
