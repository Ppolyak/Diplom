package services;

import pages.RepositoryPage;

public class RepositoryPageService {

    protected RepositoryPage repositoryPage = new RepositoryPage();

    public String getRepositoryName(){
        return repositoryPage.getRepositoryText();
    }

    public RepositoryPage addSuite(String suiteName){
        repositoryPage
                .clickOnAddSuiteButton()
                .fillSuiteNameField(suiteName)
                .clickOnCreateButton();
        return new RepositoryPage();
    }

    public String getSuccessAddedPopUpMessage(){
        return repositoryPage.getSuccessAddedSuitePopUpMessage();
    }

    public String getSuccessDeletedPopUpMessage(){
        return repositoryPage.getSuccessDeletedSuitePopUpMessage();
    }

    public void deleteSuite(String suiteName){
        repositoryPage.deleteSuite(suiteName);
    }

    public RepositoryPage chooseMindMapView(){
        repositoryPage
                .clickOnViewsButton()
                .chooseOnMindMapView();
        return new RepositoryPage();
    }

    public boolean isMindMapViewOpen(){
        return repositoryPage.isMindMapViewOpen();
    }

}
