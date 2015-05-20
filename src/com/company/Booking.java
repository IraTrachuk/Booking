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
    private String trainNumber = "043 К";
    private String car = "Купе";

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
        //вбить города; выбрать дату, передав значения дня и месяца; поиск; выбрать купе поезда, передав номер поезда и тип вагона; выбрать место, передав номер места.
        functions.selectCity(functions.getFrom(), functions.getCity1());
        functions.selectCity(functions.getTo(), functions.getCity2());
        functions.sleepTime(3000);
        functions.selectDate(functions.getDepDate(getMonth(), getDay()));
        functions.click(functions.getSearch());
        functions.sleepTime(3000);
        functions.click(functions.getTrain(getTrainNumber(), getCar()));

    }
}


