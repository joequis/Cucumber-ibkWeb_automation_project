package com.ibkWeb.auto.pages;
import com.ibkWeb.auto.locator.CartLocators;
import com.ibkWeb.auto.locator.DashboardLocators;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //anotacion de Serenity
    @Step("Verificar si el producto está en el carrito")
    public void verificarProducto(String prductName) {
        By locator = CartLocators.getCmpProductName(prductName);
        WebElement productElement = waitForVisible(locator);
        if (productElement == null) {
            throw new AssertionError("El producto '" + prductName + "' no se encontró en el carrito.");
        }

    }








}


