package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Firefox implements IBrowser {
    @Override
    public WebDriver create() {
        String driverPath="I:\\diplomado\\modulo4\\examenAll\\sec3\\automationII\\src\\test\\resources\\drivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverPath);
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
