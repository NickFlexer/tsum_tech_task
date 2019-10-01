package tsum.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tsum.steps.AuthorizationSteps;
import tsum.steps.CommonSteps;
import tsum.steps.RegistrationSteps;
import tsum.utils.ConfigProperties;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class AuthorizationTests {

    @Managed
    private WebDriver driver;

    @Steps
    private CommonSteps commonSteps;
    @Steps
    private AuthorizationSteps authorization;
    @Steps
    private RegistrationSteps registration;

    @Test
    public void successfulRegistration() {
        commonSteps.openMainPage();
        authorization.authorizeUser(ConfigProperties.getProperty("email"), ConfigProperties.getProperty("password"));
        commonSteps.checkNoErrors();
    }

    @Test
    public void restorePassword() {
        commonSteps.openMainPage();
        authorization.goToForgotPassword();

        authorization.restorePassword(ConfigProperties.getProperty("email"));
        commonSteps.checkNoErrors();

        authorization.goBackToLoginPage();
    }

    @Test
    public void incorrectEmailRegistration() {
        commonSteps.openMainPage();
        registration.registerNewUser("incorrect@mail.", "qwerty123");

        commonSteps.checkErrorMessage("Указан некорректный email");
    }

    @Test
    public void incorrectPasswordRegistration() {
        commonSteps.openMainPage();
        registration.registerNewUser(ConfigProperties.getProperty("email"), "1");

        commonSteps.checkErrorMessage("Пароль должен быть не менее 8 символов длиной");
    }
}
