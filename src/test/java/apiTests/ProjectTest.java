package apiTests;

import api.adapter.ProjectAdapter;
import api.objects.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;

public class ProjectTest {

    private String code = "765qwe";
    private String title = "newapi";
    private String codeNotExist = "Not exciting code";

    @Test(priority = 1)
    public void getAllProjectsTest(){
        int statusCode = new ProjectAdapter().getAllProjects().getStatusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test(priority = 4)
    public void getProjectByCode(){
        int statusCode = new ProjectAdapter().getProjectByCode(code).getStatusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test(priority = 2)
    public void createNewProjectTest(){
        Project project = Project.builder()
                .code(code)
                .title(title)
                .build();
        int statusCode = new ProjectAdapter().createNewProject(project).getStatusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test(priority = 5)
    public void deleteProjectByCode(){
        int statusCode = new ProjectAdapter().deleteProjectByCode(code.toUpperCase()).getStatusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test(priority = 3)
    public void getNotExistingProjectByCode(){
        String expectedBody = "{\"status\":false,\"errorMessage\":\"Project not found\"}";
        String actualBody = new ProjectAdapter().getProjectByCode(codeNotExist).asString();
        Assert.assertEquals(expectedBody,actualBody,"Error");
    }

}
