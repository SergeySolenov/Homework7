package component;

import data.menu.HeaderMenu;
import data.menu.ISubMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public class HeaderPopup extends AbsPageObject {
    public HeaderPopup(WebDriver driver) {
        super(driver);
    }

    private final String headerSubmenuPopupSel = "[title='%s']";
    private final String subMenuItemLoc = "//a[contains(@href,'%s') and contains(text(),'%s')]";

    public HeaderPopup popupBeVisible(HeaderMenu headerMenu) {

        String selector = String.format(headerSubmenuPopupSel, headerMenu.getName());
        webDriverWait.waitForAttributeNotContains($(By.cssSelector(selector)), "style", "none");
        return this;
    }

    public void clickSubMenu(ISubMenu subMenuItemData, ISubMenu menuCategory) {

        String locator = String.format(subMenuItemLoc, subMenuItemData.getName(), menuCategory.getName());
        $(By.xpath(locator)).click();
    }
}
