import annotation.Driver;
import component.*;
import data.CategoryQA;
import data.CategoryQA_Pro;
import data.EventsSortData;
import data.courses.CoursesDuration;
import data.courses.CoursesFormat;
import data.courses.CoursesSubTitle;
import data.courses.CoursesTitle;
import data.menu.MenuCategory;
import data.menu.SubMenuCategory;
import extensions.UIExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pageObject.pages.CoursePage;
import pageObject.pages.EventsPage;
import pageObject.pages.MainPage;

@ExtendWith(UIExtension.class)
public class LearningCoursesTest {
    private final Logger log = LogManager.getLogger("AutomationFramework");
    @Driver
    public WebDriver driver;

    @Test
    public void checkCountQA() {
        log.info("Главная страница");
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenu(driver)
                .moveToHeader(data.menu.HeaderMenu.LEARN);
        log.info("Раздел QA");
        headerSubMenuPopup.popupBeVisible(data.menu.HeaderMenu.LEARN)
                .clickSubMenu(SubMenuCategory.TESTING, MenuCategory.TEST);
        log.info("Проверка фильтра");
        new CourseFilter(driver)
                .checkFilter(CategoryQA.TESTING, true);
        log.info("Проверка колличества курсов и их отображения");
        new CourseCatalog(driver)
                .checkVisibleCourses()
                .checkCountCourses(10);
    }
    @Test
    public void checkInfoCourses() {
        String titleCourse = "Java QA Engineer. Professional";
        String subTitleCourse = "Прокачайте свои навыки автоматизации тестирования на Java";
        String durationCourse = "4 месяца";
        String formatCourse = "Онлайн";
        log.info("Главная страница");
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenu(driver)
                .moveToHeader(data.menu.HeaderMenu.LEARN);
        log.info("Раздел тестирования");
        headerSubMenuPopup.popupBeVisible(data.menu.HeaderMenu.LEARN)
                .clickSubMenu(SubMenuCategory.TESTING, MenuCategory.TEST);
        log.info("Выбрали PRO курс");
        new CourseCatalog(driver)
                .clickCourse(CategoryQA_Pro.JAVA_QA_PRO.getName());
        log.info("Проверка информации о курсе");
        new CoursePage(driver)
                .checkTitle(titleCourse, CoursesTitle.JAVA_QA_PRO)
                .checkSubTitle(subTitleCourse, CoursesSubTitle.JAVA_QA_PRO)
                .checkDuration(durationCourse, CoursesDuration.JAVA_QA_PRO)
                .checkFormat(formatCourse, CoursesFormat.JAVA_QA_PRO);

    }

    @Test
    public void checkDateOfEvents() {
        log.info("Главная страница");
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenu(driver)
                .moveToHeader(data.menu.HeaderMenu.LEARN);
        log.info("Календарь мероприятий");
        headerSubMenuPopup.popupBeVisible(data.menu.HeaderMenu.LEARN)
                .clickSubMenu(SubMenuCategory.LESSON_CALENDAR, MenuCategory.EVENTS_CALENDAR);
        log.info("Проверка карточек и дат мероприятий");
        new EventsCatalog(driver)
                .checkVisibleEvents()
                .checkActualDate();
    }

    @Test
    public void checkSortEvents() {
        log.info("Главная страница");
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenu(driver)
                .moveToHeader(data.menu.HeaderMenu.LEARN);
        log.info("Календарь мероприятий");
        headerSubMenuPopup.popupBeVisible(data.menu.HeaderMenu.LEARN)
                .clickSubMenu(SubMenuCategory.LESSON_CALENDAR, MenuCategory.EVENTS_CALENDAR);
        log.info("Фильтр вебинаров");
        new EventsCatalog(driver)
                .sortEvents(EventsSortData.OPENWEB);
        log.info("Проверка отображения открытых вебинаров");
        new EventsPage(driver)
                .sortByEvent(EventsSortData.OPENWEB);

    }
}

