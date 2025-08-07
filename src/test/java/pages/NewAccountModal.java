package pages;

import dto.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.*;

import static wrappers.InputHelper.write;

public class NewAccountModal extends BasePage{

    private final By SAVE_BUTTON = By.xpath("//button[normalize-space(text())='Save' and @name='SaveEdit']");
    private final By ACCOUNT_CREATE_ALLERT = By.xpath("//span[contains(@class, 'toastMessage') and contains(text(), 'Account')]");
    private final By MODAL_TITLE = By.xpath(("(//div[contains(@class, 'slds-modal')]//h2[normalize-space(text())='New Account'])[1]"));

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие модального окна для создания аккаунта")
    public NewAccountModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        return this;
    }
    @Override
    @Step("Проверка открытия модального окна по показу элемента на нем")
    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_TITLE));
        return this;
    }

    @Step("Заполнение полей модального окна для создания аккаунта")
    public NewAccountModal createAccount(Account account) {
        new Picklist("Rating", driver).selectDropdown(account.getRating());
        new Input("Account Name", driver).write(account.getName());
        new Input("Phone", driver).write(account.getPhone());
        new Input("Fax", driver).write(account.getFax());
        new Input("Account Number", driver).write(account.getNumber());
        new Input("Website", driver).write(account.getWebsite());
        new Input("Account Site", driver).write(account.getSite());
        new Input("Ticker Symbol", driver).write(account.getSymbol());
        new Picklist("Type", driver).selectDropdown(account.getType());
        new Picklist("Ownership", driver).selectDropdown(account.getOwnership());
        new Picklist("Industry", driver).selectDropdown(account.getIndustry());
        new Input("Employees", driver).write(account.getEmployees());
        new Input("Annual Revenue", driver).write(account.getRevenue());
        new Input("SIC Code", driver).write(account.getCode());
        new Checkbox("VIP Client", driver).chooseCheckbox(account.getClient());
        new Checkbox("TeachMeSkills", driver).chooseCheckbox(account.getSkills());
        new Textarea("Billing Street", driver).writeTextarea(account.getStreet());
        new Textarea("Shipping Street", driver).writeTextarea(account.getShipping());
        return this;
    }

    @Step("Нажатие на кнопку Сохранить новый аккаунт")
    public NewAccountModal saveNewAccount() {
        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    @Step("Проверка появления поп-ап окна о создании нового аккаунта")
    public void checkNewAccountWasCreate() {
        String alertText = driver.findElement(ACCOUNT_CREATE_ALLERT).getText();
        String cleanedText = alertText.replaceAll("[^a-zA-Z ]", "").trim();
        Assert.assertTrue(
                cleanedText.contains("Account ") && alertText.contains(" was created")
        );
    }
}