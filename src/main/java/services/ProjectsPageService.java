package services;

import io.qameta.allure.Step;
import models.Project;
import pages.ProjectsPage;
import pages.RepositoryPage;

public class ProjectsPageService {

    private static final String LOGIN_PAGE_URL = "https://app.qase.io/projects";
    protected ProjectsPage projectsPage = new ProjectsPage();

    @Step("Create new project")
    public RepositoryPage createNewProject(Project project) {
        projectsPage
                .clickOnCreateNewProject()
                .fillProjectNameField(project.getProjectName())
                .fillProjectCodeField(project.getProjectCode())
                .clickOnCreateProjectButtonInPopup();
        return new RepositoryPage();
    }

    @Step("Delete project")
    public ProjectsPage deleteProject(){
        projectsPage
                .clickOnDeleteButton()
                .clickOnDeleteProjectButton();
        return new ProjectsPage();
    }

    @Step("Search for project")
    public ProjectsPage searchProject(String searchProjectName){
        return projectsPage.searchForProject(searchProjectName);
    }

    @Step("Get project name in projects list")
    public String getProjectNameInProjectsList(){
        return projectsPage.getProjectNameInProjectsList();
    }

    @Step("Check that no such project text is displayed")
    public boolean noSuchProjectTextIsDisplayed(){
        return projectsPage.noSuchProjectTextIsDisplayed();
    }

    @Step("Get all projects names")
    public void getAllProjectsNames(){
        projectsPage.getAllProjectsNames();
    }

    @Step("Check if project exist in projects list")
    public boolean checkIfProjectExistInProjectsList(String searchProjectName){
      return projectsPage.checkIfProjectExistInProjectsList(searchProjectName);
    }

    @Step("Open project repository")
    public RepositoryPage openProjectRepository(){
        projectsPage.clickOnProject();
        return new RepositoryPage();
    }

    @Step("Open device properties for deleting")
    public ProjectsPage searchProjectForDelete(String searchProjectName){
        return projectsPage.searchForDeleteProject(searchProjectName);
    }


}
