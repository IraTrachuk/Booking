package com.company;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Admin on 18.05.15.
 */
public class BookingPageObject {

    private String mainLink = "http://booking.uz.gov.ua/ru/";
    private String from = "//input[@name = 'station_from']";
    private String to = "//input[@name = 'station_till']";
    private String date = "//input[@id = 'date_dep']";
    private String date_dep = ".//table[@class='grid']//table[@class='month']/caption[contains(text(), '"; ////table[@class='grid']//table[@class='month']/caption[contains(text(), 'Июнь 2015')]" + "/following::td[contains(text(), '25')][1]
    private String search = "//button[@name = 'search']";
    private String city1 = "Киев";
    private String city2 = "Одесса";
    private String trainNumber = "//a[contains(text(), '";//"//a[contains(text(), '043 К')]/following::div[@title='Купе'][1]/button"
    private String carNum = "//a[@href = '#"; //a[@href = '#5']
    private String placenumber = "//*[@id='places']//a[@title = '";
    private String price = "//td[@class='price']";


    public String getMainLink() {
        return mainLink;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getDate_dep() {
        return date_dep;
    }

    public String getSearch() {
        return search;
    }

    public String getCity1() {
        return city1;
    }

    public String getCity2() {
        return city2;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getCarNum() {
        return carNum;
    }

    public String getPlacenumber() {
        return placenumber;
    }

    public String getPrice() {
        return price;
    }

    public static void openPage(String xpath){
        TestHelper.getChromeDriver().get(xpath);
    }

    public void sleepTime(int Timer){
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement getElement (String xpath){
        return TestHelper.getChromeDriver().findElement(By.xpath(xpath));
    }

    public void selectCity (String xpath, String cityName){
        getElement(xpath).sendKeys(cityName);

        sleepTime(3000);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        sleepTime(3000);

    }

    public String getDepDate(String month, String day){
        return getDate_dep() + month + "')]//following::td[contains (text(), '" + day + "')][1]";
    }

    public void selectDate(String xpath){
        getElement(getDate()).click();
        sleepTime(2000);
        getElement(xpath).click();
        sleepTime(2000);
    }

    public String getTrain(String number, String carType){
        return getTrainNumber() + number + "')]//following::div[@title='" + carType + "'][1]/button";
    }

    public void click(String xpath){
        getElement(xpath).click();
        sleepTime(4000);
    }

    public void IsPlaceAvailable(String carNumber, String placeNumber){
        Assert.assertTrue(getElement(getCarNum() + carNumber + "']").isDisplayed());
        click(getCarNum() + carNumber + "']");
        Assert.assertTrue((getElement(getPlacenumber() + placeNumber + "']").getAttribute("class")).contains("free"));
        click(getPlacenumber() + placeNumber + "']");
    }

}
