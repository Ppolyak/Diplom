package uiTests;

import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.ProjectsPageService;
import services.RepositoryPageService;

public class CreateProjectTest extends BaseTest{

    private String projectName = "pr3o";
    private String projectCode = "da4q3";

    private String suiteName = "New suite";
    Project project = Project.builder()
            .projectName(projectName)
            .projectCode(projectCode)
            .build();
    private ProjectsPageService projectsPageService = new ProjectsPageService();
    private LoginPageService loginPageService = new LoginPageService();
    private RepositoryPageService repositoryPageService = new RepositoryPageService();

    @BeforeClass
    public void login(){
        String email = "pasha_polyakov8@mail.ru";
        String password = "Romehu82";
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        loginPageService.login(user);
    }



    @Test(priority = 1)
    public void crateNewProjectTest() {
        projectsPageService.createNewProject(project);
        String expected = projectCode + " repository";
        int length = expected.length();
        String repositoryText = repositoryPageService.getRepositoryName().toLowerCase();
        String actual = repositoryText.substring(0,length);
        Assert.assertEquals(actual,expected.toLowerCase(),"Not equals");
    }

    @Test(priority = 2)
    public void searchForProject(){
        String searchProjectName = projectName;
        projectsPageService.searchProject(searchProjectName);
        String expected = projectName;
        String actual = projectsPageService.getProjectNameInProjectsList();
        Assert.assertEquals(actual,expected,"No such project");
    }


    @Test(priority = 5)
    public void deleteProject(){
        String searchProjectName = projectName;
        projectsPageService.searchProject(projectName);
        projectsPageService.deleteProject();
        /*driver.navigate().refresh();*/
        boolean expected = projectsPageService.checkIfProjectExistInProjectsList(searchProjectName);
        Assert.assertFalse(expected, "Project was not deleted");
    }

    @Test(priority = 7)
    public void searchForNotExistingProjectTest(){
        String searchProjectName = "NOT_EXISTING_PROJECT_NAME";
        boolean expected = projectsPageService.checkIfProjectExistInProjectsList(searchProjectName);
        Assert.assertFalse(expected,"Project exist");
    }

    @Test(priority = 4)
    public void addSuiteTest(){
        String successCreateSuiteMessage = "Suite was successfully created.";
        projectsPageService.searchProject(projectName);
        projectsPageService.openProjectRepository();
        repositoryPageService.addSuite(suiteName);
        String actualResult = repositoryPageService.getSuccessAddedPopUpMessage();
        Assert.assertEquals(actualResult,successCreateSuiteMessage,"Suite was not added");
    }

    @Test(priority = 5)
    public void deleteSuiteTest(){
        String successDeletedSuiteMessage = "Suite was successfully deleted.";
        projectsPageService.searchProject(projectName);
        projectsPageService.openProjectRepository();
        repositoryPageService.deleteSuite("newsuite");
        String actualResult = repositoryPageService.getSuccessDeletedPopUpMessage();
        Assert.assertEquals(actualResult,successDeletedSuiteMessage,"Suite was not deleted");
    }

    @Test(priority = 6)
    public void test(){
        projectsPageService.searchProject("sadasdasd");
        projectsPageService.openProjectRepository();
        repositoryPageService.chooseMindMapView();
        Assert.assertTrue(repositoryPageService.isMindMapViewOpen(),"Mind Map view was not opened");
    }


}
