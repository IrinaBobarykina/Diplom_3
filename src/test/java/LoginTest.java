import config.AppConfig;
import config.BaseURI;
import config.WebDriverConfig;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import user.User;
import user.UserOperations;
import utils.Generator;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;
    User user;

    @Before
    public void setup() {
        RestAssured.baseURI = BaseURI.BASE_URI;
        user = Generator.generateUser();
        UserOperations.createUser(user);

        driver = WebDriverConfig.setDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_SEC_TIMEOUT, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Login from the main page")
    public void loginOnMainPageGetSuccess() {
        driver.navigate().to(AppConfig.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickLoginButton();
        loginPage.loginUser(user);

        Assert.assertTrue(profilePage.btnProfileTabIsEnabled());
    }

    @Test
    @DisplayName("Login from the profile")
    public void loginWithProfileGetSuccess() {
        driver.navigate().to(AppConfig.MAIN_PAGE_URL);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.clickProfileButton();
        loginPage.loginUser(user);

        Assert.assertTrue(profilePage.btnProfileTabIsEnabled());
    }

    @Test
    @DisplayName("Login from the register page")
    public void loginWithRegisterPageGetSuccess() {
        driver.navigate().to(AppConfig.REGISTER_PAGE_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        registerPage.clickLoginButtonUnderReg();
        loginPage.loginUser(user);

        Assert.assertTrue(profilePage.btnProfileTabIsEnabled());
    }

    @Test
    @DisplayName("Login from the reset password page")
    public void loginWithResetPasswordPageGetSuccess() {
        driver.navigate().to(AppConfig.RESET_PASSWORD_PAGE_URL);
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        resetPasswordPage.clickLoginButtonUnderResetting();
        loginPage.loginUser(user);

        Assert.assertTrue(profilePage.btnProfileTabIsEnabled());
    }

    @After
    public void teardown() {
        UserOperations.deleteUser(UserOperations.getAccessToken(user));
        driver.quit();
    }
}
