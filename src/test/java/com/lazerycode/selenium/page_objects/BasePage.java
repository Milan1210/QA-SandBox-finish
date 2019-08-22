package com.lazerycode.selenium.page_objects;

import com.lazerycode.selenium.DriverBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final RemoteWebDriver driver = DriverBase.getDriver();

    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    public BasePage() throws Exception {
    }

    // Click on element with wait to be clickable
    public void click(String xPath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        driver.findElement(By.xpath(xPath)).click();
    }

    // Send keys to element eith wait to be clickable and clearing text.
    public void sendKeys(String xPath, String keys) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        WebElement webElement = driver.findElement(By.xpath(xPath));
        webElement.clear();
        webElement.sendKeys(keys);
    }
}
