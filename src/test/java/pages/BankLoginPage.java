package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BankLoginPage {

    WebDriver driver;                                   //declare the driver

    public BankLoginPage(){                             //create a constructor
        driver = Driver.getDriver();                    //inicialeze the driver
        PageFactory.initElements(driver,this);          //initialize Webelements on this page
    }
    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(name = "//input[@name='username']")
    public WebElement usernameinput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginBtn;
}
