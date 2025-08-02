package tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class AccountTest extends BaseTest {

    @Test
    public void checkCreateAccount() {
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password003!");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        newAccountModal.createAccount("Warm", "OOO IBIS", "+67865422456", "6677788", "666", "https://www.saucedemo.com/", "7788", "YR-14", "Prospect","Private", "Banking", "333", "1234", "code 54", "VIP Client", "TeachMeSkills", "l.A.", "L.A.");
        newAccountModal.saveNewAccount();
        newAccountModal.checkNewAccountWasCreate();
    }
}
