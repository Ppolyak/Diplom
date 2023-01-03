package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class BaseMenuPage extends BasePage{

    @FindBy(xpath = "//span[@class='Eb2vGG']")
    private WebElement profileIcon;

    @FindBy(xpath = "//*[contains(text(),'Sign')] ")
    private WebElement signOutButton;

    public BaseMenuPage clickOnProfileIcon(){
        log.info("Click on profile icon");
        waitVisibilityOf(profileIcon).click();
        return this;
    }

    public void clickOnSignOutButton(){
        signOutButton.click();
    }

}
