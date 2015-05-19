package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.testng.Assert;

/**
 * Created by Admin on 18.05.15.
 */
@RunWith(JUnit4.class)
public class Booking {

    BookingPageObject functions = new BookingPageObject();

    private String month = "Июнь 2015";
    private String day = "25";
    private String trainNumber = "105 К";
    private String car = "Купе";
    private String carNumber = "6";
    private String place = "Место: 28";

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getCar() {
        return car;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getPlace() {
        return place;
    }

    @Before
    public void init(){
        TestHelper.init();
        functions.openPage(functions.getMainLink());
    }

    @After
    public void tearDown(){
        TestHelper.tearDown();
    }

    @Test
    public void open(){
        System.out.println(TestHelper.getChromeDriver().getTitle());
        functions.sleepTime(2000);
    }

    @Test
    public void butTicket2(){
        functions.selectCity(functions.getFrom(), functions.getCity1());
        functions.selectCity(functions.getTo(), functions.getCity2());
        functions.sleepTime(3000);
        functions.selectDate(functions.getDepDate(getMonth(), getDay()));
        functions.click(functions.getSearch());
        functions.sleepTime(3000);
        functions.click(functions.getTrain(getTrainNumber(), getCar()));
        functions.IsPlaceAvailable(getCarNumber(), getPlace());
        /*float x = Float.parseFloat(functions.getElement(functions.getPrice()).getText().replaceAll("[*]", ""));
        if (x < 250.0) {
            System.out.println("Ticket bought");
        }
        else {
            System.out.println("Too expensive");
        }
        */
    }
}


