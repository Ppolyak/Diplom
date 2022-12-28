package services;

import pages.BaseMenuPage;
import pages.LoginPage;

public class BaseMenuPageService {

    protected BaseMenuPage baseMenuPage;
    public void openProfileProperties(){
        baseMenuPage.clickOnProfileIcon();
    }

    public LoginPage signOut(){
        baseMenuPage = new BaseMenuPage();
        baseMenuPage
                .clickOnProfileIcon()
                .clickOnSignOutButton();
        return new LoginPage();
    }


}
