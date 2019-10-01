package tsum.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.tsum.ru/password/forgot/")
public class ForgotPasswordPage extends TsumMainPage {

    @FindBy(xpath = "//input[@formcontrolname='email' and @placeholder='Email']")
    WebElementFacade email;

    @FindBy(xpath = "//button[@type='submit' and @theme='black']")
    WebElementFacade sendEmailButton;

    @FindBy(xpath = "//a[contains(@class, 'password__back')]")
    WebElementFacade backToRegistration;

    public void passwordRestore(String userEmail) {
        email.type(userEmail);
        sendEmailButton.click();
    }

    public void backToRegistration() {
        backToRegistration.click();
    }
}
