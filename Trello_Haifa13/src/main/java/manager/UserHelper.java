package manager;


import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void login(User user) {
        initLogin();
        fillLoginForm(user);
        submitLogin();
    }

    public void clickAvatarImg() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void openProfileAndVisibility() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void navigateToAtlassianProfile() {
        click(By.xpath("//a[text()='Atlassian profile']"));
        System.out.println(wd.getWindowHandle());
        List<String >tabs =new ArrayList<>(wd.getWindowHandles()); //[0],[1]
        wd.switchTo().window(tabs.get(1));

    }

    public String getUrl() {
        return wd.getCurrentUrl();
    }
    public String getTitlePage(){
        return wd.getTitle();
    }

    public void initChangePhoto() {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']")))
                .click().perform();
        // Shift+command+c
        click(By.xpath("//span[text()='Change profile photo']"));
    }

    public void uploadPhoto(String link) {
        wd.findElement(By.id("image-input")).sendKeys(link);
//        new WebDriverWait(wd,5)
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Upload']")));
        //click(By.xpath("//button[text()='Upload']"));
        click(By.cssSelector(".css-10b45o3"));
    }

    public boolean isAvatarAdded() {
        try {
            WebElement element = new WebDriverWait(wd, 15)
                    .until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//span[text()='Avatar added']"))));
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }

    }

    public void returnFromAtlassianProfile() {
        List<String  >tabs = new ArrayList<>(wd.getWindowHandles());
        wd.close();
        wd.switchTo().window(tabs.get(0));
    }
}
