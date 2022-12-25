package tests;

import driver.DriverSingleton;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import services.LoginPageService;
import utils.TestListener;

@Listeners(TestListener.class)
public abstract class BaseTest {


    protected WebDriver driver;
    protected LoginPageService loginPageService = new LoginPageService();

    @BeforeClass
    public void startBrowser() {
        String email = "pasha_polyakov8@mail.ru";
        String password = "Romehu82";
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        driver = DriverSingleton.getInstance().getDriver();
        loginPageService.login(user);

    }

    /*@AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }*/

}
