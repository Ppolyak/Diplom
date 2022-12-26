package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ProjectsPage extends BaseMenuPage{

    @FindBy(xpath = "//div[@class='col-lg-12']/h1")
    private WebElement projectsText;
    @FindBy(xpath = "//span[@class='UdZcu9']")
    private WebElement createProjectButton;
    @FindBy(xpath = "//input[@id='project-name']")
    private WebElement projectNameField;
    @FindBy(xpath = "//input[@id='project-code']")
    private WebElement projectCodeField;
    @FindBy(xpath = "//a[@class='defect-title']")
    private WebElement projectNameOnProjectsList;
    @FindBy(xpath = "//button[@class='LzLtDS tscvgR MBIQEc']/*[contains(text(),'Create project')]")
    private WebElement createProjectButtonInPopup;
    @FindBy(xpath = "//tr[@class='project-row']/descendant::a[@class='btn btn-dropdown']")
    private WebElement projectPropertiesTab;
    @FindBy(xpath = "//button[@class='LzLtDS DRnS3P MBIQEc']")
    private WebElement deleteProjectButton;
    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-end show']/descendant::button[@class='Rl5f2G']")
    private WebElement deleteButton;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchForProjectField;
    @FindBy(xpath = "//tr[@class='project-row']/descendant::a[@class='defect-title']")////a[@class='defect-title']
    private WebElement projectNameInProjectsNamesList;
    @FindBy(xpath = "//span[@class='no-project mt-4']")
    private WebElement noSuchProjectText;
    /*private static final String PROJECT_PROPERTIES_TAB = "//tr[@class='project-row'][%s]/descendant::a[@class='btn btn-dropdown']";*/
    private static final String DELETE_BUTTON = "//div[@class='dropdown-menu dropdown-menu-end show']/descendant::button[@class='Rl5f2G']";
    private static final By PROJECT_NAME_IN_PROJECTS_LIST = By.xpath("//tr[@class='project-row']/descendant::a[@class='defect-title']");

    @FindBy(xpath = "//tr[@class='project-row']/descendant::a[@class='defect-title']")
    List<WebElement> namesList;
    Boolean exist;

    public boolean checkIfProjectExistInProjectsList(String searchProjectName) {
        waitVisibilityOf(projectNameInProjectsNamesList);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement element : namesList) {
            names.add(element.getText());
        }

        for (int i = 0; i < names.size(); i++){
            if (Objects.equals(names.get(i), searchProjectName)){
                exist = true;
                break;
            }
            else {
                exist = false;
            }

        }
        System.out.println(names);
        System.out.println(names.size());
        System.out.println(exist);
        return exist;
    }

    public boolean noSuchProjectTextIsDisplayed(){
        return waitVisibilityOf(noSuchProjectText).isDisplayed();
    }

    public void getAllProjectsNames(){
        waitVisibilityOf(projectPropertiesTab);
        ArrayList <WebElement> namesList = new ArrayList <WebElement>();
        driver.findElements(PROJECT_NAME_IN_PROJECTS_LIST).addAll(namesList);
        System.out.println(namesList);
    }

    public String getProjectNameInProjectsList(){
        return waitVisibilityOf(projectNameInProjectsNamesList).getText();

    }


    public ProjectsPage searchForProject(String searchProjectName){
        waitVisibilityOf(searchForProjectField).clear();
        searchForProjectField.clear();
        searchForProjectField.sendKeys(searchProjectName);
        /*waitVisibilityOf(projectPropertiesTab);*/
        return this;
    }

    public ProjectsPage clickOnProjectPropertiesTab(){
        waitVisibilityOf(projectPropertiesTab).click();
        return this;
    }

    public ProjectsPage clickOnDeleteButton(){
        deleteButton.click();
        return this;
    }

    public ProjectsPage clickOnDeleteProjectButton(){
        deleteProjectButton.click();
        return this;
    }

    public String getProjectsText(){
        return waitVisibilityOf(projectsText).getText();
    }

    public ProjectsPage clickOnCreateNewProject(){
        createProjectButton.click();
        return this;
    }

    public ProjectsPage fillProjectNameField(String projectName){
        projectNameField.clear();
        projectNameField.sendKeys(projectName);
        return this;
    }

    public ProjectsPage fillProjectCodeField(String projectCode) {
        projectCodeField.click();
        projectCodeField.clear();
        projectCodeField.sendKeys(projectCode);
        return this;
    }

    public void clickOnCreateProjectButtonInPopup(){
        createProjectButtonInPopup.click();
    }

    public void clickOnProject(){
        waitVisibilityOf(projectNameOnProjectsList).click();
    }

}
