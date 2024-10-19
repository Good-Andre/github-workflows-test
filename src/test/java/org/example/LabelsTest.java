package org.example;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LabelsTest {

    @Test
    @Feature("Feature: Issue в репозитории")
    @Story("Story: Создание Issue")
    @DisplayName("DisplayName: Создание Issue для авторизованного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Owner: Иван")
    @Link(value ="Testing", url = "https://github.com/inTesting/inTesting/issues/new")
    public void testStaticLabels() {
    }

    @Test
    public void testDynamicLabels() {
//        if (true) {
//            Allure.feature("Feature: Issue в репозитории");
//        } else {
//            Allure.feature("Feature: Issue не в репозитории");
//        }
        Allure.feature("Feature: Issue в репозитории");
        Allure.story("Story: Создание Issue");
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("DisplayName: Создание Issue для авторизованного пользователя")
        );
        Allure.label("Owner", "Owner: Иван");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://github.com/inTesting/inTesting/issues/new");
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
