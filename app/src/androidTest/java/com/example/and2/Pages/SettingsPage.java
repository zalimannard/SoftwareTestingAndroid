package com.example.and2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SettingsPage
{
    private final AndroidDriver driver;
    private final int SLEEP_BEFORE_SWIPE_TIME = 2000;

    public SettingsPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void clickAppearance()
    {
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]").click();
    }

    public void clickLogOut()
    {
        driver.findElementById("com.vkontakte.android:id/logout").click();
    }

    public void confirmLogOut()
    {
        driver.findElementById("android:id/button1").click();
    }

    public void swipeUp(int nPixels)
    {
        try
        {
            Thread.sleep(SLEEP_BEFORE_SWIPE_TIME);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        while(nPixels > 0)
        {
            (new TouchAction(driver))
                    .press(new PointOption().withCoordinates(200, 300))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                    .moveTo(new PointOption().withCoordinates(200, 300 + Math.min(nPixels, 200)))
                    .release()
                    .perform();
            nPixels -= 200;
        }
    }

    public void swipeDown(int nPixels)
    {
        try
        {
            Thread.sleep(SLEEP_BEFORE_SWIPE_TIME);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        while(nPixels > 0)
        {
            (new TouchAction(driver))
                    .press(new PointOption().withCoordinates(200, 300))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                    .moveTo(new PointOption().withCoordinates(200, 300 - Math.min(nPixels, 200)))
                    .release()
                    .perform();
            nPixels -= 200;
        }
    }

    public boolean isAppearancePageButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]")));
        return !(element == null);
    }

    public boolean isLogoutButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.vkontakte.android:id/logout")));
        return !(element == null);
    }

    public boolean isConfirmLogOutButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        return !(element == null);
    }


    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/vk_passport_action")));
        return !(element == null);
    }
}
