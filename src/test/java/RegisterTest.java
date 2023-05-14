import config.AppConfig;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import pages.ProfilePage;
import user.User;
import user.UserOperations;
import utils.Generator;
import config.WebDriverConfig;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterTest {
    private WebDriver driver;
    User user;

    @Before
    public void setup() {
        user = Generator.generateUser();

        driver = WebDriverConfig.setDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_SEC_TIMEOUT, TimeUnit.SECONDS);
        driver.navigate().to(AppConfig.REGISTER_PAGE_URL);
    }

    @Test
    @DisplayName("Register a new user with a short password")
    public void registerNewUserWithShortPasswordGetError() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.setName(user.getName());
        registerPage.setEmail(user.getEmail());
        registerPage.setPassword(Generator.generateWrongUserPassword());
        registerPage.clickRegisterButton();

        MatcherAssert.assertThat(registerPage.getInvalidPasswordText(), equalTo("Некорректный пароль"));
    }

    @Test
    @DisplayName("Register a new user with valid creds")
    public void registerNewUserGetSuccess() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        registerPage.setName(user.getName());
        registerPage.setEmail(user.getEmail());
        registerPage.setPassword(user.getPassword());
        registerPage.clickRegisterButton();

        MatcherAssert.assertThat(loginPage.getLoginTextFromHeader(), equalTo("Вход"));
        loginPage.loginUser(user);
        Assert.assertTrue(profilePage.btnProfileTabIsEnabled());

    }

    @After
    public void teardown() {
        UserOperations.deleteUser(UserOperations.getAccessToken(user));
        driver.quit();
    }
}
