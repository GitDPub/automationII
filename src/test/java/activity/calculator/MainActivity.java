package activity.calculator;

import appiumControl.Button;
import appiumControl.TextBox;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

public class MainActivity {
    public Button buttonOpenParenthesis;
    public Button buttonCloseParenthesis;
    public Button buttonShift;
    public Button buttonPow;
    public Button buttonRoot;
    public Button buttonPlus;
    public Button buttonMinus;
    public Button buttonBy;
    public Button buttonDivide;
    public Button buttonEqual;
    public Button buttonDelete;
    public Button buttonAC;
    public Button button0;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public TextBox textBoxScreen;

    public MainActivity() {
        this.buttonOpenParenthesis = new Button(By.id("com.locus.scientificcalculator:id/buttonBo"));
        this.buttonCloseParenthesis = new Button(By.id("com.locus.scientificcalculator:id/buttonBc"));
        this.buttonPow = new Button(By.id("com.locus.scientificcalculator:id/buttonPow"));
        this.buttonRoot = new Button(By.id("com.locus.scientificcalculator:id/buttonRoot"));
        this.buttonShift = new Button(By.id("com.locus.scientificcalculator:id/buttonShift"));
        this.buttonPlus = new Button(By.id("com.locus.scientificcalculator:id/buttonPlus"));
        this.buttonMinus = new Button(By.id("com.locus.scientificcalculator:id/buttonSubtract"));
        this.buttonBy = new Button(By.id("com.locus.scientificcalculator:id/buttonMultiply"));
        this.buttonDivide = new Button(By.id("com.locus.scientificcalculator:id/buttonDivide"));
        this.buttonEqual = new Button(By.id("com.locus.scientificcalculator:id/ButtonEqual"));
        this.buttonDelete = new Button(By.id("com.locus.scientificcalculator:id/buttonDel"));
        this.buttonAC = new Button(By.id("com.locus.scientificcalculator:id/buttonAC"));
        this.button0 = new Button(By.id("com.locus.scientificcalculator:id/button0"));
        this.button1 = new Button(By.id("com.locus.scientificcalculator:id/button1"));
        this.button2 = new Button(By.id("com.locus.scientificcalculator:id/button2"));
        this.button3 = new Button(By.id("com.locus.scientificcalculator:id/button3"));
        this.button4 = new Button(By.id("com.locus.scientificcalculator:id/button4"));
        this.button5 = new Button(By.id("com.locus.scientificcalculator:id/button5"));
        this.button6 = new Button(By.id("com.locus.scientificcalculator:id/button6"));
        this.button7 = new Button(By.id("com.locus.scientificcalculator:id/button7"));
        this.button8 = new Button(By.id("com.locus.scientificcalculator:id/button8"));
        this.button9 = new Button(By.id("com.locus.scientificcalculator:id/button9"));
        this.textBoxScreen = new TextBox(By.id("com.locus.scientificcalculator:id/txtOutput"));
    }
}
