package sda.tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sda.utilities.TestBase;

import java.time.Duration;

public class C04ParallelTestDataProvider extends TestBase {
    By userNameFiled = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");

    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
//        WebDriver driver1 = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); and remove extends

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(userNameFiled).sendKeys(userName);
        driver.findElement(passwordName).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(buttonTag).click();

        Thread.sleep(1000);
        WebElement invalidText = driver.findElement(textByXpath);

        Assert.assertTrue(invalidText.isDisplayed());


    }


    @DataProvider(name = "invalidCredentials", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"adm", "admin23*"},
                {"cdmin", "admin123"},
        };
    }
}