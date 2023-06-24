package pages;

import utils.BackToMainDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    //Логотип
    private final By btnLogo = By.className("AppHeader_header__logo__2D0X2");
    //Раздел "Конструктор"
    private final By btnConstructor = By.xpath(".//p[text()='Конструктор']");
    //Заголовок "Соберите бургер"
    private final By headerCreateBurger = By.xpath(".//h1[text()='Соберите бургер']");
    //Кнопка "Войти в аккаунт"
    private final By btnLogin = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Булки"
    private final By btnBuns = By.xpath(".//span[text()='Булки']");
    //Кнопка Булки выбрана
    private final By btnBunsIsCurrent = By.xpath(".//div[(contains(span/text(),'Булки')) and (contains(@class, 'tab_tab_type_current__2BEPc'))]");
    //Кнопка "Соусы"
    private final By btnSauces = By.xpath(".//span[text()='Соусы']");
    //Кнопка "Соусы" выбрана
    private final By btnSaucesIsCurrent = By.xpath(".//div[(contains(span/text(),'Соусы')) and (contains(@class, 'tab_tab_type_current__2BEPc'))]");
    //Кнопка "Начинки"
    private final By btnFillings = By.xpath(".//span[text()='Начинки']");
    //Кнопка "Начинки" выбрана
    private final By btnFillingsIsCurrent = By.xpath(".//div[(contains(span/text(),'Начинки')) and (contains(@class, 'tab_tab_type_current__2BEPc'))]");
    //Кнопка "Личный кабинет"
    private final By btnProfile = By.xpath(".//p[text()='Личный Кабинет']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoButton() {
        driver.findElement(btnLogo).click();
    }

    public void clickConstructorButton() {
        driver.findElement(btnConstructor).click();
    }

    public void clickLoginButton() {
        driver.findElement(btnLogin).click();
    }

    public void clickBunsButton() {
        driver.findElement(btnBuns).click();
    }

    public void clickSaucesButton() {
        driver.findElement(btnSauces).click();
    }

    public void clickFillingsButton() {
        driver.findElement(btnFillings).click();
    }

    public String getCreateBurgerTextFromHeader() {
        return driver.findElement(headerCreateBurger).getText();
    }

    public boolean btnBunsIsEnabled() {
        return driver.findElement(btnBunsIsCurrent).isEnabled();
    }
    public boolean btnSaucesIsEnabled() {
     return driver.findElement(btnSaucesIsCurrent).isEnabled();
    }

    public boolean btnFillingsIsEnabled() {
        return driver.findElement(btnFillingsIsCurrent).isEnabled();
    }

    public void clickProfileButton() {
        driver.findElement(btnProfile).click();
    }

    public void backToMainPage(String button) {
        if(button.equals(BackToMainDetails.LOGO_BACK_TO_MAIN_PAGE)){
            clickLogoButton();
        }else{
            clickConstructorButton();
        }
    }
}
