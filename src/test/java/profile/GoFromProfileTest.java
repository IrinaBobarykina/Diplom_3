package profile;

import config.AppConfig;
import config.BackToMainDetails;
import config.Generator;
import config.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;

public class GoFromProfileTest {

    private WebDriver driver;
    private final String button;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_SEC_TIMEOUT, TimeUnit.SECONDS);
        driver.navigate().to(AppConfig.MAIN_PAGE_URL);
    }

    public GoFromProfileTest(String button) {
        this.button = button;
    }

    @Parameterized.Parameters
    public static Object[] orderScooter() {
        return new Object[][]{
                {BackToMainDetails.LOGO_BACK_TO_MAIN_PAGE},
                {BackToMainDetails.CONSTRUCTOR_BACK_TO_MAIN},
        };
    }

    @Test
    public void registerNewUserGetSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();
        mainPage.backToMainPage(button);

        MatcherAssert.assertThat(mainPage.getCreateBurgerTextFromHeader(), equalTo("Соберите бургер"));
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
