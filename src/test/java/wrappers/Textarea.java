package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Textarea {

    WebDriver drive;
    String label;

    public Textarea(String label, WebDriver drive) {
        this.drive = drive;
        this.label = label;
    }

    public void writeTextarea(String text) {
        drive.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-textarea//textarea",label)))
                .sendKeys(text);
    }
}
