package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    //Поле "Имя"
    private final By inputName = By.xpath(".//label[text()='Имя']/../input");
    //Поле "Email"
    private final By inputEmail = By.xpath(".//label[text()='Email']/../input");
    //Поле "Пароль"
    private final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");
    //Кнопка "Зарегистрироваться"
    private final By btnRegister = By.xpath(".//button[text()='Зарегистрироваться']");
    //Ошибка "Некорректный пароль"
    private final By textInvalidPassword = By.xpath(".//p[text()='Некорректный пароль']");
    //Кнопка "Войти" под формой регистрации
    private final By btnLoginUnderReg = By.className("Auth_link__1fOlj");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickRegisterButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(btnRegister));
        driver.findElement(btnRegister).click();
    }

    public String getInvalidPasswordText() {
        return driver.findElement(textInvalidPassword).getText();
    }

    public void clickLoginButtonUnderReg() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(btnLoginUnderReg));
        driver.findElement(btnLoginUnderReg).click();
    }
}
