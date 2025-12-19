package com.ibkWeb.auto.pages;
import com.ibkWeb.auto.locator.LoginLocators;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //anotacion de Serenity
    @Step("Ingresar credenciales: usuario {0}")
    public void login(String user, String pass) {
        click(LoginLocators.getbtnIniciarSesion());
        escribir_Texto(LoginLocators.getCmpEmail(), user);
        escribir_Texto(LoginLocators.getCmpPasswrd(), pass);
        click(LoginLocators.getBtnLogin());
    }


    @Step("Validar mensaje de bienvenida esperado: {0}")
    public void validarMensajeBienvenida(String nombre) {
        String esperado = "Hola, " + nombre;
        String actual = waitForNonEmptyText(By.xpath("//div[contains(@class,'welcome-message')]"));
        if (!actual.equals(esperado)) {
            throw new AssertionError("Esperado: '" + esperado + "' | Actual: '" + actual + "'");
        }
    }





}


