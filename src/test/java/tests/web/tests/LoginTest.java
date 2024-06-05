package tests.web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import tests.web.config.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;


class LoginTest extends BaseTest {

    @Test
    @Owner("Gosling")
    @Description("Validation Inventory menu")
    void test() {
        assertThat(page.checkInventory()).isTrue();
        stepOne();
        stepTwo();
        stepThree();
    }

    @Test
    @Owner("Pityh")
    @Description("Validation Menu left side")
    @Step
    void test2() {
        var options = page.openBurger().getOptionsMenu();
        assertThat(options).isEqualTo("[All Items," +
                " About, Logout, Reset App State]");
    }

    @Step("Step 1")
    void stepOne() {

    }

    @Step("Step 2")
    void stepTwo() {

    }


    @Step("Step 3")
    void stepThree() {

    }


}
