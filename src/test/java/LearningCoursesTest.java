import annotation.Driver;
import component.*;
import extensions.UIExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pageObject.pages.EventsPage;
import pageObject.pages.MainPage;

import static data.CategoryQA.TESTING;
import static data.EventsSortData.OPENWEB;
import static data.courses.DurationCourses.DURATION_JAVA_QA_PRO;
import static data.courses.FormatCourses.FORMAT_JAVA_QA_PRO;
import static data.courses.SubTitleCourses.SUBTITLE_JAVA_QA_PRO;
import static data.courses.TitleCourses.TITLE_JAVA_QA_PRO;
import static data.menu.HeaderMenu.LEARN;
import static data.menu.MenuCategory.EVENTS_CALENDAR;
import static data.menu.MenuCategory.TEST;

@ExtendWith(UIExtension.class)
public class LearningCoursesTest {
    private final Logger log = LogManager.getLogger("AutomationFramework");
    private final String testing = "/categories/testing";
    private final String lessonCal = "/events/near";

    @Driver
    public WebDriver driver;

    @Test
    public void checkCountQA() {
        log.info("Главная страница");
        new MainPage(driver).open();
        log.info("Раздел обучение");
        new moveHeader(driver).moveToHeader(LEARN);
        log.info("Раздел QA");
        new HeaderPopup(driver)
                .popupBeVisible(LEARN)
                .clickSubMenu(testing, TEST);
        log.info("Проверка фильтра");
        new CourseFilter(driver).checkFilter(TESTING, true);
        log.info("Проверка колличества курсов и их отображения");
        new CourseCatalog(driver)
                .checkVisibleCourses()
                .checkCountCourses(10);
    }

    @Test
    public void checkInfoCourses() {
        String coursePro = "java-qa-pro";
        log.info("Главная страница");
        new MainPage(driver).
                open();
        new moveHeader(driver)
                .moveToHeader(LEARN);
        log.info("Раздел тестирования");
        new HeaderPopup(driver)
                .popupBeVisible(LEARN)
                .clickSubMenu(testing, TEST);
        log.info("Выбираем PRO курс");
        new CourseCatalog(driver)
                .clickCourse(coursePro);
        log.info("Проверка информации о курсе");
        new CourseChecker(driver)
                .checkCourseInfo(TITLE_JAVA_QA_PRO, SUBTITLE_JAVA_QA_PRO, FORMAT_JAVA_QA_PRO, DURATION_JAVA_QA_PRO);
    }

    @Test
    public void checkDateOfEvents() {
        log.info("Главная страница");
        new MainPage(driver)
                .open();
        new moveHeader(driver)
                .moveToHeader(LEARN);
        log.info("Календарь мероприятий");
        new HeaderPopup(driver)
                .popupBeVisible(LEARN)
                .clickSubMenu(lessonCal, EVENTS_CALENDAR);
        log.info("Проверка карточек и дат мероприятий");
        new EventsCatalog(driver)
                .checkVisibleEvents()
                .checkActualDate();
    }

    @Test
    public void checkSortEvents() {
        log.info("Главная страница");
        new MainPage(driver)
                .open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new moveHeader(driver)
                .moveToHeader(LEARN);
        log.info("Календарь мероприятий");
        headerSubMenuPopup.popupBeVisible(LEARN)
                .clickSubMenu(lessonCal, EVENTS_CALENDAR);
        log.info("Фильтр вебинаров");
        new EventsCatalog(driver)
                .sortEvents(OPENWEB);
        log.info("Проверка отображения открытых вебинаров");
        new EventsPage(driver)
                .sortByEvent(OPENWEB);

    }
}

