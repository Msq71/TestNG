package sda.homeworks.day17;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sda.utilities.TestBase;

public class Hw01 extends TestBase {
    /*
    Open the site: http://opencart.abstracta.us/index.php?route=account/login
    Login with that credentials
    Email: clarusway@gmail.com
    Password: 123456789
    Using the Search function do it with Data Provider for Mac, iPad and Samsung.
     */

    By emailBox = By.id("input-email");
    By passwordField = By.id("input-password");
    By buttonXpath = By.xpath("//input[@type='submit']");
    By searchBox = By.name("search");
    By searchButton = By.xpath("//*[@id=\"search\"]/span/button");

    @Test(dataProvider = "Hw1")
    public void test(String keyWord) throws InterruptedException {
        // 1)  Open the site: http://opencart.abstracta.us/index.php?route=account/login
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        // 2) Login with that credentials
        driver.findElement(emailBox).sendKeys("clarusway@gmail.com");
        driver.findElement(passwordField).sendKeys("123456789");
        driver.findElement(buttonXpath).click();

        //3) Using the Search function do it with Data Provider for Mac, iPad and Samsung.
        driver.findElement(searchBox).sendKeys(keyWord);
        driver.findElement(searchButton).click();
        Thread.sleep(1000);

    }
    @DataProvider(name = "Hw1")
    public Object[][] getData() {
        Object[][] data = {
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
        return data;
    }
}
