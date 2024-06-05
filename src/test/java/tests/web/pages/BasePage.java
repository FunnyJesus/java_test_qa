package tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    final SelenideElement INVENTORY = $("#inventory_container");
    final SelenideElement BURGER = $("div[class=\"bm-burger-button\"]");

    @Step("Check Inventory")
    @Description("Check Inventory")
    public Boolean checkInventory() {
        return INVENTORY.is(Condition.visible);
    }

    @Step("Open burger")
    public LeftMenu openBurger() {
        BURGER
                .shouldBe(Condition.enabled)
                .click();
        return new LeftMenu();
    }
}
