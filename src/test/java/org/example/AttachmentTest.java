package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentTest {

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide());

        step("Открываем главную страницу", context -> {
            open("https://github.com/eroshenkoam/allure-example");
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    public void testAnnotatedAttachments() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();
    }

//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browser = "firefox";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 5000;
//    }
//
//    @AfterAll
//    static void afterAll() {
//        closeWebDriver();
//    }
}
