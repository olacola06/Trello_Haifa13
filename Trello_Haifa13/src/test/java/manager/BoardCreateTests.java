package manager;


import models.Board;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class BoardCreateTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(!app.getUser().isLogged()){
            User user = new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$");
            app.getUser().login(user);
        }
    }

    @Test
    public void test(){
//       if(count<10){
//           createBoard();
//       }else{
//           deleteBoard();
//           createBoard();
//       }
    }

    @Test
    public void createNewBoardSuccess(){
        Random random = new Random();
        int index = random.nextInt(10);
        Board board = Board.builder().title("BoardPink"+index).color("Pink").build();


        int countBefore = app.board().countBoardsBefore();
        app.board().initBoardCreation();
        app.board().fillBoardCreationForm(board);
        app.board().submitCreationBoard();

        Assert.assertTrue(app.getUser().getUrl().contains(board.getTitle().toLowerCase()));
        Assert.assertTrue(app.board().isBoardCreated(board.getTitle()));
        app.getUser().returnToTrello();
        int countAfter =app.board().countBoardsAfter();
        Assert.assertEquals( countAfter-countBefore,1);

    }
}
