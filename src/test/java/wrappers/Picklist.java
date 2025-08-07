package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Picklist {
    WebDriver driver;
    String label;

    public Picklist(String label, WebDriver driver) {
        this.label = label;
        this.driver = driver;
    }

    public void selectDropdown(String option) {
        WebElement dropdownButton = driver.findElement(By.xpath(String.format
                ("//label[text()='%s']//ancestor::lightning-picklist//button", label)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdownButton);
        dropdownButton.click();
        WebElement dropdownOptions = driver.findElement(By.xpath(String.format
                ("//label[text()='%s']//ancestor::lightning-picklist" +
                        "//lightning-base-combobox-item//span[text()='%s']", label, option)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdownOptions);
        dropdownOptions.click();
    }

}
