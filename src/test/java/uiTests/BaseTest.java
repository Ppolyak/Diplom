package uiTests;

import driver.DriverSingleton;
import models.User;
import org.openqa.selenium.WebDriver;
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
        driver = DriverSingleton.getInstance().getDriver();
    }

    /*@AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }*/

}
