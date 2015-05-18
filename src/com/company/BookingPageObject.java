package com.company;

/**
 * Created by Admin on 18.05.15.
 */
public class BookingPageObject {

    private String mainLink = "http://booking.uz.gov.ua/ru/";
    private String from = "//input[@name = 'station_from']";
    private String to = "//input[@name = 'station_till']";
    private String date = "//input[@id = 'date_dep']";
    private String date_dep = "html/body/div[2]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td[6]";
    private String search = "//button[@name = 'search']";
    private String city1 = "Киев";
    private String city2 = "Ивано-Франковск";

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

    public void selectCity (String xpath, String cityName){
        

    }

}
