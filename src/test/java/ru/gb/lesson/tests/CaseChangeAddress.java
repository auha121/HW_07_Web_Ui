package ru.gb.lesson.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson.BaseTest;
import ru.gb.lesson.pages.MainPage;

@DisplayName("Адреса магазинов")
public class CaseChangeAddress extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"г.Онега, пр-т Ленина, д.205-A"})
    @DisplayName("Адреса магазинов")
    @Severity(SeverityLevel.NORMAL)
    void successfulAddressTest(String addressCity) throws InterruptedException {

        webDriver.get(URL);
        webDriver.manage().window().maximize();

        new MainPage(webDriver)
                .goToAddressPage()
                .inputCity(city)
                .searchAddressInCity()
                .checkAddressInCity(addressCity);
    }
}
