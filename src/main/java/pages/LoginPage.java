package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage {

    WebDriver driver;

    //Заголовок "Вход"
    private final By headerLogin = By.xpath(".//h2[text()='Вход']");
    //Поле "Email"
    private final By inputEmail = By.xpath(".//label[text()='Email']/../input");
    //Поле "Пароль"
    private final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");
    //Кнопка "Войти"
    private final By btnLogin = By.xpath(".//button[text()='Войти']");
    //Кнопка "Восстановить пароль"
    private final By textResetPassword = By.xpath(".//a[text()='Восстановить пароль']");
    //Кнопка "Личный кабинет"
    private final By btnProfile = By.xpath(".//p[text()='Личный Кабинет']");

    public  LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginTextFromHeader() {
        return driver.findElement(headerLogin).getText();
    }

    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(btnLogin).click();
    }

    public void clickProfileButton() {
        driver.findElement(btnProfile).click();
    }

    public void loginUser(User user){
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickLoginButton();
        clickProfileButton();
    }
}
