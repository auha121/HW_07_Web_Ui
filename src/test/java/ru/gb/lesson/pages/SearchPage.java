package ru.gb.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Выбрать товар для добавления в корзину")
    public CardProductPage selectProductInCartInSearchPage() {
        webDriver.findElement(By.xpath("//span[@href='#' and @data-id='573485']")).click();
        return new CardProductPage(webDriver);
    }
}
