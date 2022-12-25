package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RepositoryPage extends BasePage{

    @FindBy(xpath = "//h1[@class='VqrSGU']/self::*")
    private WebElement repository;
    ////h1[@class='VqrSGU'] | not//span[@class='zttQ3P']
    public String getRepositoryText(){
        return waitVisibilityOf(repository).getText();
    }

}
