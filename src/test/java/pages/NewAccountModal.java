package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import wrappers.*;

import static wrappers.InputHelper.write;

public class NewAccountModal extends BasePage{

    private final By SAVE_BUTTON = By.xpath("//button[normalize-space(text())='Save' and @name='SaveEdit']");
    private final By ACCOUNT_CREATE_ALLERT = By.xpath("//span[contains(@class, 'toastMessage') and contains(text(), 'Account')]");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void createAccount(String rating, String name,String phone, String fax, String number, String website, String site, String symbol, String type, String ownership, String industry, String employees, String revenue, String code, String client, String skills, String street, String shipping) {
        new Picklist("Rating", driver).selectDropdown(rating);
        new Input("Account Name", driver).write(name);
        new Input("Phone", driver).write(phone);
        new Input("Fax", driver).write(fax);
        new Input("Account Number", driver).write(number);
        new Input("Website", driver).write(website);
        new Input("Account Site", driver).write(site);
        new Input("Ticker Symbol", driver).write(symbol);
        new Picklist("Type", driver).selectDropdown(type);
        new Picklist("Ownership", driver).selectDropdown(ownership);
        new Picklist("Industry", driver).selectDropdown(industry);
        new Input("Employees", driver).write(employees);
        new Input("Annual Revenue", driver).write(revenue);
        new Input("SIC Code", driver).write(code);
        new Checkbox("VIP Client", driver).chooseCheckbox(client);
        new Checkbox("TeachMeSkills", driver).chooseCheckbox(skills);
        new Textarea("Billing Street", driver).writeTextarea(street);
        new Textarea("Shipping Street", driver).writeTextarea(shipping);
    }

    public void saveNewAccount() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void checkNewAccountWasCreate() {
        String alertText = driver.findElement(ACCOUNT_CREATE_ALLERT).getText();
        String cleanedText = alertText.replaceAll("[^a-zA-Z ]", "").trim();
        Assert.assertTrue(
                alertText.contains("Account ") && alertText.contains(" was created")
        );
    }
}