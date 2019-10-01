package tsum.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.tsum.ru/login/")
public class LoginPage extends TsumMainPage {

    @FindBy(xpath = "//p[contains(@class,'auth-layout__control-button first')]")
    WebElementFacade authorization;

    @FindBy(xpath = "//p[contains(@class,'auth-layout__control-button last')]")
    WebElementFacade registration;

    @FindBy(xpath = "//div[@class='input-wrapper']/input[@formcontrolname='email']")
    WebElementFacade email;

    @FindBy(xpath = "//div[@class='input-wrapper']/input[@formcontrolname='password']")
    WebElementFacade password;

    @FindBy(xpath = "//button[@type='submit' and @theme='black']")
    WebElementFacade registerButton;

    @FindBy(xpath = "//div[@class='notice error']")
    WebElementFacade noticeError;

    @FindBy(xpath = "//a[@class='forget-pwd']")
    WebElementFacade forgotButton;

    public void registerNewUser(String userEmail, String password) {
        registration.click();

        email.type(userEmail);
        this.password.type(password);

        registerButton.click();
    }

    public void authorizeUser(String userEmail, String password) {
        authorization.click();

        email.type(userEmail);
        this.password.type(password);

        registerButton.click();
    }

    public void forgotPassword() {
        forgotButton.click();
    }
}
