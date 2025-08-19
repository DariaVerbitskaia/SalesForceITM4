package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.*;

@Log4j2
public class NewAccountModal extends BasePage{

    private final By SAVE_BUTTON = By.xpath("//button[normalize-space(text())='Save' and @name='SaveEdit']");
    private final By ACCOUNT_CREATE_ALLERT = By.xpath("//span[contains(@class, 'toastMessage') and contains(text(), 'Account')]");
    private final By MODAL_TITLE = By.xpath(("(//div[contains(@class, 'slds-modal')]//h2[normalize-space(text())='New Account'])[1]"));

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие модального окна для создания аккаунта")
    public NewAccountModal open() {
        log.info("Open NewAccountModal");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        return this;
    }
    @Override
    @Step("Проверка открытия модального окна по показу элемента на нем")
    public NewAccountModal isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_TITLE));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't open");
        }
        return this;
    }

    @Step("Заполнение полей модального окна для создания аккаунта")
    public NewAccountModal createAccount(Account account) {
        new Picklist("Rating", driver).selectDropdown(account.getRating());
        log.info("Dropdown value selected in Rating");
        new Input("Account Name", driver).write(account.getName());
        log.info("Value set in Account Name");
        new Input("Phone", driver).write(account.getPhone());
        log.info("Value set in Phone");
        new Input("Fax", driver).write(account.getFax());
        log.info("Value set in Fax");
        new Input("Account Number", driver).write(account.getNumber());
        log.info("Value set in Account Number");
        new Input("Website", driver).write(account.getWebsite());
        log.info("Value set in Website");
        new Input("Account Site", driver).write(account.getSite());
        log.info("Value set in Account Site");
        new Input("Ticker Symbol", driver).write(account.getSymbol());
        log.info("Value set in Ticker Symbol");
        new Picklist("Type", driver).selectDropdown(account.getType());
        log.info("Dropdown Value selected in Type");
        new Picklist("Ownership", driver).selectDropdown(account.getOwnership());
        log.info("Dropdown Value selected in Ownership");
        new Picklist("Industry", driver).selectDropdown(account.getIndustry());
        log.info("Dropdown Value selected in Industry");
        new Input("Employees", driver).write(account.getEmployees());
        log.info("Value set in Employees");
        new Input("Annual Revenue", driver).write(account.getRevenue());
        log.info("Value set in Annual Revenue");
        new Input("SIC Code", driver).write(account.getCode());
        log.info("Value set in SIC Code");
        new Checkbox("VIP Client", driver).chooseCheckbox(account.getClient());
        log.info("Checkbox value selected in VIP Client");
        new Checkbox("TeachMeSkills", driver).chooseCheckbox(account.getSkills());
        log.info("Checkbox value selected in TeachMeSkills");
        new Textarea("Billing Street", driver).writeTextarea(account.getStreet());
        log.info("Value set in Billing Street");
        new Textarea("Shipping Street", driver).writeTextarea(account.getShipping());
        log.info("Value set in Shipping Street");
        return this;
    }

    @Step("Нажатие на кнопку Сохранить новый аккаунт")
    public NewAccountModal saveNewAccount() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("Save button was clicked");
        return this;
    }

    @Step("Проверка появления поп-ап окна о создании нового аккаунта")
    public void checkNewAccountWasCreate() {
        String alertText = driver.findElement(ACCOUNT_CREATE_ALLERT).getText();
        log.info("Raw alert text: '{}'", alertText);
        String cleanedText = alertText.replaceAll("[^a-zA-Z ]", "").trim();
        log.info("Cleaned alert text (for assertion): '{}'", cleanedText);
        Assert.assertTrue(
                cleanedText.contains(" Account ") && alertText.contains(" was created ")
        );
    }
}