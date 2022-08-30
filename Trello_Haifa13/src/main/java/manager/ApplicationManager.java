package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {

  //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper user;
    BoardHelper board;
    String browser; ///firefox

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
   //     FirefoxOptions firefoxOptions = new FirefoxOptions();
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("intl.accept_languages","en");
//        firefoxOptions.setProfile(profile);
//        wd = new FirefoxDriver(firefoxOptions);
//ChromeOptions options = new ChromeOptions();
//options.addArguments(,en)
        if(browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }

        wd.manage().window().maximize();// CI/CD [Jenkins {cd /Users/tayahatum/Qa13_Haifa/Trello_Haifa13:gradlew clean test}]
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

