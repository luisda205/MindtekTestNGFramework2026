package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class BlazeDemoLinkText extends TestBase {
    String fromCity = "Boston";
    String toCity = "Rome";

    @Test(groups = "regression")
    public void verifyDestinationOfTheWeek(){
        driver.get(ConfigReader.getProperty("blazedemoUrl"));
        driver.findElement(By.partialLinkText("destination of the week")).click();
        String actualText = driver.findElement(By.xpath("/html/body/div[2]")).getText();
        Assert.assertEquals(actualText,"Destination of the week: Hawaii !");
    }
    @Test(groups = "regression")
    public void verifyselectedCities(){
        driver.get(ConfigReader.getProperty("blazedemoUrl"));
        Select fromCityselect = new Select(driver.findElement(By.name("fromPort")));
        Select toCitySelect = new Select(driver.findElement(By.name("toPort")));
        WebElement findFlightsbtn = driver.findElement( By.xpath("//input[@value='Find Flights']"));

        BrowserUtils.selectByValue(driver.findElement(By.name("fromPort")),fromCity);

        BrowserUtils.selectByValue(driver.findElement(By.name("toPort")),toCity);

        findFlightsbtn.click();


        String flightsMessege = driver.findElement(By.tagName("h3")).getText();
        String expectedFlightsMessage ="Flights from "+ fromCity +" to "+toCity+":";
        Assert.assertEquals(flightsMessege,expectedFlightsMessage);
    }
    @Test(groups = "regression")
    public void  verifySelectedFlight(){
        driver.get(ConfigReader.getProperty("blazedemoUrl"));
        Select fromCityselect = new Select(driver.findElement(By.name("fromPort")));
        Select toCitySelect = new Select(driver.findElement(By.name("toPort")));
        WebElement findFlightsbtn = driver.findElement( By.xpath("//input[@value='Find Flights']"));

        fromCityselect.selectByValue(fromCity);
        toCitySelect.selectByValue(toCity);
        findFlightsbtn.click();

                                        //Choose the flight
        WebElement chooseFlightBtn1 = driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[1]"));

                                        //Flight number
        String expectedflightNum = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();

                                         //Air line
        String expectedAirline = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();

                                         // Price
        String expectedPrice = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText();

        chooseFlightBtn1.click();

                                 //actual airline
        String actualAirline = driver.findElement(By.xpath("//p[1]")).getText();

                                // actual flight number
        String actualFlightNum =  driver.findElement(By.xpath("//p[2]")).getText();

                                 // actual price
        String actualPrice =  driver.findElement(By.xpath("//p[3]")).getText();

//                                //change the string variable
//        actualFlightNum = actualFlightNum.substring(actualFlightNum.indexOf(":"))+2;
//        actualAirline = actualAirline.substring(actualAirline.indexOf(":"))+2;
//        actualPrice = actualPrice.substring(actualPrice.indexOf(":"))+2;

                                // testing
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAirline,expectedAirline);
        softAssert.assertEquals(actualFlightNum,expectedflightNum);
        softAssert.assertEquals(actualPrice,expectedPrice);
        softAssert.assertAll();
    }
}
