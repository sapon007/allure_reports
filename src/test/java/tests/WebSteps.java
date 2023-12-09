package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открыть репозитой")
    public void openRepository(String repositoryName) {
        open(repositoryName);
    }

    @Step("Открыть таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие нужного issue")
    public void checkIssueExist(String issueName) {
        $(byText(issueName)).should(Condition.exist);
    }
}
