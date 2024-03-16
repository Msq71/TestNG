package sda.homeworks.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sda.utilities.TestBase;

public class Hw01 extends TestBase {
    /*
    HW01:
Go to URL: https://www.google.com
Search words: Java, Selenium
Assert get text result est that the result text contains the searched Word.
Run tests from XML file.
     */
    @Test
    @Parameters("wordToSearch")
    public void test1(String searchWord) throws InterruptedException {
        // 1) Go to URL: https://www.google.com
        driver.get("https://www.google.com");
        // 2) Search word: Java
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchWord + Keys.ENTER);
        // 3) Assert that the "Java" Information Box is appearing.
        Thread.sleep(1000);
        WebElement javaBox = driver.findElement(By.xpath("//div[@role='heading'][.='جافا']"));
        Assert.assertTrue(javaBox.isDisplayed());
        // 4) Run tests from XML file.
       // ---> file in SDA2024_TestNg\src\test\java\sda\homeworks\day16\HW01.xml

    }

    @Test
    @Parameters("wordToSearch")
    public void test2(String searchWord) throws InterruptedException {
        // 1) Go to URL: https://www.google.com
        driver.get("https://www.google.com");
        // 2) Search word: Selenium
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchWord + Keys.ENTER);
        // 3) Assert that the first result contain "Selenium".
        Thread.sleep(1000);
        WebElement seleniumText = driver.findElement(By.xpath("//span[.='Selenium'][1]"));
        Assert.assertTrue(seleniumText.isDisplayed());
        // 4) Run tests from XML file.
        // ---> file in SDA2024_TestNg\src\test\java\sda\homeworks\day16\HW01.xml

    }

}
