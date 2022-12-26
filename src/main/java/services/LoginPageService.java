package services;

import io.qameta.allure.Step;
import models.User;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://app.qase.io/login";
    protected LoginPage loginPage = new LoginPage();

    @Step("Login")
    public ProjectsPage login(User user){
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickOnLoginButton();
        return new ProjectsPage();
    }

    @Step("Login")
    public boolean checkIfLoginButtonExist(){
        return loginPage.isLoginButtonVisible();
    }

}
