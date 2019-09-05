package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
public class TestBase {
    WebDriver driver;
@BeforeClass
    public void setUp(){
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();

    openSite("https://trello.com");
login("mebelyakov@gmail.com","15iOi@Ds");
        }


    public void login(String email, String password) {
    click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"),email);
        type(By.cssSelector("[type=password]"),password);
        click(By.id("login"));

    }

    public void click(By locator) {driver.findElement(locator).click();
    }

    public  void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
}

public void clickOnCreateBoard() {click(By.xpath("//div[@class='board-tile mod-add']"));
}
   public void fillBoardDetails(String boardName){
   // click(By.xpath("//input[@placeholder='Add board title']"));
    type(By.cssSelector("[class=subtle-input]"),boardName);
click(By.xpath("//span[@class='icon-sm icon-private']"));
click(By.cssSelector("[class='icon-sm icon-public']"));
click(By.xpath("//input[@class='js-confirm full primary']"));
click(By.xpath("//span[contains(text(),'Create Board')]"));
   }

    public void openSite(String url) {driver.get(url);
    }
    @AfterClass
    public void tearDown(){
    driver.quit();
    }
    public void clickContinueButton() {
        click(By.cssSelector("[type='submit']"));

    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),teamName);
        type(By.cssSelector("textarea"),description);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));

    }

    public void clickOnPlusButtonOnHeader() {
        click(By.name("add"));
    }
    }





