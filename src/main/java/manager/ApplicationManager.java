package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {

    WebDriver wd;
    UserHelper user;


    public void init() {
   //     FirefoxOptions firefoxOptions = new FirefoxOptions();
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("intl.accept_languages","en");
//        firefoxOptions.setProfile(profile);
//        wd = new FirefoxDriver(firefoxOptions);
//ChromeOptions options = new ChromeOptions();
//options.addArguments(,en)
        wd = new ChromeDriver();

        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user = new UserHelper(wd);

    }

    public void stop() {

        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }
}

