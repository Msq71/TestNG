package sda.homeworks.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.utilities.ParametrizedBrowserTestBase;

import java.util.List;

public class Hw02 extends ParametrizedBrowserTestBase {
    /*
    Go to URL: https://vziad3.github.io/todo-app/todo-app.html
Checking Box todo-4 and Checking Box todo-5
If both clicks worked, then the following List should be have length 2.
Assert that this is correct
Assert that the todo we added is present in the list
Archiving old todos
If our archive link worked, then the following list should have length 4.
Assert that this is true as well
Doing Cross Browser Testing
     */
    By todo4 = By.name("todo-4");
    By todo5 = By.name("todo-5");
    By todoBox = By.id("todotext");
    By add = By.id("addbutton");

    @Test
    public void test() throws InterruptedException {
        // 1) Go to URL: https://vziad3.github.io/todo-app/todo-app.html
        driver.get("https://vziad3.github.io/todo-app/todo-app.html");

        // 2) Checking Box todo-4 and Checking Box todo-5
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//span[@class='done-false']"));
        int size = checkBoxes.size();
        System.out.println("Size before check td4 & td5 is :" + size);
        driver.findElement(todo4).click();
        driver.findElement(todo5).click();

        size = driver.findElements(By.xpath("//span[@class='done-false']")).size();
        Thread.sleep(1000);

        // 3) Assert that the size of the list has become 3 after checking todo4 & todo5
        System.out.println("Size after check td4 & td5 is :" + size);
        Assert.assertTrue(size == 3);

        // 4) Assert that the todo we added is present in the list
        driver.findElement(todoBox).sendKeys("CheckBox 6");
        driver.findElement(add).click();

        size = driver.findElements(By.xpath("//span[@class='done-false']")).size();
        System.out.println("Size after adding is: " + size);
        Assert.assertTrue(size == 4);
    }

}
