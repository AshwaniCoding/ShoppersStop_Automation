package com.automation.pages.common;

import com.automation.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class BasePage {

    public WebDriver driver;
    WebDriverWait wait;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }


    public void waitForElementVisible(WebElement ele) {

        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitForElementClickable(WebElement ele) {

        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public static String getFormattedDate(String expectedFormat, String date, String currentDateFormat) {
        try {
            SimpleDateFormat currentFormatter = new SimpleDateFormat(currentDateFormat);
            Date dateObject = currentFormatter.parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObject);

            SimpleDateFormat expectedFormatter = new SimpleDateFormat(expectedFormat);
            return expectedFormatter.format(calendar.getTime());
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format " + expectedFormat);
        }
    }

    public void pause(long milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isDisplayed(String xpath) {
        try {
            setImplicitWait(5000);
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(60000);
        }
    }

    public void setImplicitWait(int sec) {

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(sec));
    }

    public void scrollDown() {

        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), width / 2, height / 2))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(4), PointerInput.Origin.viewport(), width / 2, 0))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AndroidDriver) driver).perform(Collections.singletonList(sequence));
    }

}
