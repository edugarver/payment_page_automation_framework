package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Class used to manage the webdriver during the execution of the test
 */
public class BrowserDriver {
    private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());
    private static WebDriver driver;

    public synchronized static WebDriver getCurrentDriver() {
        if (driver == null) {
            try {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return driver;
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            driver = null;
            LOGGER.info("closing the browser");
        } catch (UnreachableBrowserException e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }

    public static void loadPage(String url) {
        LOGGER.info("Directing browser to:" + url);
        LOGGER.info("try to loadPage [" + url + "]");
        getCurrentDriver().get(url);
    }

}