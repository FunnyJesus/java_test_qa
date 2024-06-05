package tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class LeftMenu {
    final SelenideElement MENU = $("nav[class=\"bm-item-list\"]");

    @Step("Get list options")
    public String getOptionsMenu() {
        return String.valueOf(MENU.$$(By.tagName("a")).texts());
    }




}
