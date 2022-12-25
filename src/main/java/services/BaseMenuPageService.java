package services;

import pages.BaseMenuPage;
import pages.LoginPage;

public class BaseMenuPageService {

    protected BaseMenuPage baseMenuPage = new BaseMenuPage();
    protected LoginPage loginPage = new LoginPage();
    public void openProfileProperties(){
        baseMenuPage.clickOnProfileIcon();
    }

    public LoginPage signOut(){
        baseMenuPage
                .clickOnProfileIcon()
                .clickOnSignOutButton();
        return new LoginPage();
    }


}
