package manager;

import models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreation() {
        click(By.cssSelector("li[data-test-id='create-board-tile']"));
    }

    public void fillBoardCreationForm(Board board) {
        type(By.cssSelector("input[data-test-id='create-board-title-input']"), board.getTitle());

        if (!board.getColor().equals("Pink")) {
            String locator = String.format("//button[@title='%s']", board.getColor());
            click(By.xpath(locator));
        } else {
            click(By.cssSelector("#background-picker ul:last-child li:last-child"));
            click(By.xpath("//div[@title='Pink']"));
        }
    }

    public void submitCreationBoard() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test-id='create-board-submit-button']")));
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        pause(6000);
    }

    public boolean isBoardCreated(String title) { //BoardBlue1 === boardblue1

        String locator = "a[href $='"+title.toLowerCase()+"']";

        //[atr = 'value'] [atr ^= 'val'] [atr *= 'al'] [atr $= 'lue']
        return wd.findElement(By.cssSelector(locator)).isDisplayed();
    }

    public int countBoardsBefore() {
        pause(2000);
        int count = wd.findElements(By.cssSelector("div.content-all-boards>div>div:nth-child(2) ul li")).size()-1;
        System.out.println("Count of Boards before is --->" +count);
        return count;
    }

    public int countBoardsAfter() {
        pause(1000);
        int count = wd.findElements(By.cssSelector("div.content-all-boards>div>div:nth-child(3) ul li")).size()-1;
        System.out.println("Count of Boards after is --->" +count);
        return count;
    }

    //href="/b/BNJaSaNz/boardblue1"
}
