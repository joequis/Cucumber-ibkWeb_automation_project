package com.ibkWeb.auto.steps;
import com.ibkWeb.auto.config.EnvironmentManager;
import com.ibkWeb.auto.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage login;

    @Given("Me encuentro en la Pagina de Login")
    public void abrirLogin() {
        driver = Serenity.sessionVariableCalled("driver");
        if (driver == null) {
            throw new IllegalStateException("El WebDriver no fue inicializado. Revisa DriverRun.");
        }
        login = new LoginPage(driver);
        driver.get(EnvironmentManager.get("app.url"));
    }

    @When("Ingreso las Credenciales {string} y {string}")
    public void ingresoCredencialesValidas(String user, String pass) {
        //tomo las variables del enviroment. Ahora no, tomarlas del scenario a modo prueba
       // String user = EnvironmentManager.get("app.username");
       // String pass = EnvironmentManager.get("app.password");
        login.login(user, pass);
    }


    @Then("Validar el ingreso exitoso")
    public void validarIngresoExitosoPara() {

        login.validarMensajeBienvenida();
    }

}

