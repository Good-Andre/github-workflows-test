package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/eroshenkoam/allure-example");
    }

//    @Step
//    public void searchForRepository(String repo) {}

//    @Step
//    public void clickOnRepositoryLink(String repo) {}

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
//        sleep(1000);
    }

    @Step("Проверяем наличие Issues с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
//            $(withText("#8000" + issue)).should(Condition.exist);
//        sleep(2000);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
