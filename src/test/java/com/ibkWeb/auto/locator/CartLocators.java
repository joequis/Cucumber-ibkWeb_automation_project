package com.ibkWeb.auto.locator;


import org.openqa.selenium.By;

public class CartLocators {

    // Método dinámico que recibe el nombre del producto y genera el xpath
    public static By getCmpProductName(String nameProduct) {
        return By.xpath("//div[contains(text(),'" + nameProduct + "')]");
    }



}
