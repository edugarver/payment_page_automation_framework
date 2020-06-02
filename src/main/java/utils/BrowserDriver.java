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
     * Returns an instance of a remote or a local webdriver, according to the given location
     *
     * @param driverLocation
     * @return
     */
    public static WebDriver getDriver(String driverLocation) {
        if (isValidURL(driverLocation)) {
            return getRemoteDriver(driverLocation);
        } else {
            return getLocalDriver(driverLocation);
        }
    }

    /**
     * This method creates an instance of ChromeDriver using the provided executable
     *
     * @param driverLocation
     * @return a webdriver instance
     */
    private static WebDriver getLocalDriver(String driverLocation) {
        System.setProperty("webdriver.chrome.driver", driverLocation);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * This method creates a remote driver to be used with Selenium Grid
     *
     * @return a remote webdriver instance
     */
    private static WebDriver getRemoteDriver(String driverLocation) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(driverLocation), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static boolean isValidURL(String urlString) {
        try {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
