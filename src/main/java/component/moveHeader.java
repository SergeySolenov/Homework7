package component;

import data.menu.HeaderMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public class moveHeader extends AbsPageObject {

    public moveHeader(WebDriver driver) {
        super(driver);
    }

    public void moveToHeader(HeaderMenu headerMenu) {
        String sel = String.format("[title='%s']", headerMenu.getName());
        actions
                .moveToElement($(By.cssSelector(sel)))
                .build()
                .perform();
    }


}
