package pages;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

@Log4j2
public class NewContactModal extends BasePage {

    private final By SAVE_BUTTON = By.xpath("//button[normalize-space(text())='Save' and @name='SaveEdit']");
    private final By CONTACT_CREATE_ALLERT = By.xpath("//span[contains(@class, 'toastMessage') and contains(text(), 'Contact')]");
    private final By PHONE_FIELD = By.xpath("//label[text()='Phone']//ancestor::lightning-input//input");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие модального окна для создания контакта")
    public NewContactModal open() {
        log.info("Open NewContactModal");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/new");
        return this;
    }

    @Override
    @Step("Проверка открытия модального окна по показу элемента на нем")
    public NewContactModal isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_FIELD));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't open");
        }
        return this;
    }

    @Step("Заполнение полей модального окна для создания контакта")
    public NewContactModal createContact(Contact contact) {
        new Picklist("Salutation", driver).selectDropdown(contact.getSalutation());
        log.info("Dropdown value selected in Salutation");
        new Input("Phone", driver).write(contact.getPhone());
        log.info("Value set in Account Phone");
        new Input("Home Phone", driver).write(contact.getHomephone());
        log.info("Value set in Home Phone");
        new Input("First Name", driver).write(contact.getFirstname());
        log.info("Value set in First Name");
        new Input("Last Name", driver).write(contact.getLastname());
        log.info("Value set in Last Name");
        new Input("Mobile", driver).write(contact.getMobile());
        log.info("Value set in Mobile");
        new Input("Title", driver).write(contact.getTitle());
        log.info("Value set in Title");
        new Input("Other Phone", driver).write(contact.getOtherphone());
        log.info("Value set in Other Phone");
        new Picklist("Lead Source", driver).selectDropdown(contact.getLeadsource());
        log.info("Dropdown value selected in Lead Source");
        new Input("Department", driver).write(contact.getDepartment());
        log.info("Value set in Department");
        new Input("Fax", driver).write(contact.getFax());
        log.info("Value set in Fax");
        new Input("Email", driver).write(contact.getEmail());
        log.info("Value set in Email");
        new Input("Assistant", driver).write(contact.getAssistant());
        log.info("Value set in Assistant");
        new Input("Asst. Phone", driver).write(contact.getAsstphone());
        log.info("Value set in Asst. Phone");
        new Textarea("Mailing Street", driver).writeTextarea(contact.getMailingstreet());
        log.info("Value set in Mailing Street");
        new Textarea("Other Street", driver).writeTextarea(contact.getOtherstreet());
        log.info("Value set in Other Street");
        return this;
    }

    @Step("Нажатие на кнопку Сохранить новый контак")
    public NewContactModal saveNewContact() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("Save button was clicked");
        return this;
    }

    public void checkNewContactWasCreate() {
        String alertText = driver.findElement(CONTACT_CREATE_ALLERT).getText();
        log.info("Raw alert text: '{}'", alertText);
        String cleanedText = alertText.replaceAll("[^a-zA-Z ]", "").trim();
        log.info("Cleaned alert text (for assertion): '{}'", cleanedText);
        Assert.assertTrue(
                cleanedText.contains("Contact ") && alertText.contains(" was created.")
        );
    }
}