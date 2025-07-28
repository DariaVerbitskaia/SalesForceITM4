package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver drive;
    String label;

    public Input(String label, WebDriver drive) {
        this.drive = drive;
        this.label = label;
    }

    public void write(String text) {
        drive.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-input//input",label)))
                .sendKeys(text);
    }
}
