package component;

import data.menu.HeaderMenu;
import data.menu.IMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;


public class HeaderPopup extends AbsPageObject {
    public HeaderPopup(WebDriver driver) {
        super(driver);
    }
    private String testing = "/categories/testing";
    private String lessonCalendar = "/events/near";
    private final String headerSubmenuPopupSel = "[title='%s']";
    private final String subMenuItemLoc = "//a[contains(@href,'%s') and contains(text(),'%s')]";
    private final String subMenuItemLoc2 = "//a[contains(@href,'%s') and contains(text(),'%s')]";

    public HeaderPopup popupBeVisible(HeaderMenu headerMenu) {

        String selector = String.format(headerSubmenuPopupSel, headerMenu.getName());
        webDriverWait.waitForAttributeNotContains($(By.cssSelector(selector)), "style", "none");
        return this;
    }

    public void clickSubMenu(IMenu subMenuItemData, IMenu menuCategory) {

        String locator = String.format(subMenuItemLoc, subMenuItemData.getName(), menuCategory.getName());
        $(By.xpath(locator)).click();
    }
    public void clickSubMenu(String subMenuItemData, IMenu menuCategory) {

        String locator = String.format(subMenuItemLoc, subMenuItemData, menuCategory.getName());
        $(By.xpath(locator)).click();
    }
//    public void clickAndCheckSubMenuQA() {
//        popupBeVisible(LEARN);
//        clickSubMenu(testing, TEST);

//        String selector = String.format(headerSubmenuPopupSel, LEARN.getName());
//        webDriverWait.waitForAttributeNotContains($(By.cssSelector(selector)), "style", "none");
//
//        String locator = String.format(subMenuItemLoc, subMenuItemData.getName(), MenuCategory.TEST.getName());
//        $(By.xpath(locator)).click();

}
