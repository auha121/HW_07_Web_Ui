package ru.gb.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardProductPage extends BasePage {

    public CardProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Добавить товар в корзину")
    public CardProductPage putProductInCart() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Добавить в корзину')]")).click();
        return this;
    }

    @Step("Перейти в корзину товаров")
    public CartPage goToCart() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Перейти в корзину')]")).click();
        return new CartPage(webDriver);
    }
}
