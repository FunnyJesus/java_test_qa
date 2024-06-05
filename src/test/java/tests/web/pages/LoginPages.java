package tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;

import static com.codeborne.selenide.Selenide.$;

public class LoginPages {
    public static final SelenideElement login = $("#user-name");
    public static final SelenideElement password = $("#password");
    public static final SelenideElement buttonLogin = $("#login-button");
    @Description("Authorization")
    public BasePage loginInPage(String Username, String Password) {
        login
                .shouldBe(Condition.enabled)
                .setValue(Username);
        password
                .shouldBe(Condition.enabled)
                .setValue(Password);
        buttonLogin
                .shouldBe(Condition.visible)
                .click();
        return new BasePage();
    }
}
