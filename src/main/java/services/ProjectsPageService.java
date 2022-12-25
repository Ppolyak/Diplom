package services;

import models.Project;
import pages.ProjectsPage;
import pages.RepositoryPage;

public class ProjectsPageService {

    private static final String LOGIN_PAGE_URL = "https://app.qase.io/projects";
    protected ProjectsPage projectsPage = new ProjectsPage();

    public RepositoryPage createNewProject(Project project) {
        projectsPage
                .clickOnCreateNewProject()
                .fillProjectNameField(project.getProjectName())
                .fillProjectCodeField(project.getCode())
                .clickOnCreateProjectButtonInPopup();
        return new RepositoryPage();
    }

    public ProjectsPage deleteProject(){
        projectsPage
                .clickOnProjectPropertiesTab()
                .clickOnDeleteButton()
                .clickOnDeleteProjectButton();
        return new ProjectsPage();
    }

    public ProjectsPage searchProject(String searchProjectName){
        return projectsPage.searchForProject(searchProjectName);
    }

    public String getProjectNameInProjectsList(){
        return projectsPage.getProjectNameInProjectsList();
    }

    public boolean noSuchProjectTextIsDisplayed(){
        return projectsPage.noSuchProjectTextIsDisplayed();
    }

    public void getAllProjectsNames(){
        projectsPage.getAllProjectsNames();
    }

    public boolean checkIfProjectExistInProjectsList(String searchProjectName){
      return projectsPage.checkIfProjectExistInProjectsList(searchProjectName);
    }

    public RepositoryPage openProjectRepository(){
        projectsPage.clickOnProject();
        return new RepositoryPage();
    }

}
