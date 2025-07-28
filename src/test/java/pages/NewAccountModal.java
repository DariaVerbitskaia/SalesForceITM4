package pages;

import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.InputHelper;
import wrappers.Picklist;

import static wrappers.InputHelper.write;

public class NewAccountModal extends BasePage{

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void createAccount(String name,String phone, String rating) {
        new Input("Account Name", driver).write(name);
        new Input("Phone", driver).write(phone);
        new Picklist("Rating", driver).select(rating);

        write("Account Name", name);
    }
}
