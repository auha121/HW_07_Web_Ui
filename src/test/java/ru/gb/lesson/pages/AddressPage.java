package ru.gb.lesson.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressPage extends BasePage{

    public AddressPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Ввести город в поле поиска")
    public AddressPage inputCity(String city) throws InterruptedException {
        webDriver.findElement(By.xpath("//form[@id='search-location']//input[@placeholder='Поиск']")).sendKeys(city);
        Thread.sleep(1000);
        return this;
    }

    @Step("Кликнуть на кнопку Поиск")
    public AddressPage searchAddressInCity() {
        webDriver.findElement(By.xpath("//form[@id='search-location']//button[@class='search-form__submit']")).click();
        return this;
    }

    @Step("Проверить что запрашиваемый адрес для данного города найден")
    public AddressPage checkAddressInCity(String addressCity) throws InterruptedException {
        Thread.sleep(1000);
        /*assertThat(webDriver.findElement(By.xpath("//div[@class='shops-table-item__address']")).getText())
                .as("Адрес магазина должен быть " + addressCity)
                .isEqualTo(addressCity);*/


        List<String> actualAddress = webDriver.findElements(By.xpath("//div[contains(@class, 'shops-table__row')]"))
                .stream()
                .map(el -> el.findElement(By.xpath(".//div[@class='shops-table-item__address']")).getText())
                .collect(Collectors.toList());

        assertThat(actualAddress)
                .as("Адрес магазина должен быть " + addressCity)
                .containsExactlyInAnyOrder(addressCity);


        /*List<WebElement> actualAddress = webDriver.findElements(By.xpath("//div[contains(@class, 'shops-table__row')]"));

        assertThat(actualAddress).hasSize(1);
        assertThat(actualAddress.get(0).findElement(By.xpath(".//div[@class='shops-table-item__address']")).getText())
                .as("Адрес магазина должен быть " + addressCity)
                .isEqualTo(addressCity);*/


        return this;
    }
}
