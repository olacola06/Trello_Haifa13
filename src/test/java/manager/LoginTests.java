package manager;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }


    @Test
    public void loginSuccess(){
        app.getUser().initLogin();
        app.getUser().fillLoginForm("hatum.testing@gmail.com", "Hatum21$");
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());


    }
    @Test
    public void loginSuccessUser(){
        User user = new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$");

       app.getUser().initLogin();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());


    }
    @Test
    public void loginWithWrongEmail(){
        User user = new User().withEmail("hatum.testinggmail.com").withPassword("Hatum21$");
        app.getUser().initLogin();
        app.getUser().fillLoginFormWrongEmail(user);
        app.getUser().submitLoginWithError();
        Assert.assertEquals(app.getUser().takeErrorText(),"There isn't an account for this username");
        Assert.assertTrue(app.getUser().isErrorDisplayed("There isn't an account for this username"));
    }

    @Test
    public void loginWithWrongPassword(){
        User user = new User().withEmail("hatum.testing@gmail.com").withPassword("Hat");
        app.getUser().initLogin();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().textErrorPasswordDisplaed("Incorrect email address and / or password."));
        app.getUser().returnToTrello();

    }
}
