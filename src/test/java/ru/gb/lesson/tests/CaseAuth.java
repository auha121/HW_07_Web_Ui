package ru.gb.lesson.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.BaseTest;
import ru.gb.lesson.pages.LoginPage;
import ru.gb.lesson.pages.MainPage;

@DisplayName("Авторизация")
public class CaseAuth extends BaseTest {

    @Test
    @DisplayName("Авторизация - позитивный")
    @Severity(SeverityLevel.BLOCKER)
    void successfulAuthTest() {

        webDriver.get(URL);
        webDriver.manage().window().maximize();

        new MainPage(webDriver)
                .clickLoginButton()
                .login(login, password)
                .clickBannerButton()
                .checkLogoutButtonIsVisible();
    }

    @Test
    @DisplayName("Авторизация: некорректный логин - негативный")
    @Severity(SeverityLevel.NORMAL)
    void incorrectLoginFailedAuthTest() {

        webDriver.get(URL);
        webDriver.manage().window().maximize();

        new MainPage(webDriver)
                .clickLoginButton()
                .login("9999999999", password);
        new LoginPage(webDriver)
                .checkTextIncorrectIsVisible("Пользователь с таким логином и паролем не найден.");
    }
}
