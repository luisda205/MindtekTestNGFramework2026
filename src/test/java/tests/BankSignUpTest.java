package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BankAccountServicesPage;
import pages.BankLoginPage;
import pages.BankRegisterpage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;


import java.util.Random;

public class BankSignUpTest extends TestBase {

    String username;
    String password;

    @DataProvider(name = "accountCreationData")
    public static Object[][] accountCreationData(){         //Multi- dimentional array
        return new Object[][]{
                {"jonh","Smith","1234 Penny ln","Minneapolis","mn","554433","1234567890","1234567890", BrowserUtils.usernameGenerator("Pedro"),"1234"},
                {"Adam","Lee","123 FDoo Rd","Chicago","Il","60606","0987654321","0987654321",BrowserUtils.usernameGenerator("Adam"),"4321"},
        };
    }
    @Test(groups ={"regression","smoke","bank","login"},dataProvider = "accountCreationData")
    public void bankAccountCreation(
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zip,
            String phoneNum,
            String ssn,
            String username,
            String password
    ){
        driver.get(ConfigReader.getProperty("bankUrl"));
        BankLoginPage bankLoginPage = new BankLoginPage();
        bankLoginPage.registerLink.click();

        BankRegisterpage bankRegisterpage = new BankRegisterpage();
        bankRegisterpage.firstName.sendKeys(firstName);
        bankRegisterpage.lastName.sendKeys(lastName);
        bankRegisterpage.Adrees.sendKeys(address);
        bankRegisterpage.City.sendKeys(city);
        bankRegisterpage.State.sendKeys(state);
        bankRegisterpage.Zip.sendKeys(zip);
        bankRegisterpage.Phone.sendKeys(phoneNum);
        bankRegisterpage.Ssn.sendKeys(ssn);

        bankRegisterpage.UserName.sendKeys(username );
        bankRegisterpage.Password.sendKeys(password);
        bankRegisterpage.RepitpassWord.sendKeys(password);
        bankRegisterpage.registerBtn.click();

        System.out.println(username);
        System.out.println(password);

        BankAccountServicesPage bankAccountServicesPage = new BankAccountServicesPage();
        Assert.assertEquals(bankAccountServicesPage.welcomeMessege.getText(),"Welcome " +username);
    }
    @Test(dependsOnMethods = "bankAccountCreation")
    public void bankLogin(){
        driver.get(ConfigReader.getProperty("bankUrl"));
        BankLoginPage bankLoginPage = new BankLoginPage();
        bankLoginPage.usernameinput.sendKeys(ConfigReader.getProperty("bankUsername"));
        bankLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("bankPassword"));
        bankLoginPage.loginBtn.click();

        BankAccountServicesPage bankAccountServicesPage = new BankAccountServicesPage();
        Assert.assertEquals(bankAccountServicesPage.loginWelcomeText.getText(),"Welcome");
    }
}
