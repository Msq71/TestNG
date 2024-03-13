package sda.homeworks.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.utilities.TestBase;


public class Hw1_HardVsSoftAssertion extends TestBase {

/*
Test Case1: Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Click Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
Verify new page contains expected text ('Congratulations' or 'successfully logged in')
Verify button Log out is displayed on the new page.
*/

    // Test Case1: Positive Login Test
    @Test(description = "Hard assertion")
    public void hardAssertion() throws InterruptedException {
        // 1) Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // 2) Type username student into Username field
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        // 3) Type password Password123 into Password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        // 4) Click Submit button.
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // 5) Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        Thread.sleep(1000);
        String currentUrlUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlUrl.contains("practicetestautomation.com/logged-in-successfully/"));

        // 6) Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        WebElement congratulations = driver.findElement(By.xpath("//h1[@class='post-title']"));
        Assert.assertTrue(congratulations.isDisplayed());

        // 7) Verify button Log out is displayed on the new page.
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }


}
