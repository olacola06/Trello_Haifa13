package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        type(By.name("password"),password);


    }


    public void submitLogin(){
        click(By.id("login-submit"));
    }
}
