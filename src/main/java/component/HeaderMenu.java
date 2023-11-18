package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public class HeaderMenu extends AbsPageObject {

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void moveToHeader(data.menu.HeaderMenu headerMenu) {
        String sel = String.format("[title='%s']", headerMenu.getName());
        actions
                .moveToElement($(By.cssSelector(sel)))
                .build()
                .perform();
    }
}
