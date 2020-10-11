package activity.calculator;

import appiumControl.Label;
import org.openqa.selenium.By;

public class ContactInfoActivity {
    public Label labelName;
    public Label labelPhone;

    public ContactInfoActivity() {
        this.labelName = new Label(By.id("com.android.contacts:id/name"));
        this.labelPhone = new Label(By.id("com.android.contacts:id/data"));
    }
}
