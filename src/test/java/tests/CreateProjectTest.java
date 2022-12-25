package tests;

import models.Project;
import models.User;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.ProjectsPageService;
import services.RepositoryPageService;

import java.util.Locale;

public class CreateProjectTest extends BaseTest{

    private String projectName = "proje1ct";
    private String code = "data2123";
    private String email = "pasha_polyakov8@mail.ru";
    private String password = "Romehu82";
    Project project = Project.builder()
            .projectName(projectName)
            .code(code)
            .build();
    User user = User.builder()
            .email(email)
            .password(password)
            .build();


    private ProjectsPageService projectsPageService = new ProjectsPageService();
    private LoginPageService loginPageService = new LoginPageService();
    private RepositoryPageService repositoryPageService = new RepositoryPageService();



    @Test(priority = 1)
    public void crateNewProjectTest() {
        loginPageService.login(user);
        projectsPageService.createNewProject(project);
        String expected = code + " repository";
        int length = expected.length();
        String repositoryText = repositoryPageService.getRepositoryName().toLowerCase();
        String actual = repositoryText.substring(0,length);
        Assert.assertEquals(actual,expected.toLowerCase(),"Not equals");
    }

    @Test(priority = 2)
    public void searchForProject(){
        loginPageService.login(user);
        String searchProjectName = projectName;
        projectsPageService.searchProject(searchProjectName);
        String expected = projectName;
        String actual = projectsPageService.getProjectNameInProjectsList();
        Assert.assertEquals(actual,expected,"No such project");
    }

    @Test(priority = 3)
    public void searchForNotExistingProject(){
        loginPageService.login(user);
        String searchProjectName = "Some text";
        projectsPageService.searchProject(searchProjectName);
        Assert.assertTrue(projectsPageService.noSuchProjectTextIsDisplayed());
    }

    @Test(priority = 5)
    public void deleteProject(){
        loginPageService.login(user);
        String searchProjectName = projectName;
        projectsPageService.searchProject(projectName);
        projectsPageService.deleteProject();
        /*driver.navigate().refresh();*/
        boolean expected = projectsPageService.checkIfProjectExistInProjectsList(searchProjectName);
        Assert.assertFalse(expected, "Project was not deleted");
    }

    @Test(priority = 4)
    public void searchForNotExistingProjectTest(){
        loginPageService.login(user);
        String searchProjectName = "NOT_EXISTING_PROJECT_NAME";
        boolean expected = projectsPageService.checkIfProjectExistInProjectsList(searchProjectName);
        Assert.assertFalse(expected,"Project exist");
    }


}
