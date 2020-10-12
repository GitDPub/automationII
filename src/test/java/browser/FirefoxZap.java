package browser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class FirefoxZap implements IBrowser {
    @Override
    public WebDriver create() {
        String driverPath="I:\\diplomado\\modulo4\\examenAll\\sec3\\automationII\\src\\test\\resources\\drivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:8090");
        proxy.setSslProxy("127.0.0.1:8090");

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("dom.webnotifications.enabled", false);
        profile.setPreference("dom.push.enabled", false);

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("proxy",proxy);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.setCapability(CapabilityType.PROXY, proxy);
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        firefoxOptions.merge(capabilities);

        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
