package com.ibkWeb.auto.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory para creación de instancias WebDriver con soporte multi-browser.
 * Soporta: Chrome, Firefox, Edge | Headless mode | Configuraciones optimizadas
 * 
 * @author QA Automation Team
 * @version 2.2
 */
public class DriverFactory {
    
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    /**
     * Crea WebDriver según navegador especificado
     * 
     * @param browser chrome | firefox | edge
     * @param headless true para modo headless
     * @return WebDriver configurado
     * @throws IllegalArgumentException si navegador no soportado o null
     * @throws RuntimeException si error en creación del driver
     */
    public static WebDriver create(String browser, boolean headless) {
        if (browser == null || browser.trim().isEmpty()) {
            throw new IllegalArgumentException("Parámetro 'browser' es requerido");
        }

        try {
            switch (browser.toLowerCase().trim()) {
                case "chrome":
                    return createChromeDriver(headless);
                case "firefox":
                    return createFirefoxDriver(headless);
                case "edge":
                    return createEdgeDriver(headless);
                default:
                    throw new IllegalArgumentException(
                        String.format("Navegador '%s' no soportado. Válidos: chrome, firefox, edge", browser)
                    );
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Error creando WebDriver para: {}", browser, e);
            throw new RuntimeException("Error al crear WebDriver: " + e.getMessage(), e);
        }
    }

    /**
     * Crea ChromeDriver con opciones optimizadas
     */
    private static WebDriver createChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments(
            "--start-maximized",
            "--disable-notifications",
            "--disable-popup-blocking",
            "--disable-infobars",
            "--disable-extensions",
            "--no-sandbox",
            "--disable-dev-shm-usage"
        );
        
        if (headless) {
            options.addArguments("--headless=new", "--window-size=1920,1080");
        }
        
        return new ChromeDriver(options);
    }

    /**
     * Crea FirefoxDriver con opciones optimizadas
     */
    private static WebDriver createFirefoxDriver(boolean headless) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        
        options.addArguments("--width=1920", "--height=1080");
        if (headless) {
            options.addArguments("--headless");
        }
        
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("geo.enabled", false);
        
        return new FirefoxDriver(options);
    }

    /**
     * Crea EdgeDriver con opciones optimizadas
     */
    private static WebDriver createEdgeDriver(boolean headless) {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        
        options.addArguments(
            "--start-maximized",
            "--disable-notifications",
            "--disable-popup-blocking",
            "--disable-infobars",
            "--disable-extensions",
            "--no-sandbox",
            "--disable-dev-shm-usage"
        );
        
        if (headless) {
            options.addArguments("--headless=new", "--window-size=1920,1080");
        }
        
        return new EdgeDriver(options);
    }

    /**
     * Conveniencia: crear driver en modo normal
     */
    public static WebDriver create(String browser) {
        return create(browser, false);
    }
}
