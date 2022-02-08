package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.gb.lesson.listener.ActionEventListener;

import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.step;

public class BaseTest {

    protected static final String URL = "https://fix-price.ru/";
    protected String login = "9058506715";
    protected String password = "Ss12345678";
    protected String city = "г.Онега";

    protected EventFiringWebDriver webDriver;

    @BeforeEach
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        webDriver = new EventFiringWebDriver(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
        webDriver.register(new ActionEventListener());
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
        step("Отображение логов браузера", () -> {
            for (LogEntry logEntry : webDriver.manage().logs().get(LogType.BROWSER)) {
                Allure.addAttachment("logs", logEntry.getMessage());
            }
        });
        webDriver.quit();
    }
}
