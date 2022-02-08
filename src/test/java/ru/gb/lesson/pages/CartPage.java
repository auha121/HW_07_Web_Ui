package ru.gb.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Проверить что товар в корзину добавлен")
    public CartPage checkProductInCart(String productName, String productNumber) {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='order-total-title__text']//b[contains(text(),'1 товар')]")));

        assertThat(webDriver.findElement(By.xpath("//div[@class='order-product__name']//a[@href='/product/" + productNumber + "/']")).getText())
                .as("Название продукта в корзине должно быть " + productName)
                .isEqualTo(productName);
        return this;
    }
}