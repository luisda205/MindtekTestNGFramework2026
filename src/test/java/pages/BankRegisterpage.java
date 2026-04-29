package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BankRegisterpage {

    WebDriver driver;

    public BankRegisterpage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer.firstName")
    public WebElement firstName;

    @FindBy(id = "customer.lastName")
    public WebElement lastName;

    @FindBy(id = "customer.address.street")
    public WebElement Adrees;

    @FindBy(id = "customer.address.city")
    public WebElement City;

    @FindBy(id = "customer.address.state")
    public WebElement State;

    @FindBy(id = "customer.address.zipCode")
    public WebElement Zip;

    @FindBy(id = "customer.phoneNumber")
    public WebElement Phone;

    @FindBy(id = "customer.ssn")
    public WebElement Ssn;

    @FindBy(id = "customer.username")
    public WebElement UserName;

    @FindBy(id = "customer.password")
    public WebElement Password;

    @FindBy(id = "repeatedPassword")
    public WebElement RepitpassWord;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerBtn;
}



