package pageObject.pages;

import data.EventsSortData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends AbsBasePage {

    public EventsPage(WebDriver driver) {
        super(driver, "/");
    }

    @FindBy(css = ".dod_new-events__list.js-dod_new_events a")
    private List<WebElement> eventsListLoc;

    @FindBy(css = ".dod_new-events__list.js-dod_new_events a .dod_new-type__text")
    private List<WebElement> typeEventsLoc;

    @FindBy(css = ".dod_new-events__empty-message")
    private WebElement emptyLoc;

    public EventsPage sortByEvent(EventsSortData eventsSortData) {

        if (eventsListLoc.size() != 0) {
            for (WebElement element : eventsListLoc) {
                Assertions.assertTrue(element.isDisplayed());
            }
            for (WebElement element : typeEventsLoc) {
                Assertions.assertEquals(eventsSortData.getNamePage(), element.getText());
            }
        } else
            Assertions.assertTrue(emptyLoc.isDisplayed());
        return this;
    }
}