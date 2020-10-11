package appiumControl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sessionManager.Session;

import java.net.MalformedURLException;

public class Control {

    protected WebElement control;
    protected By locator;

    public Control(By locator) {
        this.locator = locator;
    }

    public void FindControl() throws MalformedURLException {
        this.control = Session.getInstance().getDriver().findElement(this.locator);
    }

    public void Click() throws MalformedURLException {
        this.FindControl();
        this.control.click();
    }

    public String GetText() throws MalformedURLException {
        this.FindControl();
        return this.control.getText();
    }

    public boolean isDisplayed(){
        try{
            this.FindControl();
            return this.control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
