package control;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class ControlSelenium {
    protected WebElement webElement;
    protected By locator;
    protected String myName;

    public ControlSelenium(By locator,String myName)
    {
        this.locator=locator;
        this.myName=myName;
    }

    @Step("{0}")
    public void allureStep(String action){}

    protected void findElement(){
        this.webElement= Session.getInstance().getDriver().findElement(this.locator);
    }

    public void click(){
        this.allureStep("Click on "+this.myName);
        this.findElement();
        this.webElement.click();
    }

    public void type(String value){
        this.allureStep("Type value : '"+value+"' on "+myName ) ;
        this.findElement();
        this.webElement.sendKeys(value);
    }

    public boolean isDisplayedOnPage(){
        try {
            this.allureStep("'"+myName+"'  is displayed ? " ) ;
            this.findElement();
            return this.webElement.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
