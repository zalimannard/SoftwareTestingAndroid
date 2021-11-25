package com.example.and2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage
{
    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void clickLogin()
    {
        driver.findElementById("com.vkontakte.android:id/login_button").click();
    }

    public void clickContinue()
    {
        driver.findElementById("com.vkontakte.android:id/continue_btn").click();
    }

    public void clickAllowCodeButton()
    {
        driver.findElementById("com.google.android.gms:id/positive_button").click();
    }


    public void sendLogin(String login)
    {
        driver.findElementById("com.vkontakte.android:id/email_or_phone").sendKeys(login);
    }

    public void sendPassword(String password)
    {
        driver.findElementById("com.vkontakte.android:id/vk_password").sendKeys(password);
    }


    public boolean isLoginButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.vkontakte.android:id/login_button")));
        return !(element == null);
    }

    public boolean isContinueButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.vkontakte.android:id/continue_btn")));
        return !(element == null);
    }

    public boolean isAllowCodeButtonAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.gms:id/positive_button")));
        return !(element == null);
    }

    public boolean isLoginFieldAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.vkontakte.android:id/email_or_phone")));
        return !(element == null);
    }

    public boolean isPasswordFieldAvailable()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.id("com.vkontakte.android:id/vk_password")));
        return !(element == null);
    }


    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/logo")));
        return !(element == null);
    }
}
