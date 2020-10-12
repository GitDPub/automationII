package session;

import browser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class SessionThread {
    private static SessionThread session= null;
    private WebDriver driver;

    private SessionThread(){
        driver= FactoryBrowser.make("owaspZapChrome").create();
    }

    public static SessionThread getInstance(){
        if (session==null) {
            synchronized (SessionThread.class) {
                if (session == null) {
                    session = new SessionThread();
                }
            }
        }
        return session;
    }

    public void closeBrowser(){
        driver.close();
        session=null;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
