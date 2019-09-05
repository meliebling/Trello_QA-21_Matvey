package com.trello.qa;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

@Test
    public void testBoardCreation(){
    Assert.assertTrue(isUserLoggedIn());
clickOnCreateBoard();
    fillBoardDetails("adovaya doska");

}
    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));

    }

    public boolean isElementPresent(By locator) {return driver.findElements(locator).size()>0;
    }
}



