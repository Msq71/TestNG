package sda.tests.smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.utilities.TestBase;

public class PositiveLoginTest extends TestBase {
    // Test Case1: Positive Login Test
    @Test(description = "PositiveTest")
    public void PositiveTest() throws InterruptedException {
        // 1) Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");
        // 2) Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("student");
        // 3) Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");
        // 4) Click Submit button.
        driver.findElement(By.id("submit")).click();
        // 5) Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        Thread.sleep(1000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully/"));
        // 6) Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        WebElement congratulations = driver.findElement(By.xpath("//h1[@class='post-title']"));
        Assert.assertTrue(congratulations.isDisplayed());
        // 7) Verify button Log out is displayed on the new page.
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }

}
