package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Utility class to help manage the creation of drivers
 */
public class BrowserDriver {

    /**
     * This method creates an instance of ChromeDriver using the provided executable
     * @return a webdriver instance
     */
    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * This method creates a remote driver to be used with Selenium Grid
     * @return a remote webdriver instance
     * @throws MalformedURLException
     */
    public static WebDriver getRemoteDriver() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
    }
}
