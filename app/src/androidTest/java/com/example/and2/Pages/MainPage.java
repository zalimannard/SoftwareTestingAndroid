package com.example.and2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class MainPage
{
    private final AndroidDriver driver;

    public MainPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void clickComboBox()
    {
        driver.findElementByAccessibilityId("Новости").click();
    }

    public void clickComboBoxNews()
    {
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]").click();
    }


    public boolean isComboBoxAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout[@content-desc=\"Новости\"]/android.widget.TextView")));
        return !(element == null);
    }

    public boolean isComboBoxNewsAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]")));
        return !(element == null);
    }


    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/notifications_button")));
        return !(element == null);
    }
}
