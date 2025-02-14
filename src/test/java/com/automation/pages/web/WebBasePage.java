package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebBasePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor executor;
    Actions actions;

    public WebBasePage() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        executor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            executor.executeScript("arguments[0].click();", element);
        }
    }

    public void pause(int seconds) {
        actions.pause(Duration.ofSeconds(seconds)).build().perform();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            setImplicitWait(3);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }

    public void setImplicitWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public boolean isDisplayed(String xpath, String value) {
        try {
            setImplicitWait(0);
            WebElement element = driver.findElement(By.xpath(String.format(xpath, value)));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }


    public void moveToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public void waitTillClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTillVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
