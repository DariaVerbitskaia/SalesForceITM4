package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1, description = "Вход на сайт", testName = "Успешная авторизация пользователя", groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Pge")
    @Feature("Login")
    @Story("Login without password")
    @TmsLink("ITM-1")
    @Issue("ITM-1-4")
    @Description("Пользователь совершил успешный вход")
    public void checkUserLogin() {
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password003!");
    }
}