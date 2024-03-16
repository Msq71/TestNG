package sda.homeworks.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

public class Hw3_HardVsSoftAssertion extends TestBase {
/*  D15HW03:
    Test Case3: Negative Password Test
    Open page https://practicetestautomation.com/practice-test-login/
    Type username student into Username field.
    Type password incorrectPassword into Password field.
    Push Submit button.
    Verify error message is displayed.
    Verify error message text is Your password is invalid! */

    // Test Case3: Negative Password Test
    @Test(description = "SoftAssert")
    public void softAssertion() throws InterruptedException {
        //Create a soft assert object:
        SoftAssert sa = new SoftAssert();

        // 1) Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // 2) Type username student into Username field
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        // 3) Type password incorrectPassword into Password field.
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("incorrectPassword");

        // 4) Push Submit button.
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // 5) Verify error message is displayed.
        WebElement errorMessage = driver.findElement(By.id("error"));
        sa.assertTrue(errorMessage.isDisplayed());

        // 6) Verify error message text is Your password is invalid!
        String expected = "Your password is invalid!";
        String actual = errorMessage.getText();

        sa.assertEquals(actual, expected);

        sa.assertAll();


    }

}
