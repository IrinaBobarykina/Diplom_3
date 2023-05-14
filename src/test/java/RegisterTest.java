package register;

import config.AppConfig;
import config.Generator;
import config.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_SEC_TIMEOUT, TimeUnit.SECONDS);
        driver.navigate().to(AppConfig.REGISTER_PAGE_URL);
    }

    @Test
    public void registerNewUserGetSuccess() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        registerPage.setName(Generator.generateUserName());
        registerPage.setEmail(Generator.generateUserEmail());
        registerPage.setPassword(Generator.generateUserPassword());
        registerPage.clickRegisterButton();

        System.out.println(loginPage.getTextFromHeader());
        MatcherAssert.assertThat(loginPage.getTextFromHeader(), equalTo("Вход"));
    }

    @Test
    public void registerNewUserWithShortPasswordGetError() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.setName(Generator.generateUserName());
        registerPage.setEmail(Generator.generateUserEmail());
        registerPage.setPassword(Generator.generateWrongUserPassword());
        registerPage.clickRegisterButton();

        MatcherAssert.assertThat(registerPage.getInvalidPasswordText(), equalTo("Некорректный пароль"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
