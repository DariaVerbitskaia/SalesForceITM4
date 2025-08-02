package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class LoginPage extends BasePage {


        private final By LOGIN_FIELD = By.id("username");
        private final By PASSWORD_FIELD = By.id("password");
        private final By LOGIN_BUTTON = By.id("Login");


        public LoginPage(WebDriver driver) {
            super(driver);
        }

        @Step("Открытие страницы логина")
        public void open() {
            driver.get(BASE_URL);
        }

        @Step("Вход в систему с именем пользователя: {user} и паролем {password}")
        public void login(String user, String password) {
            driver.findElement(LOGIN_FIELD).sendKeys(user);
            driver.findElement(PASSWORD_FIELD).sendKeys(password);
            driver.findElement(LOGIN_BUTTON).click();
        }
    }