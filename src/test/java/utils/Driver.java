package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    public static WebDriver getDriver(){
        String browser = ConfigReader.getProperty("browser");
        if (driver== null ||((RemoteWebDriver)driver).getSessionId()==null){
            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options= new ChromeOptions();
                    options.addArguments("--headless");
                    driver= new ChromeDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new SafariDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.navigate().re
        return driver;
    }
}
