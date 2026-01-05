package com.ibkWeb.auto.pages;
import com.ibkWeb.auto.locator.DashboardLocators;
import com.ibkWeb.auto.locator.LoginLocators;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    //anotacion de Serenity
    @Step("Agregar al carrito el producto {0}")
    public void seleccionarProducto(String prductName) {
        this.click(DashboardLocators.getBtnProductByName(prductName));

    }

    @Step("Ingresar al Carrito de Compras")
    public void ingresarAlCarrito() {
        this.click(DashboardLocators.getCartLink());
    }
}


