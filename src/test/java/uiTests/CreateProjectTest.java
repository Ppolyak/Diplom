package uiTests;

import api.objects.Suite;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.ProjectsPageService;
import services.RepositoryPageService;

public class CreateProjectTest extends BaseTest{

    private String projectName = "saqew";
    private String projectCode = "dcsaz";

    private String suiteName = "New suite";
    private String suiteName2 = "New suite2";
    private String suiteName3 = "New suite3";
    Project project = Project.builder()
            .projectName(projectName)
            .projectCode(projectCode)
            .build();
    private ProjectsPageService projectsPageService;

    private RepositoryPageService repositoryPageService;

    @BeforeClass(alwaysRun = true)
    public void login(){
        LoginPageService loginPageService = new LoginPageService();
        String email = "pasha_polyakov8@mail.ru";
        String password = "Romehu82";
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        loginPageService.login(user);
    }

    @Test(priority = 3,enabled = true)
    public void crateNewProjectTest() {
        repositoryPageService = new RepositoryPageService();
        projectsPageService = new ProjectsPageService();
        projectsPageService.createNewProject(project);
        String expected = projectCode + " repository";
        int length = expected.length();
        String repositoryText = repositoryPageService.getRepositoryName().toLowerCase();
        String actual = repositoryText.substring(0,length);
        Assert.assertEquals(actual,expected.toLowerCase(),"Not equals");
    }

    @Test(priority = 4)
    public void searchForProjectTest() throws InterruptedException {
        projectsPageService.openPage();
        String searchProjectName = projectName;
        projectsPageService.searchProject(searchProjectName);
        String expected = projectName;
        String actual = projectsPageService.getProjectNameInProjectsList();
        Assert.assertEquals(actual,expected,"No such project");
    }


    @Test(priority = 9)
    public void deleteProjectTest() throws InterruptedException {
        String searchProjectName = projectName;
        projectsPageService.openPage();
        projectsPageService.searchProjectForDelete(projectName);
        projectsPageService.deleteProject();
        Thread.sleep(1000);
        /*driver.navigate().refresh();*/
        boolean expected = projectsPageService.checkIfProjectExistInProjectsList(searchProjectName);
        Assert.assertFalse(expected, "Project was not deleted");
    }

    @Test(priority = 5)
    public void searchForNotExistingProjectTest(){
        String searchProjectName = "123344";
        boolean expected = projectsPageService.openPage().checkIfProjectExistInProjectsList(searchProjectName);
        Assert.assertFalse(expected,"Project exist");
    }

    @Test(dataProvider = "Add several suites", priority = 6)
    public void addSeveralSuitesTest(String suiteName) throws InterruptedException {
        String successCreateSuiteMessage = "Suite was successfully created.";
        projectsPageService.openPage();
        projectsPageService.searchProject(projectName);
        projectsPageService.openProjectRepository();
        repositoryPageService.addSuite(Suite.builder()
                .suiteName(suiteName)
                .build());
        String actualResult = repositoryPageService.getSuccessAddedPopUpMessage();
        Assert.assertEquals(actualResult,successCreateSuiteMessage,"Suite was not added");
    }

    @Test(priority = 7)
    public void deleteSuiteTest() throws InterruptedException {
        String successDeletedSuiteMessage = "Suite was successfully deleted.";
        projectsPageService.openPage();
        projectsPageService.searchProject(projectName);
        projectsPageService.openProjectRepository();
        repositoryPageService.deleteSuite(suiteName);
        String actualResult = repositoryPageService.getSuccessDeletedPopUpMessage();
        Assert.assertEquals(actualResult,successDeletedSuiteMessage,"Suite was not deleted");
    }

    @Test(priority = 8)
    public void isMindMapViewOpenedTest() throws InterruptedException {
        projectsPageService.openPage();
        projectsPageService.searchProject(projectName);
        projectsPageService.openProjectRepository();
        repositoryPageService.chooseMindMapView();
        Assert.assertTrue(repositoryPageService.isMindMapViewOpen(),"Mind Map view was not opened");
    }

    @DataProvider(name = "Add several suites")
    private Object[][] AddSeveralSuites() {
        return new Object[][] {
                {suiteName},
                {suiteName2},
                {suiteName3}
        };
    }

}
