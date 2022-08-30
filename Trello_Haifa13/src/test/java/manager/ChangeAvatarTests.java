package manager;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatarTests extends TestBase{
//"hatum.testing@gmail.com", "Hatum21$"
    @BeforeMethod
    public void preCondition(){
        if(!app.getUser().isLogged()){
            User user =new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$");
            logger.info("Test 'start with' user " + user.toString());
            app.getUser().login( user);
        }

    }

    @Test
    public void test(){
        logger.info("Start test test");
    }

    @Test
    public void changeAvatarSuccess(){
        app.getUser().clickAvatarImg();
        app.getUser().openProfileAndVisibility();
        app.getUser().navigateToAtlassianProfile();
        Assert.assertTrue(app.getUser().getUrl().contains("id.atlassian.com"));
        Assert.assertTrue(app.getUser().getTitlePage().contains("Atlassian account"));

        app.getUser().initChangePhoto();
        app.getUser().uploadPhoto("/Users/tayahatum/Qa13_Haifa/Trello_Haifa13/src/test/qa.png");
        Assert.assertTrue(app.getUser().isAvatarAdded());
        app.getUser().returnFromAtlassianProfile();
        Assert.assertTrue(app.getUser().getUrl().contains("https://trello.com/"));


    }
}
