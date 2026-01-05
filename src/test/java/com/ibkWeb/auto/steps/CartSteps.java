package com.ibkWeb.auto.steps;
import com.ibkWeb.auto.pages.CartPage;
import com.ibkWeb.auto.pages.DashboardPage;
import com.ibkWeb.auto.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CartSteps {

    private WebDriver driver;

    @Then("Verificar que el {product_name} se encuentra en el carrito")
    public void verificarProductoEnCarrito(String product_name) {
        CartPage cartPage = new CartPage(driver);
        cartPage.verificarProducto(product_name);
    }

}

