package pageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage extends AbsBasePage {
    public CoursePage(WebDriver driver) {
        super(driver, "/");
    }

    public CoursePage checkTitle(String expected, String coursesTitle) {
        Assertions.assertEquals(expected, $(By.cssSelector(coursesTitle)).getText());
        return this;
    }

    public CoursePage checkSubTitle(String expected, String coursesSubTitle) {
        Assertions.assertEquals(expected, $(By.cssSelector(coursesSubTitle)).getText());
        return this;
    }

    public CoursePage checkDuration(String expected, String coursesDuration) {
        Assertions.assertEquals(expected, $(By.xpath(coursesDuration)).getText());
        return this;
    }

    public CoursePage checkFormat(String expected, String coursesFormat) {
        Assertions.assertEquals(expected, $(By.xpath(coursesFormat)).getText());
        return this;
    }
}
