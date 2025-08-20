package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplManager {

    WebDriver wd;
    String browser;
    Logger logger= LoggerFactory.getLogger(ApplManager.class);
    HelperUser helperUser;


    public ApplManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if(browser.equals(Browser.CHROME.browserName())) {
            wd = new ChromeDriver();
            logger.info("All tests runs in Chrome Browser");
       } else if (browser.equals(Browser.FIREFOX.browserName())) {
           wd = new FirefoxDriver();
         logger.info("All tests runs in FIREFOX Browser");
        } else {
            wd = new EdgeDriver();
            logger.info("All tests runs in EDGE Browser");
       }
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://icarro-v1.netlify.app/");
        logger.info("LINK ==> "+wd.getCurrentUrl());
        helperUser=new HelperUser(wd);




    }
    public void stop(){

        wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
}
