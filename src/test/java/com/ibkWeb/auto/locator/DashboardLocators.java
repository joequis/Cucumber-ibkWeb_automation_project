package com.ibkWeb.auto.locator;


import org.openqa.selenium.By;

public class DashboardLocators {


    private static final By cartLink = By.xpath("//*[@id='shopping_cart_container']/a");

    // Método dinámico recibe el nombre del producto
    public static By getBtnProductByName(String nameProduct) {
        return By.xpath("//div[contains(text(),'" + nameProduct + "')]");
    }

    public static By getCartLink() {
        return cartLink;
    }




}

