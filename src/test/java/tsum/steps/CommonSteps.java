package tsum.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import tsum.pages.TsumMainPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CommonSteps extends ScenarioSteps {

    private TsumMainPage mainPage;

    @Step
    public void openMainPage() {
        mainPage.open();
    }

    @Step
    public void checkNoErrors() {
        assertThat(mainPage.isNoticeErrors()).isFalse();
    }

    public void checkErrorMessage(String message) {
        assertThat(mainPage.getErrorMessage()).contains(message);
    }
}
