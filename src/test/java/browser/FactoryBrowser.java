package browser;

public class FactoryBrowser {

    public static IBrowser make(String typeBrowser){
        IBrowser browser;
        switch (typeBrowser.toLowerCase()){
            case "chrome":
                browser=new Chrome();
                break;
            case "owaspZapChrome":
                browser=new ChromeZap();
                break;
            case "firefox":
                browser=new Firefox();
                break;
            case "owaspZapFirefox":
                browser=new FirefoxZap();
                break;
            default:
                browser=new Chrome();
                break;
        }
        return browser;
    }
}
