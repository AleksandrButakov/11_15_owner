package ru.anbn.owner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.anbn.owner.config.Project;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LoginPage extends TestBase {

/*
Конфигурация WEB тестов
1 Для локального запуска на chrome: gradle clean test -Dproperties=local
2 Для удаленного запуска на selenoid: gradle clean test -Dproperties=remote
 */

    @Test
    @DisplayName("Loading the GitHub page")
    void checkLoginFormHeader() {
        step("Open url 'https://github.com'", () ->
                open(baseUrl));
        System.out.println(Project.projectConfig.browser());
        System.out.println(Project.projectConfig.browserVersion());
        System.out.println(Project.projectConfig.browserSize());
        System.out.println(Project.projectConfig.webUrl());

        step("Check form header -> should be 'Log In'", () -> {
            $(".h1-mktg").shouldHave(text(" Where the world builds software "));
        });
    }

}