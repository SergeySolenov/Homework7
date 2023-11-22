package waiters;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    private WebDriver driver;
    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            webDriverWait.until(condition);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
    public void waitForAttributeNotContains(WebElement loc, String atr, String value) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.not
                (ExpectedConditions.attributeContains(loc, atr, value))));
    }

}
