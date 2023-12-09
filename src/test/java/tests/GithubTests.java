package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class GithubTests extends TestBase {

    private static final String REPOSITORY = "/selenide/selenide";
    private static final String ISSUE_NAME = "Add Selenide browser.";

    @Test
    @DisplayName("Тест на чистом selenide.")
    void checkIssueNameTest() {
        open(REPOSITORY);
        $("#issues-tab").click();
        $(byText(ISSUE_NAME)).should(Condition.exist);
    }

    @Test
    @DisplayName("Тест с использованием лямбда шагов")
    void checkIssueNameWithLambdaTest() {
        step("Открыть репозиторий", ()->
                open(REPOSITORY)
        );
        step("Открыть таб Issues", ()->
                $("#issues-tab").click()
        );
        step("Проверить наличие нужного issue", ()->
                $(byText(ISSUE_NAME)).should(Condition.exist)
        );
    }

    @Test
    @DisplayName("Тест с использованием аннотации @Step")
    void checkIssueNameWithStepAnnotationTest() {
        WebSteps steps = new WebSteps();

        steps.openRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIssueExist(ISSUE_NAME);
    }
}
