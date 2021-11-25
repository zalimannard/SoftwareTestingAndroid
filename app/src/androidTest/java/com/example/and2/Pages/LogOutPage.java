package com.example.and2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LogOutPage
{
    private final AndroidDriver driver;

    public LogOutPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void clickContinue()
    {
        driver.findElementById("com.vkontakte.android:id/continue_btn").click();
    }

    public boolean isContinueButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.vkontakte.android:id/continue_btn")));
        return !(element == null);
    }


    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]")));
        return !(element == null);
    }
}