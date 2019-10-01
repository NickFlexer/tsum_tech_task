package tsum.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import tsum.pages.ForgotPasswordPage;
import tsum.pages.LoginPage;
import tsum.pages.TsumMainPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthorizationSteps extends ScenarioSteps {

    private TsumMainPage mainPage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Step
    public void authorizeUser(String userEmail, String userPassword) {
        mainPage.goToLoginPage();
        loginPage.authorizeUser(userEmail, userPassword);
    }

    @Step
    public void goToForgotPassword() {
        mainPage.goToLoginPage();
        loginPage.forgotPassword();
    }

    @Step
    public void restorePassword(String userEmail) {
        forgotPasswordPage.passwordRestore(userEmail);
    }

    @Step
    public void goBackToLoginPage() {
        forgotPasswordPage.backToRegistration();
    }
}
