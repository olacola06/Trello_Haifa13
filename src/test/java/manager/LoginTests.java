package manager;

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
    public void loginSuccess2(){

        app.getUser().initLogin();
        app.getUser().fillLoginForm("hatum.testing@gmail.com", "Hatum21$");
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());


    }
}
