package tests;

import dto.Contact;
import dto.ContactFactory;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    @Test
    public void checkCreateContact() {
        Contact contact = ContactFactory.getContact("Ms.", "Web", "test@mail.com");
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password003!");
        newContactModal.open()
                        .isPageOpened()
                        .createContact(contact)
                        .saveNewContact()
                        .checkNewContactWasCreate();
    }
}