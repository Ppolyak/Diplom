package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='inputEmail']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='inputPassword']")
    private WebElement passwordField;
    @FindBy(xpath = "//span[@data-qase-test='remember-me-checkbox']")
    private WebElement rememberMeCheckBox;
    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@data-qase-test='login-error']")
    private WebElement credentialsDoesNotMatchText;

    public String getCredentialsDoesNotMatchText(){
        return waitVisibilityOf(credentialsDoesNotMatchText).getText();
    }

    public LoginPage openPage(String url){
        driver.get(url);
        return this;
    }

    public LoginPage fillEmailField(String email){
        waitVisibilityOf(emailField);
        log.info("Entering email");
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordField(String password){
        waitVisibilityOf(passwordField);
        log.info("Entering password");
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
