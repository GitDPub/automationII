package pages;

import control.Button;
import control.Label;
import control.TextBox;

import org.openqa.selenium.By;

public class StartPage {

    public Button buttonNewProject = new Button(By.xpath("//*[@id=\"MainTable\"]/tbody/tr/td[1]/div[6]/div"),"[button] Button add new project");
    public Button buttonAdd = new Button(By.id("NewProjNameButton"),"[button] Button add project");
    public TextBox textBoxAddProject = new TextBox(By.id("NewProjNameInput"),"[text field] Add project field");
    public Label labelTestProject1 = new Label(By.xpath("//*[text()='test-project-1']"),"[label]label name for test project 1");
    public Label labelTestProject2 = new Label(By.xpath("//*[text()='test-project-2']"),"[label]label name for test project 2");
    public Label labelTestProject3 = new Label(By.xpath("//*[text()='test-project-3']"),"[label]label name for test project 3");
    public Label labelTestProject4 = new Label(By.xpath("//*[text()='test-project-4']"),"[label]label name for test project 4");
    public Label labelTestProject5 = new Label(By.xpath("//*[text()='test-project-5']"),"[label]label name for test project 5");

}
