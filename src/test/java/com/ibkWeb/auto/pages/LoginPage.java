package com.ibkWeb.auto.pages;
import com.ibkWeb.auto.locator.LoginLocators;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //anotacion de Serenity
    @Step("Ingresar credenciales: usuario {0}, contraseña {1}")
    public void login(String user, String pass) {
        escribir_Texto(LoginLocators.getcmpUsername(), user);
        escribir_Texto(LoginLocators.getCmpPasswrd(), pass);
        click(LoginLocators.getBtnLogin());
    }


    @Step("Validar mensaje de bienvenida esperado")
    public void validarMensajeBienvenida() {
        WebElement welcomeMsg = this.waitForVisible(LoginLocators.getWelcomeMsg());
        if (welcomeMsg == null) {
            throw new AssertionError("El mensaje de bienvenida no se encontró en la página.");
        }
    }

}








