import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import utils.BrowserDriver;

public class TestBase {

    WebDriver driver;

    @Before
    public void setUp() {
        BrowserDriver.loadPage("");
        LandingPage.selectNumberOfTravelers();
        LandingPage.clickOnBookNowButton();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
