package activity.calculator;

import appiumControl.Button;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class ContactFormActivity {
    public Button buttonSave;
    public TextBox textBoxName;
    public TextBox textBoxPhone;

    public ContactFormActivity() {
        this.buttonSave = new Button(By.id("com.android.contacts:id/menu_done"));
        this.textBoxName = new TextBox(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText"));
        this.textBoxPhone = new TextBox(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText"));
    }
}
