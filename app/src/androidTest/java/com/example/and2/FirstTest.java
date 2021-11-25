package com.example.and2;

import static org.junit.Assert.assertTrue;

import android.icu.lang.UProperty;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.and2.Pages.AppearancePage;
import com.example.and2.Pages.FooterPage;
import com.example.and2.Pages.LeftMenuPage;
import com.example.and2.Pages.LogOutPage;
import com.example.and2.Pages.LoginPage;
import com.example.and2.Pages.MainPage;
import com.example.and2.Pages.MessagePage;
import com.example.and2.Pages.SettingsPage;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

@RunWith(AndroidJUnit4.class)
public class FirstTest
{
    private static AndroidDriver driver = null;

    ConfProperties properties = new ConfProperties();

    @BeforeClass
    public static void setUp()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Honor 7C");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("udid", "5VH9X18606G23004");
        capabilities.setCapability("appPackage", "com.vkontakte.android");
        capabilities.setCapability("appActivity", "com.vkontakte.android.MainActivity");
//        capabilities.setCapability("noReset", "true");
//        capabilities.setCapability("fullReset", "false");

        try
        {
            driver = new AndroidDriver(new URL("http://192.168.0.201:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }



        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        assertTrue(loginPage.atPage());
        assertTrue(loginPage.isLoginButtonAvailable());

        loginPage.clickLogin();
        assertTrue(loginPage.isLoginFieldAvailable());

        //loginPage.sendLogin(ConfProperties.getProperty("login"));
        loginPage.sendLogin("");
        assertTrue(loginPage.isPasswordFieldAvailable());

        //loginPage.sendLogin(ConfProperties.getProperty("password"));
        loginPage.sendPassword("");
        assertTrue(loginPage.isContinueButtonAvailable());

        loginPage.clickContinue();
        assertTrue(loginPage.isAllowCodeButtonAvailable());

        loginPage.clickAllowCodeButton();
        assertTrue(mainPage.atPage());
    }

    @Before
    public void before()
    {
        driver.closeApp();
        driver.startActivity(new Activity("com.vkontakte.android", "com.vkontakte.android.MainActivity"));
    }

    @Test
    public void openNews()
    {
        FooterPage footerPage = new FooterPage(driver);
        MainPage mainPage = new MainPage(driver);

        assertTrue(mainPage.atPage());
        assertTrue(footerPage.isMainPageButtonAvailable());
        footerPage.clickMainPage();
        assertTrue(mainPage.isComboBoxAvailable());
        mainPage.clickComboBox();
        assertTrue(mainPage.isComboBoxNewsAvailable());
        mainPage.clickComboBoxNews();
        sleep(5000);
    }

    @Test
    public void openAndScrollMessenger()
    {
        FooterPage footerPage = new FooterPage(driver);
        MessagePage messagePage = new MessagePage(driver);

        assertTrue(footerPage.atPage());
        assertTrue(footerPage.isMessagePageButtonAvailable());
        footerPage.clickMessagePage();
        assertTrue(messagePage.atPage());
        messagePage.swipeDown(1000);
        assertTrue(messagePage.atPage());
        messagePage.swipeUp(500);
        assertTrue(messagePage.atPage());
    }

    @Test
    public void changeTheme()
    {
        FooterPage footerPage = new FooterPage(driver);
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        SettingsPage settingsPage = new SettingsPage(driver);
        AppearancePage appearancePage = new AppearancePage(driver);

        assertTrue(footerPage.atPage());
        assertTrue(footerPage.isLeftMenuPageButtonAvailable());

        footerPage.clickLeftMenuPage();
        assertTrue(leftMenuPage.isSettingsPageButtonAvailable());

        leftMenuPage.clickSettings();
        assertTrue(settingsPage.atPage());
        assertTrue(settingsPage.isAppearancePageButtonAvailable());

        settingsPage.clickAppearance();
        assertTrue(appearancePage.atPage());
        assertTrue(appearancePage.isLightThemeSwitchAvailable());

        appearancePage.setLightTheme();
        assertTrue(appearancePage.isDarkThemeSwitchAvailable());
        assertTrue(appearancePage.atPage());

        appearancePage.setDarkTheme();
        assertTrue(appearancePage.isLightThemeSwitchAvailable());
        assertTrue(appearancePage.atPage());

        appearancePage.setLightTheme();
        assertTrue(appearancePage.atPage());
    }

    @Test
    public void logOut()
    {
        MainPage mainPage = new MainPage(driver);
        FooterPage footerPage = new FooterPage(driver);
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        SettingsPage settingsPage = new SettingsPage(driver);
        LogOutPage logOutPage = new LogOutPage(driver);

        assertTrue(footerPage.atPage());
        assertTrue(footerPage.isLeftMenuPageButtonAvailable());

        footerPage.clickLeftMenuPage();
        assertTrue(leftMenuPage.atPage());
        assertTrue(leftMenuPage.isSettingsPageButtonAvailable());

        leftMenuPage.clickSettings();
        assertTrue(settingsPage.atPage());

        settingsPage.swipeDown(500);
        assertTrue(settingsPage.isLogoutButtonAvailable());

        settingsPage.clickLogOut();
        assertTrue(settingsPage.isConfirmLogOutButtonAvailable());

        settingsPage.confirmLogOut();
        assertTrue(logOutPage.atPage());
        assertTrue(logOutPage.isContinueButtonAvailable());

        logOutPage.clickContinue();
        assertTrue(mainPage.atPage());
    }

    @AfterClass
    public static void tearDown()
    {
        driver.closeApp();
    }

    private static void sleep(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
