package component;
import data.CategoryQA;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public class CourseFilter extends AbsPageObject {

    public CourseFilter(WebDriver driver) {
        super(driver);
    }

    public void checkFilter(CategoryQA categoryQA, boolean state) {

        String course = "//div[./label[text()='%s']]//input";
        String locator = String.format(course, categoryQA.getName());
        Assertions.assertEquals(state, $(By.xpath(locator)).isSelected());
    }
}
