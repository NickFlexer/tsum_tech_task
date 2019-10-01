package tsum.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import tsum.pages.LoginPage;
import tsum.pages.TsumMainPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationSteps extends ScenarioSteps {

    private TsumMainPage mainPage;
    private LoginPage loginPage;

    public void registerNewUser(String userEmail, String userPassword) {
        mainPage.goToLoginPage();
        loginPage.registerNewUser(userEmail, userPassword);
    }
}
