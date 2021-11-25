package com.example.and2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class FooterPage
{
    private final AndroidDriver driver;

    public FooterPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void clickMainPage()
    {
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Главная\"]/android.widget.FrameLayout").click();
    }

    public void clickMessagePage()
    {
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Мессенджер\"]/android.widget.FrameLayout[1]").click();
    }

    public void clickLeftMenuPage()
    {
        driver.findElementByAccessibilityId("Открыть меню").click();
    }

    public boolean isMainPageButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@content-desc=\"Главная\"]/android.widget.FrameLayout")));
        return !(element == null);
    }

    public boolean isMessagePageButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@content-desc=\"Мессенджер\"]/android.widget.FrameLayout")));
        return !(element == null);
    }

    public boolean isLeftMenuPageButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Открыть меню\"]")));
        return !(element == null);
    }



    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/largeLabel")));
        return !(element == null);
    }
}
