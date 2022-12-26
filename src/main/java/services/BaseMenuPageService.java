package services;

import pages.BaseMenuPage;
import pages.LoginPage;

public class BaseMenuPageService {

    protected BaseMenuPage baseMenuPage = new BaseMenuPage();
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
