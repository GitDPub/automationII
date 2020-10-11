package testMovil;

import activity.calculator.MainActivity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sessionManager.Session;

import java.net.MalformedURLException;

public class CalculatorTest {

    MainActivity calculatorActivity = new MainActivity();

    @Before
    public void Before() throws MalformedURLException {
        calculatorActivity.buttonAC.Click();
    }

    @Test
    public void OperationPlus() throws MalformedURLException {
        calculatorActivity.button9.Click();
        calculatorActivity.button9.Click();
        calculatorActivity.buttonPlus.Click();
        calculatorActivity.button1.Click();
        calculatorActivity.buttonEqual.Click();
        String actualResult = calculatorActivity.textBoxScreen.GetText();
        String expectedResult = "100";
        Assert.assertEquals("no correct plus operation", expectedResult, actualResult);
    }

    @Test
    public void OperationMinus() throws MalformedURLException {
        calculatorActivity.button1.Click();
        calculatorActivity.button0.Click();
        calculatorActivity.button0.Click();
        calculatorActivity.buttonMinus.Click();
        calculatorActivity.button9.Click();
        calculatorActivity.button9.Click();
        calculatorActivity.buttonEqual.Click();
        String actualResult = calculatorActivity.textBoxScreen.GetText();
        String expectedResult = "1";
        Assert.assertEquals("no correct minus operation", expectedResult, actualResult);
    }

    @Test
    public void OperationMultiply() throws MalformedURLException {
        calculatorActivity.button5.Click();
        calculatorActivity.buttonBy.Click();
        calculatorActivity.button7.Click();
        calculatorActivity.buttonEqual.Click();
        String actualResult = calculatorActivity.textBoxScreen.GetText();
        String expectedResult = "35";
        Assert.assertEquals("no correct multiplication operation", expectedResult, actualResult);
    }

    @Test
    public void OperationDivide() throws MalformedURLException {
        calculatorActivity.button5.Click();
        calculatorActivity.button5.Click();
        calculatorActivity.buttonDivide.Click();
        calculatorActivity.button5.Click();
        calculatorActivity.buttonEqual.Click();
        String actualResult = calculatorActivity.textBoxScreen.GetText();
        String expectedResult = "11";
        Assert.assertEquals("no correct divide operation", expectedResult, actualResult);
    }

    @Test
    public void OperationCubicRoot() throws MalformedURLException {
        calculatorActivity.buttonShift.Click();
        calculatorActivity.buttonRoot.Click();
        calculatorActivity.button2.Click();
        calculatorActivity.button7.Click();
        calculatorActivity.buttonCloseParenthesis.Click();
        calculatorActivity.buttonEqual.Click();
        String actualResult = calculatorActivity.textBoxScreen.GetText();
        String expectedResult = "3";
        Assert.assertEquals("no correct root operation", expectedResult, actualResult);
    }

    @Test
    public void OperationPow() throws MalformedURLException {
        calculatorActivity.button8.Click();
        calculatorActivity.buttonPow.Click();
        calculatorActivity.buttonEqual.Click();
        String actualResult = calculatorActivity.textBoxScreen.GetText();
        String expectedResult = "64";
        Assert.assertEquals("no correct pow operation", expectedResult, actualResult);
    }

    @After
    public void After() throws MalformedURLException {
        Session.getInstance().CloseSession();
    }

}
