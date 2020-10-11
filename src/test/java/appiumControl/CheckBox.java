package appiumControl;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class CheckBox extends Control {
    public CheckBox(By locator) {
        super(locator);
    }

    public void Check() throws MalformedURLException {
        this.FindControl();
        if(!IsChecked()) {
            this.control.click();
        }
    }

    public void Uncheck() throws MalformedURLException {
        this.FindControl();
        if(IsChecked()) {
            this.control.click();
        }
    }

    public boolean IsChecked() throws MalformedURLException {
        return this.control.getAttribute("checked").equals("true");
    }
}