package apiTests;

import api.adapter.ProjectAdapter;
import api.objects.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;

public class ProjectTest {

    private String code;
    private String title;

    @Test
    public void getAllProjectsTest(){
        int statusCode = new ProjectAdapter().getAllProjects().getStatusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test
    public void getProjectByCode(){
        code = "WQEQWEAAA";
        int statusCode = new ProjectAdapter().getProjectByCode(code).getStatusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test
    public void createNewProjectTest(){
        code = "newcode1";
        title = "Name pr3";
        Project project = Project.builder()
                .code(code)
                .title(title)
                .build();
        int statusCode = new ProjectAdapter().createNewProject(project).getStatusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test
    public void deleteProjectByCode(){
        code = "newcode";
        int statusCode = new ProjectAdapter().deleteProjectByCode(code.toUpperCase()).getStatusCode();
        Assert.assertEquals(statusCode,HTTP_OK);
    }

    @Test
    public void getNotExistingProjectByCode(){
        code = "Not exciting code";
        String expectedBody = "{\"status\":false,\"errorMessage\":\"Project not found\"}";
        String actualBody = new ProjectAdapter().getProjectByCode(code).asString();
        Assert.assertEquals(expectedBody,actualBody,"Error");
    }

}
