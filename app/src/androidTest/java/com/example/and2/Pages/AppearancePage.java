package com.example.and2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AppearancePage
{
    private final AndroidDriver driver;

    public AppearancePage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void setLightTheme()
    {
        driver.findElementById("com.vkontakte.android:id/light_theme_btn").click();
    }

    public void setDarkTheme()
    {
        driver.findElementById("com.vkontakte.android:id/dark_theme_btn").click();
    }

    public boolean isLightThemeSwitchAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.vkontakte.android:id/light_theme_btn")));
        return !(element == null);
    }

    public boolean isDarkThemeSwitchAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.vkontakte.android:id/dark_theme_btn")));
        return !(element == null);
    }


    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")));
        return !(element == null);
    }
}
