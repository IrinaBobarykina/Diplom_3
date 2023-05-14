package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    WebDriver driver;

    // Вкладка "Профиль"
    private final By btnProfileTab = By.xpath(".//a[text()='Профиль']");
    //Вкладка "Выход"
    private final By btnExitTab = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean btnProfileTabIsEnabled() {
        return driver.findElement(btnProfileTab).isEnabled();
    }

    public void clickExitButton() {
        driver.findElement(btnExitTab).click();
    }

}
