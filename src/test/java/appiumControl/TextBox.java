package appiumControl;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TextBox extends Control{
    public TextBox(By locator) {
        super(locator);
    }

    public void Type(String value) throws MalformedURLException {
        this.FindControl();
        this.control.sendKeys(value);
    }
}
