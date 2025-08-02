package tests;

import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    @Test
    public void checkCreateContact() {
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password003!");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/new");
        newContactModal.createContact("Dr.", "88999876", "99877655", "Ivan", "Ivanov", "+56765577", "New title", "+677654444", "Web", "IT", "987654433", "test@test.ru", "Petr", "+765332344", "Nevskii 67", "Nevskii 76") ;
        newContactModal.saveNewContact();
        newContactModal.checkNewContactWasCreate();
    }
}
