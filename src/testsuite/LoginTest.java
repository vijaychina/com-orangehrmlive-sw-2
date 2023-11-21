package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
//1. userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //* Enter “Admin” username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        // * Enter “admin123 password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        //* Click on ‘LOGIN’ button
        WebElement loginLink = driver.findElement(By.xpath("//button[@type='submit']"));
        loginLink.click();

        //Verify the 'Dashboard' text is display
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6")).getText();
        Assert.assertEquals(expectedText,actualText);
        System.out.println("The Text is : " + actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();

    }
}


