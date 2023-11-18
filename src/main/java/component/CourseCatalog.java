package component;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.AbsPageObject;

import java.util.List;

public class CourseCatalog extends AbsPageObject {

    public CourseCatalog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(), 'Каталог')]//ancestor::section//child::a")
    private List<WebElement> coursesListLoc;
    private final String courseSel = "a[href='/lessons/%s']";

    public CourseCatalog checkVisibleCourses() {


        for (WebElement element : coursesListLoc) {
            Assertions.assertTrue(element.isDisplayed());
        }
        return this;
    }

    public void checkCountCourses(int countCourses) {
        Assertions.assertEquals(countCourses, coursesListLoc.size());
    }

    public void clickCourse(String courseName) {

        String selector = String.format(courseSel, courseName);
        $(By.cssSelector(selector)).click();
    }
}

