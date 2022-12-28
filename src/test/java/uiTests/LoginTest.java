package uiTests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.BaseMenuPageService;
import services.LoginPageService;

public class LoginTest extends BaseTest{

    private String email = "pasha_polyakov8@mail.ru";
    private String password = "Romehu82";
    User user = User.builder()
            .email(email)
            .password(password)
            .build();
    private LoginPageService loginPageService;
    private BaseMenuPageService baseMenuPageService;

    @Test(priority = 1)
    public void loginTest(){
        loginPageService = new LoginPageService();
        String actualText = loginPageService.login(user).getProjectsText();
        String expectedText = "Projects";
        Assert.assertEquals(actualText,expectedText, "Texts not compares");
    }

    @Test(priority = 2)
    public void signOutTest(){
        baseMenuPageService = new BaseMenuPageService();
        baseMenuPageService.signOut();
        boolean isLoginButtonDisplayed = loginPageService.checkIfLoginButtonExist();
        Assert.assertTrue(isLoginButtonDisplayed);

    }

}
