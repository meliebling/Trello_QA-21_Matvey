package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

    @Test

    public void teamCreationFromPlusButtonOnHeader(){
        int before= getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("autoTeam1", "description qa 21");
        clickContinueButton();
        returnToHomePage();
        int after= getTeamsCount();
        Assert.assertEquals(after,before+1);

        Assert.assertTrue(isUserLoggedIn());
    }

    public void returnToHomePage() {
        click(By.xpath("//a[@href='/']"));
    }

    public int getTeamsCount() {
        return driver.findElements(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));

    }

    public boolean isElementPresent(By locator) {return driver.findElements(locator).size()>0;
    }
}
