package pages;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public abstract class BasePage {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    protected final static int WAIT_TIMEOUT_SECONDS = 10;

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitVisibilityOf(WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions
                .visibilityOf(element));
    }

    protected WebElement waitToClickable(WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions
                .elementToBeClickable(element));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasePage basePage = (BasePage) o;
        return driver.equals(basePage.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver);
    }
}
