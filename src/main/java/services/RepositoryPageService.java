package services;

import api.objects.Suite;
import io.qameta.allure.Step;
import pages.RepositoryPage;

public class RepositoryPageService {

    private RepositoryPage repositoryPage;

    @Step("Get repository name")
    public String getRepositoryName(){
        repositoryPage = new RepositoryPage();
        return repositoryPage.getRepositoryText();
    }

    @Step
    public RepositoryPage addSuite(Suite suite){
        repositoryPage
                .clickOnAddSuiteButton()
                .fillSuiteNameField(suite.getSuiteName())
                .clickOnCreateButton();
        return new RepositoryPage();
    }

    @Step("Get success added popup message")
    public String getSuccessAddedPopUpMessage(){
        return repositoryPage.getSuccessAddedSuitePopUpMessage();
    }

    @Step("Get success deleted popup message")
    public String getSuccessDeletedPopUpMessage(){
        return repositoryPage.getSuccessDeletedSuitePopUpMessage();
    }

    @Step("Delete suite")
    public void deleteSuite(String suiteName){
        repositoryPage.deleteSuite(suiteName);
    }

    @Step("Choose mind map view")
    public RepositoryPage chooseMindMapView(){
        repositoryPage
                .clickOnViewsButton()
                .chooseOnMindMapView();
        return new RepositoryPage();
    }

    @Step("Check is mind map view opened")
    public boolean isMindMapViewOpen(){
        return repositoryPage.isMindMapViewOpen();
    }

}
