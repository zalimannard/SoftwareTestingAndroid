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

public class MessagePage
{
    private final AndroidDriver driver;
    private final int SLEEP_BEFORE_SWIPE_TIME = 2000;

    public MessagePage(AndroidDriver driver)
    {
        this.driver = driver;
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


    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/im_dialogs_list_container")));
        return !(element == null);
    }
}
