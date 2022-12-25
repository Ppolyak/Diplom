package services;

import pages.RepositoryPage;

public class RepositoryPageService {

    protected RepositoryPage repositoryPage = new RepositoryPage();

    public String getRepositoryName(){
        return repositoryPage.getRepositoryText();
    }

}
