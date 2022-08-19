package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ListenerWd extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(ListenerWd.class);

    public ListenerWd() {
  super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start find element by -->" +by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Finish find element by -->" +by);
    }

    @Override
    public void onException(Throwable throwable, WebDriver wd) {
        super.onException(throwable, wd);
        logger.info("Something went wrong!!!");
        logger.info(String.valueOf(throwable.fillInStackTrace()));
       File file =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
       int i = (int)(System.currentTimeMillis()/1000)%3600;
       String link = "src/test/screenshots/screen-" +i+".png";
       logger.info("Screen with problem is -->" + link);
       File screen  = new File(link);

        try {
            Files.copy(file,screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
