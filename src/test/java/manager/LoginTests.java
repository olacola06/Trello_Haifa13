package manager;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){

        app.getUser().initLogin();
        app.getUser().fillLoginForm("hatum.testing@gmail.com", "Hatum21$");
        app.getUser().submitLogin();

    }
}
