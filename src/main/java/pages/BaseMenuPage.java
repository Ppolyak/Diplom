package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseMenuPage extends BasePage{

    @FindBy(xpath = "//img[@class='X8BNLp']")
    private WebElement profileIcon;

    @FindBy(xpath = "//*[contains(text(),'Sign')] ")
    private WebElement signOutButton;

    public BaseMenuPage clickOnProfileIcon(){
        waitVisibilityOf(profileIcon).click();
        return this;
    }

    public void clickOnSignOutButton(){
        signOutButton.click();
    }

}
