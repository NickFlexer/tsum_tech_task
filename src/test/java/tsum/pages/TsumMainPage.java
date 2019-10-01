package tsum.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.tsum.ru")
public class TsumMainPage extends PageObject {

    @FindBy(xpath = "//a[@class='header__link ng-star-inserted']")
    WebElementFacade personalArea;

    @FindBy(xpath = "//div[@class='notice error']")
    WebElementFacade noticeError;

    public void goToLoginPage() {
        personalArea.click();
    }

    public boolean isNoticeErrors() {
        return noticeError.isPresent();
    }

    public String getErrorMessage() {
        return noticeError.getText();
    }
}
