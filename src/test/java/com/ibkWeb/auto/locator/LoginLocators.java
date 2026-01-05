package com.ibkWeb.auto.locator;


import org.openqa.selenium.By;

public class LoginLocators {

    // Locators como By directamente

    private static final By cmpUsername = By.xpath("//*[@id='user-name']");
    private static final By cmpPasswrd = By.xpath("//*[@id='password']");
    private static final By btnLogin = By.xpath("//*[@id='vuejs']/div/div/div[1]/div/div/div/div[1]/form/button"); ;
    private static final By welcomeMsg = By.xpath("//span[contains(@class,'title') and contains(@data-test,'title')]");


    public static By getcmpUsername() {
        return cmpUsername;
    }

    public static By getCmpPasswrd() {
        return cmpPasswrd;
    }

    public static By getBtnLogin() {
        return btnLogin;
    }

    public static By getWelcomeMsg() {
        return welcomeMsg;
    }
}
