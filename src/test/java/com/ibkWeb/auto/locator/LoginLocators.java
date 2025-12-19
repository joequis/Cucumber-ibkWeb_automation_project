package com.ibkWeb.auto.locator;


import org.openqa.selenium.By;

public class LoginLocators {

    // Locators como By directamente
    private static final By btnIniciarSesion = By.xpath("//button[.//span[normalize-space()='Iniciar sesión con una contraseña']]");
    private static final By cmpEmail = By.cssSelector("div[data-test='login-identifier'] input[data-test='input']");
    private static final By cmpPasswrd = By.cssSelector("div[data-test='login-password'] input[data-test='input']");
    private static final By btnLogin = By.xpath("//*[@id='vuejs']/div/div/div[1]/div/div/div/div[1]/form/button"); ;
    private static final By welcomeMsg = By.xpath("//div[contains(@class,'welcome-message') and contains(text(),'Hola')]");

    public static By getbtnIniciarSesion() {
        return btnIniciarSesion;
    }
    public static By getCmpEmail() {
        return cmpEmail;
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
