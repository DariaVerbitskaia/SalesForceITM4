package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import wrappers.Checkbox;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewContactModal extends BasePage {

    private final By SAVE_BUTTON = By.xpath("//button[normalize-space(text())='Save' and @name='SaveEdit']");
    private final By CONTACT_CREATE_ALLERT = By.xpath("//span[contains(@class, 'toastMessage') and contains(text(), 'Contact')]");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void createContact(String salutation, String phone, String homephone, String firstname, String lastname, String mobile, String title, String otherphone, String leadsource, String department, String fax, String email, String assistant, String asstphone, String mailingstreet, String otherstreet) {
        new Picklist("Salutation", driver).selectDropdown(salutation);
        new Input("Phone", driver).write(phone);
        new Input("Home Phone", driver).write(homephone);
        new Input("First Name", driver).write(firstname);
        new Input("Last Name", driver).write(lastname);
        new Input("Mobile", driver).write(mobile);
        new Input("Title", driver).write(title);
        new Input("Other Phone", driver).write(otherphone);
        new Picklist("Lead Source", driver).selectDropdown(leadsource);
        new Input("Department", driver).write(department);
        new Input("Fax", driver).write(fax);
        new Input("Email", driver).write(email);
        new Input("Assistant", driver).write(assistant);
        new Input("Asst. Phone", driver).write(asstphone);
        new Textarea("Mailing Street", driver).writeTextarea(mailingstreet);
        new Textarea("Other Street", driver).writeTextarea(otherstreet);
    }

    public void saveNewContact() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void checkNewContactWasCreate() {
        String alertText = driver.findElement(CONTACT_CREATE_ALLERT).getText();
        String cleanedText = alertText.replaceAll("[^a-zA-Z ]", "").trim();
        Assert.assertTrue(
                cleanedText.contains("Contact ") && alertText.contains(" was created.")
        );
    }
}
