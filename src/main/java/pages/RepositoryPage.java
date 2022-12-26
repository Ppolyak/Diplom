package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositoryPage extends BasePage{

    @FindBy(xpath = "//h1[@class='VqrSGU']/self::*")
    private WebElement repository;
    @FindBy(xpath = "//a[@id='create-suite-button']")
    private WebElement addSuiteButton;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement suiteNameField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createSuiteButton;
    @FindBy(xpath = "//span[@class='OL6rtE']")
    private WebElement successAddedMessagePopUp;
    @FindBy(xpath = "//span[@class='OL6rtE']")
    private WebElement successDeletedMessagePopUp;
    @FindBy(xpath = "//button[@class='LzLtDS DRnS3P MBIQEc']")
    private WebElement deleteSuiteButtonInPopUp;
    @FindBy(xpath = "//button[@class='EnBgyZ LzLtDS HRmKBJ MBIQEc']")
    private WebElement viewsButton;
    @FindBy(xpath = "//div[@class='xl1jSX']/following-sibling::div/div[contains(text(),'Mind')]")
    private WebElement mindMapViewsButton;
    @FindBy(xpath = "//div[@class='vc_P1V']")
    private WebElement mindMapViewCanvas;
    @FindBy(xpath = "//div[@class='Hdl2GR']/descendant::span[@class='DvbSwG']")
    List<WebElement> suiteNamesList;

    private static final String SUITE_NAME_WITH_POSITION = ("//div[@id='suitecases-container']/descendant::div[@class='ioDlVH'][%s]/descendant::i[@class='far fa-trash']");
    ////h1[@class='VqrSGU'] | not//span[@class='zttQ3P']
    int suitePosition;
    public void setSuitePosition(int suitePosition) {
        this.suitePosition = suitePosition;
    }

    public String getRepositoryText(){
        return waitVisibilityOf(repository).getText();
    }

    public RepositoryPage clickOnAddSuiteButton(){
        waitVisibilityOf(addSuiteButton).click();
        return this;
    }

    public RepositoryPage fillSuiteNameField(String suiteName){
        suiteNameField.sendKeys(suiteName);
        return this;
    }

    public boolean isMindMapViewOpen(){
        return waitVisibilityOf(mindMapViewCanvas).isDisplayed();
    }

    public RepositoryPage clickOnViewsButton(){
        waitVisibilityOf(viewsButton).click();
        return this;
    }

    public RepositoryPage chooseOnMindMapView(){
        waitVisibilityOf(mindMapViewsButton).click();
        return this;
    }

    public RepositoryPage clickOnCreateButton(){
        createSuiteButton.click();
        return this;
    }

    public String getSuccessAddedSuitePopUpMessage(){
        return waitVisibilityOf(successAddedMessagePopUp).getText();
    }
    public String getSuccessDeletedSuitePopUpMessage(){
        return waitVisibilityOf(successAddedMessagePopUp).getText();
    }

    public void deleteSuite(String suiteName) {
        waitVisibilityOf(addSuiteButton);
        ArrayList<String> suiteNames = new ArrayList<>();
        for (WebElement element : suiteNamesList) {
            suiteNames.add(element.getText());
        }
        for (int i = 0; i < suiteNames.size(); i++){
            if(Objects.equals(suiteNames.get(i), suiteName)){
                suitePosition = i + 1;
                break;
            }
            else {
                System.out.println("No such suite");
            }
        }
        System.out.println(suiteNames);
        waitVisibilityOf(driver.findElement(By.xpath(String.format(SUITE_NAME_WITH_POSITION,suitePosition)))).click();
        waitVisibilityOf(deleteSuiteButtonInPopUp).click();
    }



    /*public RepositoryPage deleteSuite2(String suiteName){
        findSuitePosition(suiteName);
        driver.findElement(By.xpath(String.format(String.valueOf(SUITE_NAME_WITH_POSITIOB),suitePosition))).click();
        return this;
    }*/

}
