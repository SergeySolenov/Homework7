package component;

import data.Month;
import data.EventsSortData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.AbsBasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EventsCatalog extends AbsBasePage {
    public EventsCatalog(WebDriver driver) {
        super(driver, "/");
    }

    @FindBy(css = ".dod_new-events__list.js-dod_new_events a")
    private List<WebElement> eventsListLoc;

    @FindBy(css = ".dod_new-event__time")
    private List<WebElement> eventsDateListLoc;

    @FindBy(css = ".dod_new-events-dropdown__input")
    private WebElement sortEventsCloseLoc;
    private final String sortEventsOpenLoc = "div[class*='dod_new-events-dropdown_opened'] a[title='%s']";

    public EventsCatalog checkVisibleEvents() {

        for (WebElement element : eventsListLoc) {
            Assertions.assertTrue(element.isDisplayed());
        }

        return this;
    }

    public EventsCatalog checkActualDate() {

        List<String> eventsDateListString = new ArrayList<>();
        List<LocalDate> eventsDateListDate = new ArrayList<>();
        for (WebElement element : eventsDateListLoc) {
            eventsDateListString.add(element.getText());
        }
        for (String string : eventsDateListString) {
            String date = string.split(" ")[0] + " ";
            String month = string.split(" ")[1];
            date += month.replaceAll("[а-я]+", Month.getDateData(month).getId()) + " " + "2023";
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d MM yyyy", Locale.ROOT));
            if (string.equals("Сейчас в эфире")) {
                eventsDateListDate.add(LocalDate.now());
            } else {
                eventsDateListDate.add(localDate);
            }
        }
        for (LocalDate localDate : eventsDateListDate) {
            Assertions.assertTrue(localDate
                    .isAfter(LocalDate.now()) || localDate.isEqual(LocalDate.now()));
        }
        return this;
    }


    public void sortEvents(EventsSortData eventsSortData) {

        sortEventsCloseLoc.click();
        String locator = String.format(sortEventsOpenLoc, eventsSortData.getNameFilter());
        $(By.cssSelector(locator)).click();
    }
}
