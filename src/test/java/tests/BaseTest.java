package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners(TestListener.class)
public abstract class BaseTest {


    protected WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        driver = DriverSingleton.getInstance().getDriver();
    }

    /*@AfterClass
    public void closeBrowser(){
        DriverSingleton.getInstance().closeDriver();
    }
*/

}
