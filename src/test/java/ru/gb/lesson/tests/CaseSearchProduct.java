package ru.gb.lesson.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.BaseTest;
import ru.gb.lesson.pages.MainPage;

@DisplayName("Поиск товара и добавление в корзину")
public class CaseSearchProduct extends BaseTest {

    @Test
    @DisplayName("Поиск и добавление в корзину товара")
    @Severity(SeverityLevel.BLOCKER)
    void successfulChangeCity(){

        webDriver.get(URL);
        webDriver.manage().window().maximize();

        new MainPage(webDriver)
                .inputQuery()
                .searchQuery()
                .selectProductInCartInSearchPage()
                .putProductInCart()
                .goToCart()
                .checkProductInCart("Нож для фруктов, 19 см", "5021333");
    }
}
