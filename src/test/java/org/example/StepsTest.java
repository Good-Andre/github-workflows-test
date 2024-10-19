package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest {
//    private static final String REPOSITORY = "";
    private static final int ISSUE = 80;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide());

        step("Открываем главную страницу", context -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        // step("Ищем репозиторий", context -> {});
        // step("Кликаем по ссылке репозитория", context -> {});
        step("Открываем таб Issues", context -> {
            $("#issues-tab").click();
//            sleep(1000);
        });
        step("Проверяем наличие Issues с номером " + ISSUE, context -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
//            $(withText("#8000" + ISSUE)).should(Condition.exist);
//            sleep(2000);
        });
    }

    // Этот подход на новых проектах
    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
//        steps.searchForRepository(REPOSITORY);
//        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }

//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browser = "firefox";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 5000; // default 4000
//    }
//
//    @AfterAll
//    static void afterAll() {
//        closeWebDriver();
//    }
}
