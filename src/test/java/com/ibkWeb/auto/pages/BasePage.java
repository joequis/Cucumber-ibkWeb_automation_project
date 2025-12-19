package com.ibkWeb.auto.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


// Clase abstracta que implementa un wrapper con los métodos de interacción con el driver

public abstract class BasePage {

    protected WebDriver driver;
    private static final int TIMEOUT = 20; // segundos para la espera explicitas

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Espera explícita para que el elemento esté presente
    protected WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Espera explícita para que el elemento sea clickeable
    protected WebElement waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Navegar a una URL
    protected void navigateTo(String url) {
        driver.get(url);
    }

    // Buscar un elemento (espera hasta que esté presente)
    protected WebElement find(By locator) {
        return waitForElement(locator);
    }

    // Hacer click (espera hasta que sea clickeable)
    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    // Escribir texto (espera hasta que esté presente)
    protected void escribir_Texto(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }


    protected WebElement waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Obtener texto

    protected String getText(By locator) {
        return waitForVisible(locator).getText().trim();
    }

    protected String waitForNonEmptyText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // aumenta timeout
        return wait.until(d -> {
            String text = d.findElement(locator).getText().trim();
            return !text.isEmpty() ? text : null;
        });
    }


    // Cerrar navegador
    public void close() {
        driver.quit();
    }
}

