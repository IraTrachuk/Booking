package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Admin on 18.05.15.
 */
@RunWith(JUnit4.class)
public class Booking {

    BookingPageObject functions = new BookingPageObject();

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
    public void smoke(){
        functions.selectCity(functions.getFrom(), functions.getCity1());
        functions.selectCity(functions.getTo(), functions.getCity2());
        functions.sleepTime(3000);
        functions.selectDate(functions.getDate_dep());
        functions.click(functions.getSearch());
        functions.sleepTime(3000);
        functions.click(functions.getCoupe());


    }
}
