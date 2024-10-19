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

public class SelenideTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
//        Configuration.pageLoadTimeout = 60000;
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide());

        open("https://github.com/eroshenkoam/allure-example");
        $("#issues-tab").click();
        sleep(1000);
//        $(withText("#80")).should(Condition.exist);
        $(withText("#8000")).should(Condition.exist);
        sleep(2000);
    }
}
