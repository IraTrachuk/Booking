package com.company;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Admin on 18.05.15.
 */
public class TestHelper {

    public static WebDriver chromeDriver;

    public static void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\QA Automation (IRA)\\Chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));

    }

    public static void tearDown(){
        chromeDriver.quit();
    }

    public static WebDriver getChromeDriver(){
        return chromeDriver;
    }

    public static void setChromeDriver(){
        TestHelper.chromeDriver = chromeDriver;
    }

}
