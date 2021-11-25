package com.example.and2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LeftMenuPage
{
    private final AndroidDriver driver;

    public LeftMenuPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void clickSettings()
    {
        driver.findElementByAccessibilityId("Настройки").click();
    }

    public boolean isSettingsPageButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Настройки\"]")));
        return !(element == null);
    }


    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Мой профиль, Дима Колесников, @id107720993\"]/android.widget.ImageView[1]")));
        return !(element == null);
    }
}
