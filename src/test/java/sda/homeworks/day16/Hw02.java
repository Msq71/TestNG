package sda.homeworks.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

import java.time.Duration;

public class Hw02 extends TestBase {

    /*
    -- Parametrizes Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Click Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
You should execute this test with xml file
     */

    //Parametrizes Positive Login Test
    @Test(description = "Positive Login")
    @Parameters({"username", "password"})
    public void hardAssertion(String username, String password) throws InterruptedException {
        // 1) Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");
        // 2) Type username student into Username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username); //student
        // 3) Type password Password123 into Password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password); //Password123
        // 4) Click Submit button.
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        // 5) Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        Thread.sleep(1000);
        String currentUrlUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlUrl.contains("practicetestautomation.com/logged-in-successfully/"));
    }

    /*
    -- Parametrized Negative Test
Open page https://practicetestautomation.com/practice-test-login/
Try to log in with correct username and wrong password
And wrong username and correct password
And wrong username and wrong password
And empty username correct password
Verify error message is displayed.
     */

    // Parametrized Negative Test
    @Test(description = "Negative Test")
    @Parameters({"username", "password"})
    public void NegativeTest(String username, String password) throws InterruptedException {
        //Create a soft assert object:
        SoftAssert sa = new SoftAssert();

        // 1) Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // 2) Type username into Username field.
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        // 3) Type password into Password field.
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        // 4) Click Submit button.
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // 5) Verify error message is displayed.
        WebElement errorMessage = driver.findElement(By.id("error"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));

        sa.assertTrue(errorMessage.isDisplayed());

        sa.assertAll();
    }
}
