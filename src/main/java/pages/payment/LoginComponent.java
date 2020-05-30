package pages.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserDriver;

public class LoginComponent {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30000);

    @FindBy(css = "#loginContent a")
    private WebElement loginLink;
    @FindBy(id = "loginEmail")
    private WebElement loginEmailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(className = "show-hide-btn")
    private WebElement showPasswordButton;
    @FindBy(id = "loginButton")
    private WebElement loginButton;
    @FindBy(id = "loginError")
    private WebElement loginErrorMessage;

    public LoginComponent() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginEmailField.isDisplayed() && passwordField.isDisplayed();
    }

    public void clickOnLoginLink() {
        loginLink.click();
    }

    public void setLoginEmailField(String loginEmail) {
        loginEmailField.clear();
        loginEmailField.sendKeys(loginEmail);
    }

    public void setPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnShowPasswordButton() {
        showPasswordButton.click();
    }

    public boolean isPasswordVisible() {
        return passwordField.getAttribute("type").equalsIgnoreCase("text");
    }

    public void setWrongLoginCredentials() {
        setLoginEmailField("wrongemail");
        setPasswordField("wrongpassword");
        loginButton.click();
    }

    public boolean isLoginErrorMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        return loginErrorMessage.isDisplayed();
    }
}
