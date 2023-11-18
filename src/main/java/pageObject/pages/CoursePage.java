package pageObject.pages;

import data.courses.CoursesDuration;
import data.courses.CoursesFormat;
import data.courses.CoursesSubTitle;
import data.courses.CoursesTitle;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage extends AbsBasePage {
    public CoursePage(WebDriver driver) {
        super(driver, "/");
    }

    public CoursePage checkTitle(String expected, CoursesTitle coursesTitle) {
        Assertions.assertEquals(expected, $(By.cssSelector(coursesTitle.getName())).getText());
        return this;
    }

    public CoursePage checkSubTitle(String expected, CoursesSubTitle coursesSubTitle) {
        Assertions.assertEquals(expected, $(By.cssSelector(coursesSubTitle.getName())).getText());
        return this;
    }

    public CoursePage checkDuration(String expected, CoursesDuration coursesDuration) {
        Assertions.assertEquals(expected, $(By.xpath(coursesDuration.getName())).getText());
        return this;
    }

    public CoursePage checkFormat(String expected, CoursesFormat coursesFormat) {
        Assertions.assertEquals(expected, $(By.xpath(coursesFormat.getName())).getText());
        return this;
    }
}
