
package com.ibkWeb.auto.drivers;

import com.ibkWeb.auto.config.EnvironmentManager;
import com.ibkWeb.auto.drivers.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;


public class DriverRun {

    @Before
    public void setUp() {
        // Cargar configuración del ambiente
        EnvironmentManager.load();

        // Crear el driver usando tu fábrica
        String browser = EnvironmentManager.get("browser");
        boolean headless = Boolean.parseBoolean(EnvironmentManager.get("headless", "false"));
        WebDriver driver = DriverFactory.create(browser, headless);
        // Guardar en la sesión de Serenity para que steps lo consuman
        Serenity.setSessionVariable("driver").to(driver);

    }


    @After
    public void tearDown() {
        WebDriver driver = Serenity.sessionVariableCalled("driver");
        if (driver != null) {
            driver.quit();
        }
    }

}


