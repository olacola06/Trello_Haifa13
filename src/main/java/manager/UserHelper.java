package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin(){
 if(wd.findElement(By.cssSelector("a[href='/login']")).isDisplayed()) {
     click(By.cssSelector("a[href='/login']"));
 }
    }

    public void fillLoginForm(String email, String password){
        // type email
        type(By.id("user"),email);
        // click atlassian
        click(By.id("login"));
        // type password
        type(By.cssSelector("#password.css-wxvfrp"),password);


    }
    public void fillLoginForm(User user){
        // type email
        type(By.id("user"), user.getEmail());
        // click atlassian
        click(By.id("login"));
        // type password
        type(By.cssSelector("#password.css-wxvfrp"),user.getPassword());


    }


    public void submitLogin(){
        click(By.cssSelector("#login-submit"));
    }

    public boolean isLogged() {
        try {
            WebDriverWait wait = new WebDriverWait(wd, 5);
            wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("[data-test-id='header-member-menu-button']"))));
        }catch (Exception e){
            return false;
        }

        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.id("logout-submit"));
    }

    public void fillLoginFormWrongEmail(User user) {
        type(By.id("user"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public String takeErrorText() {
        //pause(1000);
        new WebDriverWait(wd,5)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div#error p"))));
        return wd.findElement(By.cssSelector("div#error p")).getText();
    }

    public void submitLoginWithError() {
        click(By.id("login"));
    }

    public boolean isErrorDisplayed(String error) {
        return new WebDriverWait(wd,5)
                .until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("div#error p")),error));
    }

    public boolean textErrorPasswordDisplaed(String error) {
        new WebDriverWait(wd,5)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div#login-error span"))));
        return wd.findElement(By.cssSelector("div#login-error span")).getText().contains(error);
    }

    public void returnToTrello() {
        wd.navigate().to("https://trello.com/");
    }
}
