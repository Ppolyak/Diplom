package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='inputEmail']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='inputPassword']")
    private WebElement passwordField;
    @FindBy(xpath = "//span[@data-qase-test='remember-me-checkbox']")
    private WebElement rememberMeCheckBox;
    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement loginButton;

    /*private static final String LOGIN_PAGE_URL = "https://app.qase.io/login";*/

    public LoginPage openPage(String url){
        driver.get(url);
        return this;
    }

    public LoginPage fillEmailField(String email){
        waitVisibilityOf(emailField);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordField(String password){
        waitVisibilityOf(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public boolean isLoginButtonVisible(){
        return waitVisibilityOf(loginButton).isDisplayed();
    }

}
