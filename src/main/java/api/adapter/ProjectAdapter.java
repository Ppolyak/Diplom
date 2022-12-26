package api.adapter;

import api.objects.Project;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static api.utils.StringConstant.GET_PROJECT_BY_CODE_ENDPOINT;
import static api.utils.StringConstant.PROJECT_API_ENDPOINT;

public class ProjectAdapter extends BaseAdapter{

    @Step("Get all projects")
    public Response getAllProjects(){
        return get(PROJECT_API_ENDPOINT);
    }

    @Step("Get project by code")
    public Response getProjectByCode(String code){
        return get(String.format(GET_PROJECT_BY_CODE_ENDPOINT,code));
    }

    @Step("Create new project")
    public Response createNewProject(Project project){
        return post(PROJECT_API_ENDPOINT,converter.toJson(project));
    }

    @Step("Delete project by code")
    public Response deleteProjectByCode(String code){
        return delete(String.format(GET_PROJECT_BY_CODE_ENDPOINT,code));
    }



}
