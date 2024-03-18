package sda.tests.smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

import java.time.Duration;

public class NegativeLoginTest extends TestBase {   //use Data Provider
    @Test(description = "NegativeTest", dataProvider = "invalidCredentials")
    public void NegativeTest(String username, String password) {
        //Create a soft assert object:
        SoftAssert sa = new SoftAssert();
        // 1) Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");
        // 2) Type username incorrectUser into Username field.
        driver.findElement(By.id("username")).sendKeys(username);
        // 3) Type password Password123 into Password field.
        driver.findElement(By.id("password")).sendKeys(password);
        // 4) Click Submit button.
        driver.findElement(By.id("submit")).click();
        // 5) Verify error message is displayed.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement errorMessage = driver.findElement(By.id("error"));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        sa.assertTrue(errorMessage.isDisplayed());
        // 6) Verify error message text is Your username is invalid!
        //String expected = "Your username is invalid!";
        //String actual = errorMessage.getText();
        // sa.assertEquals(actual, expected);
        sa.assertAll();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getData() {
        return new Object[][]{
                {"adm", "admin23*"},
                {"cdmin", "admin123"},
                {"Admin", "Admin123"},
                {"Admin", "asr"},
                {"asef", "admin123"}
        };
    }

}
