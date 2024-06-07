package tests.web.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import tests.web.pages.BasePage;
import tests.web.pages.LoginPages;

abstract public class BaseTest {
    public static BasePage page;

    @BeforeEach
    @Description("Start session tests...")
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Configuration.headless = true;
        Selenide.open("https://www.saucedemo.com/");
        page = new LoginPages().loginInPage("standard_user", "secret_sauce");
    }

    @AfterEach
    @Description("Quit session tests...")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
