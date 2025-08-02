package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
    WebDriver driver;
    String label;

    public Checkbox(String label, WebDriver driver) {
        this.label = label;
        this.driver = driver;
    }

    public void chooseCheckbox(String label) {
        WebElement checkbox = driver.findElement(By.xpath(String.format
                ("//lightning-primitive-input-checkbox[.//span[normalize-space(text())='%s']]//input[@type='checkbox']", label)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
    }
}