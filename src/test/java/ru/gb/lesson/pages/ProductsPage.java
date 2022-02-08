package ru.gb.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Выбрать товар для добавления в корзину")
    public CardProductPage selectProductInCart() {
        webDriver.findElement(By.xpath("//span[@data-id='236593']")).click();
        return new CardProductPage(webDriver);
    }
}
