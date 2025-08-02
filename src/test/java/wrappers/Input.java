package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input {

    WebDriver driver;
    String label;

    public Input(String label, WebDriver driver) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        WebElement writeText = driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-input//input",label)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", writeText);
        writeText.sendKeys(text);
    }
}
