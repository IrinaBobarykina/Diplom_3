package config;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {
    public static final long WAIT_SEC_TIMEOUT = 10;

    public static WebDriver setDriver() {
        // Чтобы запустить тесты в Яндекс  - 1) закомменть запуск в Chrome 2) Раскомменть запуск в Yandex

        //Запуск тестов в Chrome Browser
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

        //Запуск тестов в Yandex Browser
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
//        return new ChromeDriver(options);
    }

}
