package ru.gb.lesson.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.BaseTest;
import ru.gb.lesson.pages.MainPage;

@DisplayName("Добавление товара в корзине")
public class CaseSelectProductInCart extends BaseTest {

    @Test
    @DisplayName("Товар в корзине - позитивный")
    @Severity(SeverityLevel.BLOCKER)
    void successfulAddProduct() {

        webDriver.get(URL);
        webDriver.manage().window().maximize();

        new MainPage(webDriver)
                .goToProductPage()
                .selectProductInCart()
                .putProductInCart()
                .goToCart()
                .checkProductInCart("Ящик хозяйственный, 18 л", "5069297");
    }
}
