package com.ibkWeb.auto.steps;
import com.ibkWeb.auto.pages.DashboardPage;
import com.ibkWeb.auto.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DashboardSteps {

    private WebDriver driver;
    private LoginPage login;
    private DashboardPage dashboard;



    @When("Agregar al carrito el producto con {product_name}")
    public void agregarProductoAlCarrrito(String product_name) {
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.seleccionarProducto(product_name);
    }


    @When("Ingresar al Carrito")
    public void ingresarAlCarritoCompras() {
        dashboard = new DashboardPage(driver);
        dashboard.ingresarAlCarrito();
    }


}

