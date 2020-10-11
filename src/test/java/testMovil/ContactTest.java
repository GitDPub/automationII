package testMovil;

import activity.calculator.ContactFormActivity;
import activity.calculator.ContactInfoActivity;
import activity.calculator.MainActivity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.annotation.Order;
import sessionManager.Session;

import java.net.MalformedURLException;


// Ejecutar en orden, cerrar todas las apps y no tener el contacto de prueba
// el test SearchByNameTest, usa ubicacion por coordenadas ya que no se activa de otra manera la busqueda
// segun el dispositivo puede variar
public class ContactTest {

    MainActivity contactMain = new MainActivity();
    ContactFormActivity contactForm = new ContactFormActivity();
    ContactInfoActivity contactInfo = new ContactInfoActivity();

    @Before
    public void Before() throws MalformedURLException {
    }

    @Test
    @Order(1)
    public void ClearSearchFieldTest() throws MalformedURLException {
        contactMain.textBoxSearch.Type("any");
        contactMain.buttonClear.Click();
        String searchAfterClear = contactMain.textBoxSearch.GetText();
        boolean clearSearchResult = searchAfterClear.contains("Search in ") || searchAfterClear.equals("");
        Assert.assertTrue("no empty search field", clearSearchResult);
    }

    @Test
    @Order(2)
    public void AddContactTest() throws MalformedURLException {
        String name = "test1234";
        String phone = "1234";
        contactMain.buttonAddContact.Click();
        contactForm.textBoxName.Type(name);
        contactForm.textBoxPhone.Type(phone);
        contactForm.buttonSave.Click();

        String savedName = contactInfo.labelName.GetText().replaceAll("[\\p{Cc}\\p{Cf}\\p{Co}\\p{Cn}]", "");
        String savedPhone = contactInfo.labelPhone.GetText().replaceAll("[\\p{Cc}\\p{Cf}\\p{Co}\\p{Cn}]", "");

        Assert.assertEquals("no match on name ", savedName, name);
        Assert.assertEquals("no match on phone: ", savedPhone, phone);
    }

    @Test
    @Order(3)
    public void SearchByNameTest() throws MalformedURLException, InterruptedException {
        // 1ro debe pasar el test de arriba AddContactTest

        String name = "test1234";
        String phone = "1234";
        // simula colocar el nombre, el manda por sendkwys no activa la opcion de busqueda,
        // en cambio si se simula la presion por botones del teclado que viene por defecto en Android si funciona.
        Touch(210, 330); // presiona sobre el text field para que aparezca teclado
        Touch(486, 1354);
        Touch(276, 1354);
        Touch(216, 1512);
        Touch(486, 1354);

        Touch(56, 1214);
        Touch(168, 1214);
        Touch(274, 1214);
        Touch(380, 1214);

        contactMain.textBoxSearch.Type(name);
        Thread.sleep(1000);

        String searchedName = contactMain.labelSingleName.GetText().replaceAll("[\\p{Cc}\\p{Cf}\\p{Co}\\p{Cn}]", "");
        String searchedPhone = contactMain.labelSinglePhone.GetText().replaceAll("[\\p{Cc}\\p{Cf}\\p{Co}\\p{Cn}]", "");

        Assert.assertEquals("no match on name after search ",name,searchedName);
        Assert.assertEquals("no match on phone after search ",phone,searchedPhone);
    }

    @Test
    @Order(4)
    public void SearchNegativeTest() throws MalformedURLException, InterruptedException {
        //simula escribir testtest, para activar la busqueda
        Touch(210, 330);
        Touch(486, 1354);
        Touch(276, 1354);
        Touch(216, 1512);
        Touch(486, 1354);
        Touch(486, 1354);
        Touch(276, 1354);
        Touch(216, 1512);
        Touch(486, 1354);

        Thread.sleep(500);

        boolean searchResult = contactMain.labelSingleName.isDisplayed();
        Assert.assertFalse(searchResult);
    }

    @Test
    @Order(5)
    public void OpenMenuTest() throws MalformedURLException, InterruptedException {
        contactMain.buttonNavigation.Click();
        boolean searchResult = contactMain.buttonMenuContactUs.isDisplayed();
        Assert.assertTrue(searchResult);
    }

    @After
    public void After() throws MalformedURLException {
        Session.getInstance().CloseSession();
    }

    public void Touch(int x, int y) throws MalformedURLException {
        TouchAction action = new TouchAction(Session.getInstance().getDriver());
        action.press(PointOption.point(x, y)).release().perform();
    }

}
