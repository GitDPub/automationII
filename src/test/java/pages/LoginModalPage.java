package pages;

import control.Button;
import control.CheckBox;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginModalPage {
    public TextBox fullNameTextBox= new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"),"[fullname] textbox on Login Modal Page");
    public TextBox emailTextBox= new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"),"[email] textbox on Login Modal Page");
    public TextBox passwordTextBox= new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"),"[password] textbox on Login Modal Page");
    public CheckBox agreeTermsCheckBox= new CheckBox(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"),"[agree terms] checkbox on Login Modal Page");
    public Button signupButton= new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"),"[signup] button on Login Modal Page");
    public Label labelTestProject1 = new Label(By.xpath("//*[text()='test-project-1']"),"[label]label name for test project 1");
    public Label labelTestProject2 = new Label(By.xpath("//*[text()='test-project-2']"),"[label]label name for test project 2");
    public Label labelTestProject3 = new Label(By.xpath("//*[text()='test-project-3']"),"[label]label name for test project 3");
    public Label labelTestProject4 = new Label(By.xpath("//*[text()='test-project-4']"),"[label]label name for test project 4");
    public Label labelTestProject5 = new Label(By.xpath("//*[text()='test-project-5']"),"[label]label name for test project 5");
}

