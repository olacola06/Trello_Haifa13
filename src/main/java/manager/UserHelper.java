package manager;

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

        //wd.findElement(By.cssSelector("a[href='/login']")).click();
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginForm(String email, String password){
        // type email
        type(By.id("user"),email);
        // click atlassian
        click(By.id("login"));
        // type password
        type(By.cssSelector("#password.css-wxvfrp"),password);


    }


    public void submitLogin(){
        click(By.id("login-submit"));
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
}
