package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
    private LoginPageService loginPageService = new LoginPageService();
    private BaseMenuPageService baseMenuPageService = new BaseMenuPageService();

    @Test
    public void loginTest(){
        String actualText = loginPageService.login(user).getProjectsText();
        String expectedText = "Projects";
        Assert.assertEquals(actualText,expectedText, "Texts not compares");
    }

    @Test
    public void signOutTest(){
        loginPageService.login(user);
        baseMenuPageService.signOut();
        boolean isLoginButtonDisplayed = loginPageService.checkIfLoginButtonExist();
        Assert.assertTrue(isLoginButtonDisplayed);

    }

}
