package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {

  //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper user;
    BoardHelper board;


    public void init() {
   //     FirefoxOptions firefoxOptions = new FirefoxOptions();
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("intl.accept_languages","en");
//        firefoxOptions.setProfile(profile);
//        wd = new FirefoxDriver(firefoxOptions);
//ChromeOptions options = new ChromeOptions();
//options.addArguments(,en)
        wd = new EventFiringWebDriver(new ChromeDriver());

        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user = new UserHelper(wd);
        board=new BoardHelper(wd);
        wd.register(new ListenerWd());

    }

    public void stop() {

        wd.quit();
    }

    public BoardHelper board() {
        return board;
    }

    public UserHelper getUser() {
        return user;
    }
}

