package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BrowserUtils {
    /**
     *
     * @param firstName
     * @return
     */
    public static String usernameGenerator(String firstName){
        Random random = new Random();
        int randomNum = random.nextInt(99999);
        return firstName + randomNum;
    }

    /**
     *
     * @param element
     * @param value
     */
    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     *
     * @param element
     */
    public  static  void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
}
