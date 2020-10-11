package activity.calculator;

import appiumControl.Button;
import appiumControl.Label;
import appiumControl.TextBox;
import cucumber.api.java.en.But;
import org.openqa.selenium.By;

public class MainActivity {
    public Button buttonAddContact;
    public Button buttonClear;
    public Button buttonNavigation;
    public Button buttonMenuContactUs;
    public TextBox textBoxSearch;
    public Label labelSingleName ;
    public Label labelSinglePhone ;

    public MainActivity() {
        this.buttonNavigation = new Button(By.id("com.simplemanage.contactsapp:id/frMenuNavigation"));
        this.buttonMenuContactUs = new Button(By.id("com.simplemanage.contactsapp:id/nav_contact_us"));
        this.buttonClear = new Button(By.id("com.simplemanage.contactsapp:id/search_close_btn"));
        this.buttonAddContact = new Button(By.id("com.simplemanage.contactsapp:id/btnAddContact"));
        this.textBoxSearch = new TextBox(By.id("com.simplemanage.contactsapp:id/search_src_text"));
        this.labelSingleName = new Label(By.id("com.simplemanage.contactsapp:id/tvContactName"));
        this.labelSinglePhone = new Label(By.id("com.simplemanage.contactsapp:id/tvPhoneNumber"));
    }
}
