package tests;


import dto.Account;
import dto.AccountFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AccountTest extends BaseTest {

    @Test
    public void checkCreateAccount() {
        Account account = AccountFactory.getAccount("Warm", "Prospect", "Private", "Banking", "VIP Client", "TeachMeSkills");
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password003!");
        newAccountModal.open()
                        .isPageOpened()
                        .createAccount(account)
                        .saveNewAccount();
        newAccountModal.checkNewAccountWasCreate();
    }
}
