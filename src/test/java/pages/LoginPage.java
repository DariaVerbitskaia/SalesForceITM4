package pages;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {


        private final By LOGIN_FIELD = By.id("username");
        private final By PASSWORD_FIELD = By.id("password");
        private final By LOGIN_BUTTON = By.id("Login");


        public LoginPage(WebDriver driver) {
            super(driver);
        }


        @Step("Открытие страницы логина")
        @Override
        public LoginPage open() {
            log.info("Open Login Page");
            driver.get(BASE_URL);
            return this;
        }

        @Override
        @Step("Открытие страницы логина")
        public LoginPage isPageOpened() {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FIELD));
            } catch (TimeoutException e) {
                log.error(e.getMessage());
                Assert.fail("Page isn't open");
            }
            return this;
        }

        @Step("Вход в систему с именем пользователя: {user} и паролем {password}")
        public LoginPage login(String user, String password) {
            log.info("Log in with credential: {}, {} ", user, password);
            driver.findElement(LOGIN_FIELD).sendKeys(user);
            driver.findElement(PASSWORD_FIELD).sendKeys(password);
            driver.findElement(LOGIN_BUTTON).click();
            return new LoginPage(driver);
        }
    }