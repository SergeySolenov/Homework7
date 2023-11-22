package component;

import data.courses.DurationCourses;
import data.courses.FormatCourses;
import data.courses.SubTitleCourses;
import data.courses.TitleCourses;
import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;
import pageObject.pages.CoursePage;



public class CourseChecker extends AbsPageObject {
    public CourseChecker(WebDriver driver) {
        super(driver);
    }
    String durationProLoc = "//p[contains(text(),'4 месяца')]";
    String formatProLoc = "//p[contains(text(),'Онлайн')]";
    String subTitleProLoc = ".sc-1og4wiw-0.sc-s2pydo-3.gaEufI.dZDxRw";
    String titleProLoc = ".sc-1og4wiw-0.sc-s2pydo-1.ifZfhS.diGrSa";
    public void checkCourseInfo(TitleCourses title, SubTitleCourses subTitle, FormatCourses format, DurationCourses duration){
        new CoursePage(driver)
                .checkTitle(title.getName(), titleProLoc)
                .checkSubTitle(subTitle.getName(), subTitleProLoc)
                .checkDuration(duration.getName(), durationProLoc)
                .checkFormat(format.getName(), formatProLoc);
    }

}
