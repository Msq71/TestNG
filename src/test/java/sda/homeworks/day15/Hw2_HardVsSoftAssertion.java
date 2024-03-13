package sda.homeworks.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

public class Hw2_HardVsSoftAssertion extends TestBase {

    /*
        Test Case2: Negative Username Test
        Open page https://practicetestautomation.com/practice-test-login/
        Type username incorrectUser into Username field.
        Type password Password123 into Password field.
        Click Submit button.
        Verify error message is displayed.
        Verify error message text is Your username is invalid!

     */

    //Test Case2: Negative Username Test
    @Test(description = "Soft assertion")
    public void softAssertion() throws InterruptedException {
        //Create a soft assert object:
        SoftAssert sa = new SoftAssert();

        // 1) Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // 2) Type username incorrectUser into Username field.
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("incorrectUser");

        // 3) Type password Password123 into Password field.
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        // 4) Click Submit button.
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // 5) Verify error message is displayed.
        WebElement errorMessage = driver.findElement(By.id("error"));
        sa.assertTrue(errorMessage.isDisplayed());

        // 6) Verify error message text is Your username is invalid!
        String expected = "Your username is invalid!";
        String actual = errorMessage.getText();
        sa.assertEquals(actual, expected);

        sa.assertAll();

    }
}
