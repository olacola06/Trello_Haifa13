package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerNG.class)
public class GoToGoogle {
    Logger logger = LoggerFactory.getLogger(GoToGoogle.class);
    WebDriver wd;

    @Test
    public void goToGoogle(){
        wd= new ChromeDriver();
        logger.info(" test start on Chrome");
        wd.get("https://google.com");
        logger.info(" we go to google");
    }
}

