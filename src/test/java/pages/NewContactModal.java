package pages;

import dto.Contact;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.Checkbox;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewContactModal extends BasePage {

    private final By SAVE_BUTTON = By.xpath("//button[normalize-space(text())='Save' and @name='SaveEdit']");
    private final By CONTACT_CREATE_ALLERT = By.xpath("//span[contains(@class, 'toastMessage') and contains(text(), 'Contact')]");
    private final By PHONE_FIELD = By.xpath("//label[text()='Phone']//ancestor::lightning-input//input");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие модального окна для создания контакта")
    public NewContactModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/new");
        return this;
    }

    @Override
    @Step("Проверка открытия модального окна по показу элемента на нем")
    public NewContactModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_FIELD));
        return this;
    }

    @Step("Заполнение полей модального окна для создания контакта")
    public NewContactModal createContact(Contact contact) {
        new Picklist("Salutation", driver).selectDropdown(contact.getSalutation());
        new Input("Phone", driver).write(contact.getPhone());
        new Input("Home Phone", driver).write(contact.getHomephone());
        new Input("First Name", driver).write(contact.getFirstname());
        new Input("Last Name", driver).write(contact.getLastname());
        new Input("Mobile", driver).write(contact.getMobile());
        new Input("Title", driver).write(contact.getTitle());
        new Input("Other Phone", driver).write(contact.getOtherphone());
        new Picklist("Lead Source", driver).selectDropdown(contact.getLeadsource());
        new Input("Department", driver).write(contact.getDepartment());
        new Input("Fax", driver).write(contact.getFax());
        new Input("Email", driver).write(contact.getEmail());
        new Input("Assistant", driver).write(contact.getAssistant());
        new Input("Asst. Phone", driver).write(contact.getAsstphone());
        new Textarea("Mailing Street", driver).writeTextarea(contact.getMailingstreet());
        new Textarea("Other Street", driver).writeTextarea(contact.getOtherstreet());
        return this;
    }

    @Step("Нажатие на кнопку Сохранить новый контак")
    public NewContactModal saveNewContact() {
        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    public void checkNewContactWasCreate() {
        String alertText = driver.findElement(CONTACT_CREATE_ALLERT).getText();
        String cleanedText = alertText.replaceAll("[^a-zA-Z ]", "").trim();
        Assert.assertTrue(
                cleanedText.contains("Contact ") && alertText.contains(" was created.")
        );
    }
}
