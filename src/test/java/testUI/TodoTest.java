package testUI;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginModalPage;
import pages.MainPage;
import pages.StartPage;
import session.Session;

public class TodoTest {
    LoginModalPage loginModalPage = new LoginModalPage();
    MainPage mainPage = new MainPage();
    StartPage startPage = new StartPage();

    @Before
    public void before(){
        Session.getInstance().getDriver().get("http://todo.ly/");
    }

    @DisplayName("verify The Login Using User And Password")
    @Description("This test case is to verify verify The Login Using User And Password")
    @Test
    public void verifyTheLoginUsingUserAndPassword() throws InterruptedException {
        mainPage.singUpFreeButton.click();
        loginModalPage.fullNameTextBox.type("ucb1022@ucb.com"); // cambiar user
        loginModalPage.emailTextBox.type("ucb1022@ucb.com"); // cambiar password
        loginModalPage.passwordTextBox.type("123todo");
        loginModalPage.agreeTermsCheckBox.click();
        loginModalPage.signupButton.click();
        Thread.sleep(2000);
        startPage.buttonNewProject.click();
        startPage.textBoxAddProject.type("test-project-1"); // o tambien test-project-2, ..., test-project-5
        startPage.buttonAdd.click();

        Assert.assertFalse("ERROR , no se legeo!",loginModalPage.signupButton.isDisplayedOnPage());
        Assert.assertTrue("ERROR , no existe el proyecto!",startPage.labelTestProject1.isDisplayedOnPage());
    }

    @After
    public void after(){
        Session.getInstance().closeBrowser();
    }
}
